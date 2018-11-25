<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.BoardBean" %>
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
			color : white;
		}
		#table1 {
			margin: auto;
			width : 600px;
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
	<form action="boardReply.bo" method="post"  name="boardfrom">
	
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
							질문하기.
						</span>
								<table id="table1" align="center">
									<tr>
										<td id="t1"><label for="BOARD_ANSER">답변자</label></td>
										<td id="t2"><%=session.getAttribute("id")%></td>
									</tr>
											 			
									<tr>
										<td id="t1"><label for="BOARD_TYPE">문의유형</label></td>
										<td id="t2">${boardView.BOARD_TYPE}</td>
									</tr>
					
									<tr>
										<td id="t1"><label for="BOARD_SUBJECT">제 목</label></td>
										<td id="t2">${boardView.BOARD_SUBJECT}의 답변</td>
									</tr>
					
									<tr>
										<td id="t1"><label for="BOARD_CONTENT">답변 내용</label></td>
										<td id="t2"><textarea name="BOARD_CONTENT" rows="20" cols="50" required="required"></textarea></td>
									</tr>
									
									<tr>
										<td>
											<input type="hidden" name="BOARD_ANSER" value="<%=session.getAttribute("id")%>">
											<input type="hidden" name="BOARD_SUBJECT" value="${boardView.BOARD_SUBJECT}의 답변">
											<input type="hidden" name="BOARD_ID" value="${boardView.BOARD_ID}">
											<input type="hidden" name="BOARD_TYPE" value="${boardView.BOARD_TYPE}">
											<input type="hidden" name="BOARD_RE_REF" value="${boardView.BOARD_RE_REF}">
											<input type="hidden" name="BOARD_NUM" value="${boardView.BOARD_NUM}">
											<input type="hidden" name="BOARD_RE_LEV" value="${boardView.BOARD_RE_LEV}">
											<input type="hidden" name="BOARD_RE_SEQ" value="${boardView.BOARD_RE_SEQ}">
										</td>
										<td id="t3">
											<input type="submit" value="문의답변달기">
											<input type="button" onclick="history.back()" value="돌아가기">
										</td>
									</tr>
								</table>
					</div>
			</td>
		</tr>
	</tbody>
	</table>
	
	<footer>404 Life Not Found</footer>
	
	</form>
</body>
</html>