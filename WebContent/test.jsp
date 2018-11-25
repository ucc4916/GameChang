<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@page import="bean.*"%>
    <%@page import="dao.*" %>
    <%@page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
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
		
		#ul {
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
		
		#div_ul_li1 {
			width:186px;
			display : inline;
			text-transform : uppercase;
			padding : 0 10px;
			letter-spacing : 10px;
			font-size : 15pt;
		}
		
		#div_ul_li a {
			text-dacoration : none;
			color : black;
		}
		
		#div_ul_li a:hover {
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
<title>견적사항</title>
</head>

<body>
<form enctype="multipart/form-data">
<header>
		<h1><a href="d.go">Game Chang</a></h1>
	</header>
	
	<nav>
		<ul>
			<li><a href="Introduce.jsp">Introduce</a></li>
			<li><a href="em_main.jsp">PC Estimate</a></li>
			<li><a href="googlemaps.to">Part-time Job</a></li>
			<li><a href="##">D-Day</a></li>
			<li><a href="CustomerService.jsp">Customer Service</a></li>

			<%if((String)session.getAttribute("id")==null){ %>
			<li><a href="Login.jsp">Login & Join</a></li>
				<%}else{ %>
			<li><a href="Mypage.go?id=<%=session.getAttribute("id")%>"><%=session.getAttribute("id")%></a></li><%} %>
		</ul>

	</nav>
	
	<table align="center" border="0" cellspacing="0" cellpadding="1" style="text-align:justify">
	<tbody>
		<tr>
			<td style="width:70px;height:60px;">
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:50pt;color:black;">
					D-Day
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center" border="1px";>
						<ul id="ul">
							<%if(((String)session.getAttribute("id"))!=null){ %>
								<li id="div_ul_li">아이디</li>
								<li id="div_ul_li">견적가격</li>
								<li id="div_ul_li">월급</li>
								<li id="div_ul_li">소요날짜</li>
								<li id="div_ul_li">시작일</li>
								<li id="div_ul_li">종료예상일</li> <br>

								<c:forEach var="Dday" items="${Dday}">
								<li id="div_ul_li1">${Dday.id}</li>
								<li id="div_ul_li1">${Dday.cost}원</li>
								<li id="div_ul_li1">
									<a href="#" onclick="window.open('paylist.go?JOB_MONEY=${Dday.pay}&COMPANY_INFORMATION=${Dday.information}','','top=100px,left=700px,,height=300px,width=300px,menubar=no,resizable=no,status=no,scrollbars=no,titlebar=no,toolbar=no')">${Dday.pay}</a>원</li>
								<li id="div_ul_li1">${Dday.countday}일</li>
								<li id="div_ul_li1">${Dday.startday}</li>
								<li id="div_ul_li1">${Dday.endday}</li><br>
								</c:forEach>
								
								<%} else{ %>
								<p align="center" style="text-align:center;line-height:1.8;">
									<span style="font-size:15pt;">
										D-Day Service 를 사용하실려면 Login을 해주세요.
									</span>
								</p>
							<li id="div_ul_li"><a href="Login.jsp">로그인하러 가기</a></li>
							<%}%>
							
							</ul>
								<li id="div_ul_li">돌아가기:<input type="button"onclick="location.href='d.go'" value="돌아가기"></li>
					</div>
		 	</td>
		</tr>
	</tbody>
</table>
<footer>404 Life Not Found</footer>
</body>


</html>