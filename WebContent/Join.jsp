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
<script type="text/javascript">

	window.onload=function(){
	document.getElementById("btnSend").onclick=chkData;
	}

	function chkData(){
		if(frm.id.value.length<4){
			frm.id.focus();
		alert("id는 4글자 이상이어야합니다.");
		return;
		}
		if(frm.password.value===""){
			frm.password.focus();
			alert("비밀번호를 입력하세요");
			return;
		}
	
		if(document.frm.name.value===""||isNaN(frm.name.value)===false){
			frm.name.focus();
			alert("이름을 입력하시오");
			return;
		}
	var regExp2=/[0-9]{1,2}$/;
		if(!frm.day.value.match(regExp2)){
			alert("나이를 제대로 확인하십쇼");
			frm.age.focus();
			return;
		}
	var aa=/([\w-\.]+)@((\[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if(!frm.email.value.match(aa)){
			alert("이메일을 정확히 입력하세요!");
			frm.email.focus();
			return;
		}
	frm.action="Join.go";
	frm.method="post";
	frm.submit();
}

</script>
</head>
<body>
	
	<form name="frm">
	
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
						Join
					</span>
				</p>
				
				<p align="center" style="text-align:center;line-height:1.8;">
					<div style = "text-align:center;line-height:1.8" align="center">
						
							<div>
								<table align="center">
									<tbody>
										<tr>
										 	<td style="font-size:20pt;">ID : </td>
										 	<td><input type="text" name="id" placeholder="4자이상" style="width:200px;height:20px;"></td>
										</tr>
									
										<tr>
										 	<td style="font-size:20pt;">PW : </td>
										 	<td><input type="password" name="password" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">이름 : </td>
										 	<td><input type="text" name="name" placeholder="예 : 홍길동" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">전화번호 : </td>
										 	<td><input type="text" name="phonenum" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">주소 : </td>
										 	<td><input type="text" name="address" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">나이 : </td>
										 	<td><input type="text" name="day" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">email : </td>
										 	<td><input type="text" name="email" style="width:200px;height:20px;"></td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">월급 : </td>
										 	<td>
										 		<input type="radio" name="pay" value="0" checked>없으면 이것을 선택
										 		<input type="radio" name="pay" value="40~70">40만원~70만원
										 		<input type="radio" name="pay" value="70~100">70만원~100만원
										 		<input type="radio" name="pay" value="100~160">100만원~160만원<br>
										 		<input type="radio" name="pay" value="160~200">160만원~200만원
										 		<input type="radio" name="pay" value="200~250">200만원~250만원
										 		<input type="radio" name="pay" value="250">250만원이상
										 	</td>
										</tr>
										
										<tr>
										 	<td style="font-size:20pt;">견적여부 : </td>
										 	<td>
										 		<input type="radio" name="cost" value="0" checked>없으면 이것을 선택
										 		<input type="radio" name="cost" value="40">40만원대
										 		<input type="radio" name="cost" value="50">50만원대
										 		<input type="radio" name="cost" value="60">60만원대<br>
										 		<input type="radio" name="cost" value="70">70만원대
										 		<input type="radio" name="cost" value="80">80만원대
										 		<input type="radio" name="cost" value="90">90만원대
										 		<input type="radio" name="cost" value="100">100만원대 이상
										 		<input type="radio" name="cost" value="200">200만원대 이상
										 	</td>
										</tr>

										<tr>
											<td><input type="button" value="회원가입" id="btnSend" style="font-size:15pt;"></td>
											<td><input type="reset" value="다시쓰기" style="font-size:15pt;"></td>
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