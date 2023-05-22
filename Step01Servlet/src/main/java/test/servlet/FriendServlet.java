package test.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1,2,3의 형식을 맞추어서 작성해야한다  **
//3.어떤 경로 요청을 처리할것인지 경로 설정 (반드시 /로 시작해야한다) 

@WebServlet("/friend/list") //이런 요청을 최초처리할때 new가 되는것_  한번만 생성 !

public class FriendServlet extends HttpServlet{	//1.HttpServlet 클래스 상속
	//2. service () 메소드 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.println("<!docutype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=utf-8>");
		pw.println("<title>친구목록</title>");
		pw.println("</head>");
		pw.println("<body>");	
		pw.println("<h1> 친구 목록입니다 </h1>");
		
		pw.println("<ul>");
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		for(String tmp:names) {
			 pw.println("<li>"+tmp+"</li>");
		}
		
		
		pw.println("</ul>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();		
		
		
	}
	
}
