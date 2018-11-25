<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="boardWritePro.bo" method="post" enctype="multipart/form-data" name="boardfrom">
	
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
										<td id="t1"><label for="BOARD_ID">아이디</label></td>
										<td id="t2"><%=session.getAttribute("id")%></td>
									
									</tr>
									<input type="hidden" name="BOARD_ID"value="<%=session.getAttribute("id")%>">
									<tr>
										<td id="t1"><label for="BOARD_PASS">비밀번호</label></td>
										<td id="t2"><input type="password" name="BOARD_PASS" required="required"></td>
									</tr>
											 			
									<tr>
										<td id="t1"><label for="BOARD_TYPE">문의유형</label></td>
										<td id="t2"><select name="BOARD_TYPE">
														<option value="select" selected>선택</option>
														<option value="PC-Estimate">PC견적문의</option>
														<option value="Part-timejob">알바문의</option>
														<option value="D-Day">D-Day문의</option>
														<option value="Join">회원정보문의</option>
													</select></td>
									</tr>
					
									<tr>
										<td id="t1"><label for="BOARD_SUBJECT">제 목</label></td>
										<td id="t2"><input type="text" name="BOARD_SUBJECT" required="required"></td>
									</tr>
					
									<tr>
										<td id="t1"><label for="BOARD_CONTENT">내 용</label></td>
										<td id="t2"><textarea name="BOARD_CONTENT" rows="20" cols="50" required="required"></textarea></td></tr>
					
									<tr>
										<td id="t1"><label for="BOARD_FILE">첨부파일</label></td>
										<td id="t2"><input type="file" name="BOARD_FILE"></td>
									</tr>
					
									<tr>
										<td></td>
										<td id="t3"><input type="submit" value="1:1 문의하기">     <input type="button" onclick="history.back()" value="돌아가기"></td>
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