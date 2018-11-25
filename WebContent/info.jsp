<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.Loginbean" %>
<%@page import="dao.*" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
		
		img {
			height : 600px;
			width : 950px;
		}
		
		
		
		footer {
			text-align : center;
		}
		
		
	</style>
<meta charset="UTF-8">
<title>Game Chang</title>
</head>
<body>
	
	<form action="./ReWrite.go?id=${login.id}" method=post>
	<c:set var="login"  value="${login}"/>
	
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

	<table align="center" border="0" cellspacing="0" cellpadding="1" style="text-align:justify;height:750px;width:1200px;">
	<tbody>
		<tr>
			<td style="width:70px;height:60px;">
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:50pt;">
						My Info.
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center">
						
							<div>
								<table align="center">
									<tbody text-align="center">
										<tr style="font-size:15pt;">
										 	<td>아이디 : </td>
										 	<td>${login.id}</td>
										</tr>
									
										<tr style="font-size:15pt;">
										 	<td>이름 : </td>
										 	<td>${login.name}</td>
										</tr>
										
										<tr style="font-size:15pt;">
										 	<td>이메일 : </td>
										 	<td>${login.email}</td>
										</tr>
										
										<tr style="font-size:15pt;">
										 	<td>전화번호 : </td>
										 	<td>${login.phonenum}</td>
										</tr>
										
										<tr style="font-size:15pt;">
										 	<td>주소 : </td>
										 	<td>${login.address}</td>
										</tr>
										
										<tr style="font-size:15pt;">
										 	<td>나이 : </td>
										 	<td>${login.day}</td>
										</tr>
										
										<tr style="font-size:15pt;">
										 	<td>월급 : </td>
										 	<td>${login.pay}</td>
										</tr>
										
										<tr>
											<td><input type="submit" value="정보수정" style="font-size:12pt;"></td>
											<td><input type="button" onclick="location.href='Mypage.jsp'" value="돌아가기" style="font-size:12pt;"></td>
										</tr>
										
									</tbody>					
								</table>
							</div>
					</div>
			  </td>
		</tr>
	</tbody>
	
	</table>

	<footer>404 Life Not Found</footer>
	
	</form>
	
</body>
</html>