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
		
		table {
			height : 750px;
			width : 1200px;
		}

		footer {
			text-align : center;
		}
	</style>
<meta charset="UTF-8">
<title>Game Chang</title>
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
	
	<table align="center" border="0" cellspacing="0" cellpadding="1" style="text-align:justify">
	<tbody>
		<tr>
			<td style="width:70px;height:60px;">
				<div style = "text-align:center;line-height:1.8" align="center">
					
						<img src="game_chang_change.jpg" id="img">
					
				</div>
		
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:18pt;color:black;">
						<i>Game Chang이 되기 위한 첫걸음</i>
					</span>
				</p>
				
				<p align="justify" style="text-align:justify;line-height:2.2;">
					<span style="font-size:18px;">&nbsp;</span>
				</p>
				
				<p align="justify" style="text-align:justify;line-height:.8;">
					<span style="font-size:18px;">&nbsp;</span>
				</p>
				
				<p align="justify" style="text-align:center;line-height:2.2;">
					<span style="font-size:18px;">
						<span style="color:red";>G</span>ame <span style="color:red";>C</span>hang에 오신 것을 환영합니다.
						임시 - 저희 Game Chang 에서는 여러분의 게임, 취미생활에 한걸음 더 나은 환경을 제공하기 위해 최선을 다할것을 약속드리며
						저희 Homepage의 목적은 여러분들이 게임을 하기 위해. 또한 사무를 하기 위해 사용하는 PC의 제품(CPU. 메인보드. 그래픽카드 등.)의 견적을
						내어드리며 그에 따른 알바를 소개해드리는 것이 저희의 목적입니다.&nbsp;
					</span>
				</p>
				</td>
			</tr>
			
			
	</tbody>
	</table>
	
	
	<footer>404 Life Not Found</footer>
	
	</form>
	
</body>
</html>