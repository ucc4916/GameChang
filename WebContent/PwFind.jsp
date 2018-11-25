<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form action="find.go" method="post">
	
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
					<span style="font-size:35pt;">
						비밀번호를 찾기 위해 <br>아이디와 이름을 입력해주세요.
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center">
						
							<div>
								<table align="center">
									<tbody>
										<tr>
											<td style="font-size:30pt;">ID : </td>
											<td><input type="text" name="id" style="width:300px;height:30px;"></td>
										</tr>
										
										<tr>
											<td style="font-size:30pt;">이름 : </td>
											<td><input type="text" name="name" style="width:300px;height:30px;"></td>
										</tr>
										
										<tr>
											<td><input type="submit" value="검색" style="font-size:15pt;"></td>
											<td><input type="button" onclick="location.href='Login.jsp'" value="뒤로가기" style="font-size:15pt;"></td>
										</tr>

										
									</tbody>					
								</table>
							</div>
					</div>
					</p>
			  </td>
		</tr>
	</tbody>
	
	</table>

	<footer>404 Life Not Found</footer>
	
	</form>
</body>
</html>