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
		
		#div_ul_li {
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
				<p align="center" style="text-align:center;line-height:1.8;">
					<span style="font-size:50pt;color:black;">
						Customer Service
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center">
						<ul>
						
							<%if(((String)session.getAttribute("id"))!=null){ %>
								<%if(((String)session.getAttribute("id")).equals("admin")){ %>
								<li id="div_ul_li"><a href="boardList.bo">1:1 문의 전체보기</a></li>
								<%}else{%>
								<li id="div_ul_li"><a href="CustomerService_Q.jsp">1:1 문의하기</a></li>
								<li id="div_ul_li"><a href="boardList.bo">1:1 문의 답변보기</a></li>
								<%} %>
								<%} else{ %>
								<p align="center" style="text-align:center;line-height:1.8;">
									<span style="font-size:15pt;">
										1:1 문의를 사용하실려면 Login을 해주세요.
									</span>
								</p>
							<li id="div_ul_li"><a href="Login.jsp">로그인하러 가기</a></li>
							
							<%}%>
								
						</ul>
							
					</div>
			  </td>
		</tr>
	</tbody>
	</table>
	
	<footer>404 Life Not Found</footer>
	
	</form>
</body>
</html>