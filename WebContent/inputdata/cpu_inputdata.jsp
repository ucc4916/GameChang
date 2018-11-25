<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
 <%@ page import="java.util.*" %>
      <%@ page import="been.em_cpu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<body>

<form action="em_adminmodeadd.em?active=part&part=cpu" method="post">
<table id="cpu" >
	<tbody>
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
				코드네임(ex:스카이레이크,고다바리)
			</td>
			<td>
				<input type="text" name="codename">
			</td>
		</tr>
		<tr>
			<td>
				브랜드(세대)
			</td>
			<td>
					<input type="text" name="brand">
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
				소켓크기(EX:1151,AM4)
			</td>
			<td>
					<input type="text" name="size">
			</td>
		</tr>
		<tr>
			<td>
				오버클럭여부(true o)
			</td>
			<td>
					가능<input type="radio" name="over" value="true">
					불가능<input type="radio" name="over" value="false">
			</td>
		</tr>
		
		<tr>
			<td>
				코어수
			</td>
			<td>
					<input type="number" name="core">
			</td>
		
		</tr>
		<tr>
			<td>
				스레드 수
			</td>
			<td>
					<input type="number" name="td">
			</td>
		</tr>
		<tr>
			<td>
				L2캐시메모리크기
			</td>
			<td>
					<input type="number" name="l2cashm">(단위:k)
			</td>
		</tr>
		<tr>
			<td>
				L3캐시메모리크기
			</td>
			<td>
					<input type="number" name="l3cashm">(단위:M)
			</td>
		</tr>
		<tr>
			<td>
				전력사용량
			</td>
			<td>
				<input type="number" name="tdp">(단위:W)
			</td>
		</tr>
		<tr>
			<td>
				시스템버스
			</td>
			<td>
				<input type="number" name="sysbus">(단위:Mhz)
			</td>
		</tr>
		<tr>
			<td>
				그래픽여부
			</td>
			<td>
				있음<input type="radio" name="gpu" value="true"><br>
				있음<input type="radio" name="gpu" value="false">
			</td>
		</tr>
		<tr>
			<td>
				코어 클락(동작속도)
			</td>
			<td>
				<input type="text" name="ck">(단위:Ghz)
			</td>
		</tr>
		<tr>
			<td>
				최대 코어 클락(동작속도)
			</td>
			<td>
				<input type="text" name="maxck">(단위:Ghz)
			</td>
		</tr>
		<tr>
			<td>
				가격
			</td>
			<td>
				<input type="number" name="price">(단위:원)
			</td>
		</tr>
	</tbody>
</table>

<input type="submit" value="입력!">
</form>



</body>
</html>