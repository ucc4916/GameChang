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
			height : 300px;
			width : 300px;
		}
		
		table {
			height : 500px;
			width : 800px;
		}
		
		footer {
			text-align : center;
		}
		
		
	</style>
<meta charset="UTF-8">
<title>Game Chang</title>
</head>
<body>

	<form action="main_sel.em" method="post" id="form1">
	
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
						<input name="mainsel" type="hidden" value="recommend">
						<%if(session.getAttribute("id")!=(null)){ %>
						
						<%} %>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<img onclick="document.getElementById('form2').submit()" style="cursor:pointer;" src="추천버튼.jpg">
					</div>
				</td>
			</tr>
		</tbody>
	</table>

	</form>
	
	<form name="idboxform" method="post" action="box_list.em">
		<div align="center">
			<span>
				<%if(session.getAttribute("id")!=(null)){ %>
				<button onclick="documentgetElementById('idboxform')" style="with:100px;height:50px;font-size:15pt;" >
				견적함으로
				</button><br><br><br><br><br>
				<%} %>
			</span>
		</div>
	</form>
	
	<form>
		<div align="center">
			<% if("admin".equals(session.getAttribute("id"))){%>
			<a href="em_adminmode.em">견적관리자모드</a><br><br><br>
			<%} %>
		</div>
	</form>
	
	<form action="main_sel.em" method="post" id="form2">
		<span>
			<input name="mainsel" type="hidden" value="choice">
		</span>
	</form>
	
	<footer>404 Life Not Found</footer>
	
</body>
</html>