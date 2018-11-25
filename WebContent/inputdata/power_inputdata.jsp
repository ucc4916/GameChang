<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="em_adminmodeadd.em?active=part&part=power" method="post">
<table id="power">
	<tbody id="power_table">
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
				종류(atx같은거)
			</td>
			<td>
				<input type="text" name="kind">
			</td>
		
		</tr>
		<tr>
			<td>
				80plus계급
			</td>
			<td>
				<input type="text" name="eplus">
			</td>
		
		</tr>
		<tr>
			<td>
				정격파워
			</td>
			<td>
				<input type="number" name="power">
			</td>
		
		</tr>
		<tr>
			<td>
				4핀 ide 개수
			</td>
			<td>
				<input type="number" name="fpinide_num">
			</td>
		
		</tr>
		<tr>
			<td>
				sata케이블 수
			</td>
			<td>
				<input type="number" name="sata_num">
			</td>
		
		</tr>
		<tr>
			<td>
				PCIE케이블 수
			</td>
			<td>
				<input type="number" name="pcie_num">
			</td>
		
		</tr>
		<tr>
			<td>
				가격
			</td>
			<td>
				<input type="number" name="price">
			</td>
		
		</tr>
	
	
	</tbody>
	
</table>
<input type="submit" value="입력">


</form>
</body>
</html>