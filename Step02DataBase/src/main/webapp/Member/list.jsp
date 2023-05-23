<%@page import="java.util.List"%>
<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
   //MemberDao 객체의 참조값 얻어오기
   MemberDao dao = MemberDao.getInstance();
   //회원 목록 얻어오기
   List<MemberDto> list = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>/member/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
   <div class="container">
      <h1>회원 목록 입니다.</h1>
      <table class = "table caption-top">
         <caption>회원목록</caption>
         <thead>
            <tr>
               <th >번호</th>
               <th>이름</th>
               <th>주소</th>
            </tr>
         </thead>
         <tbody>
         <%for(MemberDto tmp : list ) { %>
            <tr>
               <td><%=tmp.getNum() %></td>
               <td><%=tmp.getName() %></td>
               <td><%=tmp.getAddr() %></td>
            </tr>
         <%} %>
         </tbody>
      </table>      
   </div>
</body>
</html>