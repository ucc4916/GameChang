<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action="em_adminmodeadd.em?active=part&part=ram&option=<%=request.getParameter("optionnum")%>" method="post">
<table id="ram" >
	
	<tbody id="ram_main">
		<tr>
			<td>
				제조사
			</td>
			<td>
				<input type="text" name="maker">
			</td>
		
		</tr>
		<tr>
			<td>
				메모리 종류
			</td>
			<td>
				<input type="text" name="kind">
			</td>
		
		</tr>
		
		<tr>
			<td>
				동작속도
			</td>
			<td>
				<input type="number" name="ck">(단위:Mhz)
			</td>
		</tr>
		</tbody>
			<%
	for(int i=1;i<=Integer.parseInt(request.getParameter("optionnum"));i++){ %>
	<tbody id="ram_option<%=i%>">
		<tr><td>메모리크기</td>
			<td><input type="number" name="memory<%=i%>">(단위:GB)</td>
		</tr>
		<tr><td>가격</td>
			<td><input type="number" name="price<%=i%>"></td>
	</tbody>
<%} %>

</table>
<input type="submit" value="입력!!">
</form>

</body>
</html>