<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="bean.BoardBean" %>
   <%@ page import="dao.BoardDAO" %>
   <%@ page import="java.util.*" %>
   <%@ page import="java.util.ArrayList" %>
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
		
		
		#t1 {
			background-color: black;
			color : white;
			text-align : center;
			width : 150px;
		}
		#t2 {
			background-color : gray;
			align : left;
			width : 500px;
		}
		#table1 {
			margin: auto;
			/* width : auto; */
			height : auto;
		}
		#t3 {
			text-align : center;
		}
		
		
		footer {
			text-align : center;
		}
	</style>

<head>
<meta charset="UTF-8">
<title>Game Chang</title>
</head>
<body>
	<form action="boardReplyForm.bo?boardNum=${boardView.BOARD_NUM}" method="post" name="boardfrom">
	
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
	
	<table align="center" border="0" cellspacing="0" cellpadding="1" style="text-align:justify">
	<tbody>
		<tr>
			<td style="width:70px;height:60px;">
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:50pt;color:black;">
						Customer Service
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center">
						<span style="font-size:20pt;color:black;">
							문의 내용 보기.
						</span>
						
						
							<table id="table1" border="1" align="center">
								<tr style="width:500px;height:50px;forn-size:20pt;background-color:gray;color:white;">
									<td style="width:250px;height:30px;">문의유형</td>
									<td style="width:250px;height:30px;">제목</td>
									<td style="width:250px;height:30px;">내용</td>
									<td style="width:250px;height:30px;">문의날짜</td>
								</tr>
								
								<tr>
									<td>${boardView.BOARD_TYPE}</td>
									<td>${boardView.BOARD_SUBJECT}</td>
									<td>${boardView.BOARD_CONTENT }</td>
									<td>${boardView.BOARD_DATE }</td>
								</tr>
								
								<tr>
									<td colspan="2">첨부파일</td>
									<td colspan="2"><a href="boardFileDown.bo?downFile=${boardView.BOARD_FILE }">${boardView.BOARD_FILE }</a></td>
								</tr>
							</table>
							
							<%if(((String)session.getAttribute("id"))!=null){ %>
								<%if(((String)session.getAttribute("id")).equals("admin")){ %>
								<input type="submit" value="문의 답변 달기">
								<input type="button" onclick="history.back();" value="돌아가기">
								<%} else {%>
								<input type="button" onclick="history.back();" value="돌아가기">
 								<%} }%>
					</div>
			</td>
		</tr>
	</tbody>
	</table>
	
	<footer>404 Life Not Found</footer>
	
	</form>
</body>
</html>