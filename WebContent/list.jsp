<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="bean.Loginbean" %>
    <%@page import="dao.*" %>
    <%@page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    
    %>
<!DOCTYPE html>
<html>
<style>
	
		body {
			background-color : #E1E1E1;
		}
		
		header {
			text-align : center;
			
		}
		
		header a {
			text-dacoration : none;
			color : red;
		}
		
		header a:hover{
			text-decoration : underline;
		}
		
		nav {
			margin : 10px;
		}
		
		nav ul {
			list-style : none;
			text-align : center;
			border-top : 1px solid red;
			border-bottom : 1px solid red;
			padding : 10px 0;
		}
		
		nav ul li {
			display : inline;
			text-transform : uppercase;
			padding : 0 10px;
			letter-spacing : 10px;
		}
		
		nav ul a {
		
			text-dacoration : none;
			color : black;
		}
		
		nav ul li a:hover{
			text-decoration : underline;
		}
		
		table {
			height : 750px;
			width : 1200px;
		}
		#ul{
		border : 1px solid black;
		}
		#div_ul_li {
		width:186px;
			display : inline;
			text-transform : uppercase;
			padding : 0 10px;
			letter-spacing : 10px;
			font-size : 20pt;
			
		}
		
		#div_ul_li a {
			text-dacoration : none;
			color : black;
		}
		
		#div_ul_li a:hover{
			text-decoration : underline;
		}
		
		
		
		div p {
			list-style : none;
		}
		
		
		footer {
			text-align : center;
		}
	</style>

<head>
<meta charset="UTF-8">
<title>관리자 공간</title>
</head>
<body>
<form enctype="multipart/form-data">
<header>
		<h1><a href="MainForm.jsp">Game Chang</a></h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="Introduce.jsp">Introduce</a></li>
			<li><a href="em_main.jsp">PC Estimate</a></li>
			<li><a href="googlemaps.to">Part-time Job</a></li>
			<li><a href="Dday.go?id=<%=session.getAttribute("id")%>">D-Day</a></li>
			<li><a href="CustomerService.jsp">Customer Service</a></li>

			<%if((String)session.getAttribute("id")==null){ %>
			<li><a href="Login.jsp">Login & Join</a></li>
				<%}else{ %>
			<li><a href="Mypage.go?id=<%=session.getAttribute("id")%>"><%=session.getAttribute("id")%></a></li><%} %>
		</ul>

	</nav>
<tbody>

<tr>
	<td style="width:70px;height:60px;">
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:50pt;color:black;">
					전체 회원목록</span></p>
					<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center" border="1px";>
						<ul>
						
<c:forEach var="login" items ="${login}">
<li id="div_ul_li"><a href="View.go?id=${login.id}">${login.id}</a></li>
<li id="div_ul_li"><a href="Delete2.go?id=${login.id}">삭제</a></li>
<br>
</c:forEach></ul>
<li id="div_ul_li">돌아가기:<input type="button"onclick="location.href='d.go'"value="돌아가기"></li>
</div>
		 </td>
		</tr>
	</tbody>

<footer>404 Life Not Found</footer>
</body>
</html>