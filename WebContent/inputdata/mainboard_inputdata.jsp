<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="em_adminmodeadd.em?active=part&part=mainboard" method="post">

<table id="mainboard">
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
				<input type="text" name="brand">
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
<input type="submit" value="입력">
</form>

</body>
</html>