<%@page import="test.util.DbcpBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%new DbcpBean(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index.jsp</title>
</head>
<body>
   <div class="container">
      <h1>하이요</h1>
      <ul>
         <li><a href = "member/list.jsp">회원목록보기</a>
      </ul>
   </div>
   
</body>
</html>