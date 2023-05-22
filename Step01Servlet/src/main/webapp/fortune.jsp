
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	
	String[] fortunes={"동쪽으로 가면 귀인을 만나요",
			"오늘은 집에만 계세요",
			"너무 멀리가지 마세요",
			"오늘은 뭘해되 되는 날이에요",
			"로또 당첨!!"
	};
	Random ran = new Random();
	int ranNum = ran.nextInt(5);
%>
	<p> <% out.print(fortunes[ranNum]); %> </p>
	
	
	<p> <%=10 %></p>
	<p> <%=true %></p>
	<p> <%="김" %></p>
	<p> <%=fortunes[ranNum] %></p>
</body>
</html>