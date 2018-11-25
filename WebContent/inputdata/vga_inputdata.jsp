<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="em_adminmodeadd.em?active=part&part=vga&option=<%=request.getParameter("optionnum") %>" method="post">
<table id="vga" >
	<tbody id="vga_main">
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
				이름(있을경우 ex:stormx,hurricane)
			</td>
			<td>
				<input type="text" name="name" value="#">
			</td>
		</tr>
		<tr>
			<td>
				인터페이스(pcie3.0x16)
			</td>
			<td>
				<input type="text" name="itf" value="pcie3.0x16">
			</td>
		</tr>
		<tr>
			<td>
				칩(gtx1080,rxvega64)
			</td>
			<td>
				<input type="text" name="chip">
			</td>
		</tr>
		<tr>
			<td>
				칩그룹(gtx10xx,RX 5xx)
			</td>
			<td>
				<input type="text" name="chipgroup">
			</td>
		</tr>
		<tr>
			<td>
				칩제조사(nvidia,amd)
			</td>
			<td>
				<input type="text" name="chipmaker">
			</td>
		</tr>
		<tr>
			<td>
				GPU속도
			</td>
			<td>
				<input type="text" name="ck">
			</td>
		</tr>
		<tr>
			<td>
				부스트속도
			</td>
			<td>
				<input type="text" name="maxck">
			</td>
		</tr>
		<tr>
			<td>
				부가기능
			</td>
			<td>
				<input type="text" name="support">
			</td>
		</tr>
		<tr>
			<td>
				쉐이더
			</td>
			<td>
				<input type="number" name="shaders">
			</td>
		</tr>
		<tr>
			<td>
				TMU
			</td>
			<td>
				<input type="number" name="tmus">
			</td>
		</tr>
		<tr>
			<td>
				ROP
			</td>
			<td>
				<input type="number" name="rops">
			</td>
		</tr>
		<tr>
			<td>
				높이
			</td>
			<td>
				<input type="number" name="high">
			</td>
		</tr>
		<tr>
			<td>
				길이
			</td>
			<td>
				<input type="number" name="length">
			</td>
		</tr>
		<tr>
			<td>
				사이즈
			</td>
			<td>
				<input type="text" name="size">
			</td>
		</tr>
		
		<tr>
			<td>
				hdmi,displayport 지원 여부
			</td>
			
			<td>
				디스플레이포트만 지원<input type="radio" name="hdmi" value="displayport">
				hdmi포트 만 지원 <input type="radio" name="hdmi" value="hdmi">
				모두 지원<input type="radio" name="hdmi" value="all">			
			</td>
		</tr>
	</tbody>
	
		<%
	for(int i=1;i<=Integer.parseInt(request.getParameter("optionnum"));i++){ %>
	<tbody id="vga_option<%=i%>">
	<tr><td>VRAM 종류</td>
			<td><input type="text" name="kind<%=i%>">(단위:GB)</td>
		</tr>
	<tr><td>VRAM 동작속도</td>
			<td><input type="number" name="ram_ck<%=i%>">(단위:Mhz)</td>
		</tr>
		<tr><td>VRAM 버스</td>
			<td><input type="number" name="ram_bus<%=i%>">(단위:bit)</td>
		</tr>
		<tr><td>VRAM 메모리크기</td>
			<td><input type="number" name="ram_mm<%=i%>">(단위:GB)</td>
		</tr>
		<tr><td>스트림프로세서 </td>
			<td><input type="number" name="str<%=i%>">(단위:개)</td>
		</tr>
		<tr><td>정격사용량</td>
			<td><input type="number" name="tdp<%=i%>">(단위:w)</td>
		
		</tr>
		
		<tr><td>가격</td>
			<td><input type="number" name="price<%=i%>"></td>
		
		</tr>
	</tbody>
<%} %>
	
</table>
<input type="submit" value="입력">
</form>
</body>
</html>