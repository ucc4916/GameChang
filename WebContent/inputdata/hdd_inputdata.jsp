<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="em_adminmodeadd.em?active=part&part=hdd&option=<%=request.getParameter("optionnum") %>" method="post">
<table id="hdd">
	
	
	<tbody id="hdd_main">
	
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
				종류(LAP,DESK,NAS,CCTV..)
			</td>
			<td>
				<input type="text" name="kind">
			</td>
		</tr>
		<tr>
			<td>
				이름(회사이름과 용량제외)
			</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>
				인터페이스(sata3같은 정보)
			</td>
			<td>
				<input type="text" name="itf">
			</td>
		</tr>
		<tr>
			<td>
				회전수
			</td>
			<td>
				<input type="number" name="platter">(단위:Rpm)
			</td>
		</tr>
		<tr>
			<td>
				디스크 개수
			</td>
			<td>
				<input type="number" name="disk_num">(단위:장)
			</td>
		</tr>
		<tr>
			<td>
				크기(ex:3.5형)
			</td>
			<td>
				<input type="text" name="size">
			</td>
		</tr>
		<tr>
			<td>
				버퍼메모리
			</td>
			<td>
				<input type="number" name="buffer_mm">(단위:)
			</td>
		</tr>
	</tbody>
	
	<%
	for(int i=1;i<=Integer.parseInt(request.getParameter("optionnum"));i++){ %>
	<tbody id="hdd_option<%=i%>">
		<tr><td>메모리크기</td>
			<td><input type="number" name="memory<%=i%>">(단위:GB)</td>
		</tr>
		<tr><td>가격</td>
			<td><input type="number" name="price<%=i%>"></td>
		
		</tr>
	</tbody>
<%} %>

	<input type="submit" value="입력!">
</table>




</form>
</body>
</html>