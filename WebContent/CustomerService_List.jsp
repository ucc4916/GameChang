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
			width : auto;
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
	<form action="boardList.bo" method="post" enctype="multipart/form-data" name="boardfrom">
	
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
							문의 내역 보기.
						</span>
						
						
							<table id="table1" border="1" align="center">
								<tr style="width:300px;height:50px;forn-size:20pt;background-color:gray;color:white;">
									<td>번호</td>
									<td>작성자</td>
									<td>문의유형</td>
									<td>제목</td>
									<td>날짜</td>
									<td>조회수</td>
								</tr>
								
								<%
									ArrayList<BoardBean> boardList = (ArrayList<BoardBean>)request.getAttribute("boardList");
								%>
								<% for(int i=0;i<boardList.size();i++){ %>
								<tr>
									<td><%=boardList.get(i).getBOARD_NUM()%></td>
									<td>
									<%if(boardList.get(i).getBOARD_RE_LEV()!=0){ %>
									<%=boardList.get(i).getBOARD_ANSER() %>
								
								<%}else{ %>
								<%=boardList.get(i).getBOARD_ID() %>
								<%} %>
									</td>
									<td><%=boardList.get(i).getBOARD_TYPE() %></td>
									<td>	
									<!-- 글의 레벨 값(원글, 답글, 답글의 답글)에 따라 들여쓰기를 하는 부분 -->
									<%if(boardList.get(i).getBOARD_RE_LEV()!=0){ %>
									<%for(int a=0;a<=boardList.get(i).getBOARD_RE_LEV()*1;a++){ %>
										&nbsp;
									<%} %>
										→ [Re:]
									<%}else{ %>
									<%} %>
										<a href="boardDetail.bo?boardNum=<%=boardList.get(i).getBOARD_NUM() %>"><%=boardList.get(i).getBOARD_SUBJECT() %></a>
									</td>
									<td><%=boardList.get(i).getBOARD_DATE() %></td>
									<td><%=boardList.get(i).getBOARD_READCOUNT() %></td>
								</tr>
								<%} %>
							</table>
							
							<input type="button" onclick="history.back()" value="돌아가기">
					</div>
			</td>
		</tr>
	</tbody>
	</table>
	
	<footer>404 Life Not Found</footer>
	
	</form>
</body>
</html>