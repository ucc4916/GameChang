<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="been.em_cpu" %>
<%@ taglib prefix="c" 

uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function(){
	var x = '<%=request.getParameter("part")%>';
	if(x == 'cpu'){
		document.getElementById(x).style.display="block";
	}
	else if(x == 'mainboard'){
		document.getElementById(x).style.display="block";
	}
	else if(x == 'power'){
		document.getElementById(x).style.display="block";
	}
	else if(x == 'ram'){
		document.getElementById(x).style.display="block";	
		option();
	}
	else if(x == 'hdd'){
		document.getElementById(x).style.display="block";	
		option();
	}
	else if(x == 'ssd'){
		document.getElementById(x).style.display="block";	
		option();
	}
	else if(x == 'vga'){
		document.getElementById(x).style.display="block";	
		option();
	}
}
</script>

<body>

<form></form>
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
				소켓크기(EX:1151,AM4)
			</td>
			<td>
					<input type="text" name="size">
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
					<input type="number" name="l3cashm">(단위:k)
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
				<input type="number" name="l3cashm">(단위:Mhz)
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
				<input type="number" name="ck">(단위:Ghz)
			</td>
		</tr>
		<tr>
			<td>
				최대 코어 클락(동작속도)
			</td>
			<td>
				<input type="number" name="maxck">(단위:Ghz)
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
<table id="mainboard"  style="display:none">
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
				이름
			</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>
				브랜드
			</td>
			<td>
				<input type="text" name="maker">
			</td>
		</tr>
		<tr>
			<td>
				랜지원속도(ex:10기가비트:10g,기가비트:1g,100mbps:100mbps )
			</td>
			<td>
				<input type="number" name="lan">
			</td>
		</tr>
		<tr>
			<td>
				CPU지원사이즈
			</td>
			<td>
				<input type="text" name="cpu_size">
			</td>
		</tr>
		<tr>
			<td>
				칩그룹(b3xx)
			</td>
			<td>
				<input type="text" name="chip_group">
			</td>
		</tr>
		<tr>
			<td>
				칩그룹상세(xx50m,xx50)
			</td>
			<td>
				<input type="text" name="chip_group_b">
			</td>
		</tr>
		<tr>
			<td>
				사용가능 램종류
			</td>
			<td>
				<input type="text" name="ram_kind">
			</td>
		</tr>
		<tr>
			<td>
				파워타입크기
			</td>
			<td>
				<input type="text" name="powertype">
			</td>
		</tr>
		<tr>
			<td>
				sata3 지원개수
			</td>
			<td>
				<input type="number" name="sata3">
			</td>
		</tr>
				<tr>
			<td>
				sata2 지원개수
			</td>
			<td>
				<input type="number" name="sata2">
			</td>
		</tr>
		<tr>
			<td>
				PCIE슬롯수
			</td>
			<td>
				<input type="number" name="pcieslot_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIE3X16개수
			</td>
			<td>
				<input type="number" name="pcie3x16_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIE3X8개수
			</td>
			<td>
				<input type="number" name="pcie3x8_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIE3X1개수
			</td>
			<td>
				<input type="number" name="pcie3x1_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIEX6개수
			</td>
			<td>
				<input type="number" name="pciex6_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIEX4개수
			</td>
			<td>
				<input type="number" name="pciex4_n">
			</td>
		</tr>
		<tr>
			<td>
				PCIEX1개수
			</td>
			<td>
				<input type="number" name="pciex1_n">
			</td>
		</tr>
		<tr>
			<td>
				RAM클락 지원한계
			</td>
			<td>
				<input type="number" name="ram_ck">
			</td>
		</tr>
		<tr>
			<td>
				RAM 최대 메모리
			</td>
			<td>
				<input type="number" name="ram_mm">
			</td>
		</tr>
		<tr>
			<td>
				RAM 슬롯개수
			</td>
			<td>
				<input type="number" name="ram_mnum">
			</td>
		</tr>
		<tr>
			<td>
				RAM 채널수
			</td>
			<td>
				<input type="number" name="ram_ch">
			</td>
		</tr>
		<tr>
			<td>
				M2지원 개수
			</td>
			<td>
				<input type="number" name="m2_num">
			</td>
		</tr>
		<tr>
			<td>
				USB3.1지원개수
			</td>
			<td>
				<input type="number" name="usb1gen">
			</td>
		</tr>
		<tr>
			<td>
				USB3.0지원개수
			</td>
			<td>
				<input type="number" name="usb2gen">
			</td>
		</tr>
		<tr>
			<td>
				PRICE
			</td>
			<td>
				<input type="number" name="price">
			</td>
		</tr>
	</tbody>
</table>
<table id="hdd" style="display:none">
	
	
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
				<input type="number" name="size">
			</td>
		</tr>
		<tr>
			<td>
				버퍼메모리
			</td>
			<td>
				<input type="number" name="platter">(단위:)
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

	
</table>
<table id="ram"   style="display:none">
	
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
<table id="ssd"  style="display:none">
	
	<tbody id="ssd_main">
		<tr>
			<td>
				제조사
			</td>
			<td>
				<select>
					
				</select>
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
<table id="power" style="display:none">
	<tbody id="power_table">
		<tr>
			<td>
				제조사
			</td>
			<td>
				<select>
					
				</select>
			</td>
		
		</tr>
		
		
	
	
	</tbody>
	
</table>

<table id="vga" style="display:none">
	<tbody id="vga_main">
		<tr>
			<td>
				제조사
			</td>
			<td>
				<select>
					
				</select>
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
			<td><input type="number" name="ram_mm<%=i%>">(단위:bit)</td>
		</tr>
		<tr><td>VRAM 메모리크기</td>
			<td><input type="number" name="ram_mm<%=i%>">(단위:GB)</td>
		</tr>
		<tr><td>가격</td>
			<td><input type="number" name="price<%=i%>"></td>
		
		</tr>
	</tbody>
<%} %>
	
</table>









</body>
</html>