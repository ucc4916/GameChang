<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="been.*" %>
<%@ page import="java.util.*" %>
<%@ page import="methodcode.selectpartdata" %>
    <%@ taglib prefix="c" 

uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
   function sumbit_sel(){
      document.getElementById('em_sel').submit();
   }
   function sumbit_create(){
      document.getElementById('em_create').submit();
   }
</script>
<link rel="stylesheet" href="../css/table.css">
<body>
<h2>견적함</h2>
<form action="createembox.em?id=<%=session.getAttribute("id") %>&path=box" method="post" id="em_create">
<button onclick="submit_create()">견적함 만들기</button>
</form> 
   



<%if(request.getAttribute("arbox")!=null){ 
ArrayList<em_box_userinfo> box=new ArrayList<em_box_userinfo>();
selectpartdata spd=new selectpartdata();
int i=0;
box=((ArrayList<em_box_userinfo>)request.getAttribute("arbox"));
for(em_box_userinfo arbox : box ){
   
   em_part_info epi=(em_part_info)request.getAttribute("part"+i);

  


%>
<form id="em_boxinfo<%=i %>" method="post" action="dday.bo">

<div id="table">
<div class="row">
<span class="cell col1">견적함 번호</span>
<span class="cell col2"><%=arbox.getBox().getNum() %></span>
<span class="cell col3">견적함이름</span>
<span class="cell col4"><%=arbox.getBox().getName() %></span>
</div>
<div class="row">
<span class="cell col1">부품</span>
<span class="cell col2">이름</span>
<span class="cell col3">수량</span>
<span class="cell col4">가격</span>
</div>
<div class="row">
<%if(arbox.getBox().isCpu()){ %>
<span class="cell col1">CPU</span>
<span class="cell col2"><%=epi.getCpu().getMaker() %><%=epi.getCpu().getBrand() %><%=epi.getCpu().getName() %></span>
<span class="cell col3"><%=arbox.getCpu().getCount() %></span>
<span class="cell col4"><%=arbox.getCpu().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=cpu&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getCpu().getNum()%>">삭제</a></span>
<div class="row">
<%}if(arbox.getBox().isMb()){ %>
<span class="cell col1">메인보드</span>
<span class="cell col2"><%=epi.getMb().getMaker() %><%=epi.getMb().getName() %><%=epi.getMb().getChip_group() %><%=epi.getMb().getChip_group_b() %></span>
<span class="cell col3"><%=arbox.getMb().getCount() %></span>
<span class="cell col4"><%=arbox.getMb().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=mb&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getMb().getNum()%>">삭제</a></span>
<%} %>
<div class="row">
<%if(arbox.getBox().isVga()){ %>
<span class="cell col1">그래픽카드</span>
<span class="cell col2"><%=epi.getVb().getMaker()%><%=epi.getVb().getChipmaker() %><%=epi.getVb().getChip() %><%=epi.getVb().getName() %> DDR5 <%=epi.getVb().getRam_mm() %>Gb</span>
<span class="cell col3"><%=arbox.getVga().getCount() %></span>
<span class="cell col4"><%=arbox.getVga().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=vga&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getVb().getNum()%>">삭제</a></span>
<%} %>
<div class="row">
<%if(arbox.getBox().isRam()){ %>
<span class="cell col1">램</span>
<span class="cell col2"><%=epi.getRb().getMaker()%><%=epi.getRb().getKind()%>   <%=epi.getRb().getMm()%>Gb</span>
<span class="cell col3"><%=arbox.getRam().getCount() %></span>
<span class="cell col4"><%=arbox.getRam().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=ram&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getRb().getNum()%>">삭제</a></span>
<%} %>
<div class="row">
<%if(arbox.getBox().isHdd()){ %>
<span class="cell col1">하드디스크</span>
<span class="cell col2"><%=epi.getHb().getMaker()%><%=epi.getHb().getName()%> <%=epi.getHb().getMemory()%>Tb</span>
<span class="cell col3"><%=arbox.getHdd().getCount() %></span>
<span class="cell col4"><%=arbox.getHdd().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=hdd&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getHb().getNum()%>">삭제</a></span>
<%} %>
<div class="row">
<%if(arbox.getBox().isSsd()){ %>
<span class="cell col1">SSD</span>
<span class="cell col2"><%=epi.getSb().getMaker()%><%=epi.getSb().getName()%> <%=epi.getSb().getMemory()%>Gb</span>
<span class="cell col3"><%=arbox.getSsd().getCount() %></span>
<span class="cell col4"><%=arbox.getSsd().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=ssd&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getSb().getNum()%>">삭제</a></span>
<%} %>
<div class="row">
<%if(arbox.getBox().isPow()){ %>
<span class="cell col1">파워</span>
<span class="cell col2"><%=epi.getPow().getMaker()%><%=epi.getPow().getKind()%><%=epi.getPow().getEplus()%>   <%=epi.getPow().getPower()%>W</span>
<span class="cell col3"><%=arbox.getPow().getCount() %></span>
<span class="cell col4"><%=arbox.getPow().getPrice() %></span>
<span class="cell col5"><a  href="deleteempart.em?part=pow&em_num=<%=arbox.getBox().getNum()%>&partnum=<%=epi.getPow().getNum()%>">삭제</a></span>
<%} %>
</div>
</div>
</div>
</div>
</div>

<a href="delembox.em?em_num=<%=arbox.getBox().getNum()%>">견적함삭제</a>
전체가격:<%=arbox.getBox().getPrice()%>
<input type="hidden" name="Dprice" value="<%=arbox.getBox().getPrice()%>">
<button onclick="document.getElementById('em_boxinfo<%=i %>').submit()" class="snip1535">목표금액설정</button>

</form>

<% i++;}} %>










</body>
</html>