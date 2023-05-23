package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DbcpBean;

/*
 * Application 전역에서 MemberDao 객체는 오직 한개만 생성해서 사용하도록 구조를 만들어야 한다.
 * 1. 외부에서 객체 생성하지 못하도록 생성자의 접근 지정자는 private : 외부에서 호출이 안됨 !
 *MemberDao객체의 참조값이 필요하다면 MemberDao dao = MemberDao.getinstance(); 이렇게 호출해야됨 
 * 2. 자신의 참조값을 저장할수  있는 static 필드 만들기
 * 3. 자신의 참조값을 리턴해주는 public static 메소드 만들기
 * dao에서는 connection이 필요하기 때문에 커넥션은 유한한 작업이기때문에 dao객체가 너무 많이 만들어져 있으면 
 * 효율적으로 활용 할 수 없기 때문에 하나만 만들어서 사용하기 위해 private로 만듬 
 */
public class MemberDao {
	//2.
	private static MemberDao dao;
	//1.
	private MemberDao() {}
		//3.
		public static MemberDao getInstance() {
			//서버 시작후 최초 요청이라면 
			//if(MemberDao.dao==null) {
			if(dao==null) {
				//객체를 생성해서 static필드에 저장해 놓는다.
				dao=new MemberDao();
				//MemberDao.dao=new MemberDao();
			}
			//필드에 저장된 참조값 리턴해주기
			return dao;
		}
		//회원 목록을 리턴하는 메소드 
		public List<MemberDto> getList(){
			List<MemberDto> list = new ArrayList<>();
			
			//필요한 객체의 참조값을 담을 지역 변수 미리 만들기 
			Connection conn = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				
				//DbcpEean 객체를 이용해서 Connectiob 객체를 얻어온다 (Connectio Pool에서 얻어오기)
				
				conn= new DbcpBean().getConn();
				//실행할 sql문
				String sql=" select num, name, addr"
						+ " from member"
						+ " order by desc";
				pstmt=conn.prepareStatement(sql);
				//sql문이 미완성이라면 여기서 완성
				
				//select문 수행하고 결과값 받아오기
				rs =pstmt.executeQuery();
				//반복문 돌면서 ResultSet에 담긴 내용 추출
				while(rs.next()) {
					//resultSet에 cursor가 위치 한 곳의 칼럼 정보를 얻어와서 MemberDto객체에 담고 
					MemberDto dto = new MemberDto();
					dto.setNum(rs.getInt("num"));
					dto.setName(rs.getString("name"));
					dto.setAddr(rs.getString("addr"));
					//ArrayList 객체에 누적 시키기 
					list.add(dto);
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();//Connection 이 Connection Pool에 반납된다
				}catch(Exception e) {
					
				}
			}
			return list;
		}
	}

