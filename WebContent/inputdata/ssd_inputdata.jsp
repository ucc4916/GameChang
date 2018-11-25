<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="em_adminmodeadd.em?active=part&part=ssd&option=<%=request.getParameter("optionnum") %>" method="post">
<table id="ssd" >
	
	<tbody id="ssd_main">
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
				종류(tlc토글)
			</td>
			<td>
				<input type="text" name="kind">
			</td>
		
		</tr>
		<tr>
			<td>
				이름
			</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>
				읽기속도
			</td>
			<td>
				<input type="number" name="read">
			</td>
		
		</tr>
		<tr>
			<td>
				쓰기속도
			</td>
			<td>
				<input type="number" name="write">
			</td>
		
		</tr>
		<tr>
			<td>
				읽기IOPS
			</td>
			<td>
				<input type="number" name="read_iops">
			</td>
		
		</tr>
		<tr>
			<td>
				쓰기IOPS
			</td>
			<td>
				<input type="number" name="write_iops">
			</td>
		
		</tr>
		<tr>
			<td>
				SSD의 캐시메모리의 크기
			</td>
			<td>
				<input type="number" name="dram">
			</td>
		
		</tr>
		<tr>
			<td>
				수명
			</td>
			<td>
				<input type="number" name="life">
			</td>
		
		</tr>
		
		</tbody>
	<%
	for(int i=1;i<=Integer.parseInt(request.getParameter("optionnum"));i++){ %>
	<tbody id="ssd_option<%=i%>">
		<tr><td>메모리크기</td>
			<td><input type="number" name="memory<%=i%>">(단위:GB)</td>
		</tr>
		<tr><td>가격</td>
			<td><input type="number" name="price<%=i%>"></td>
		
		</tr>
	</tbody>
<%} %>
</table>
<input type="submit" value="입력!">


</form>
</body>
</html>