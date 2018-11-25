<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="bean.*" %>
    <%@page import="dao.*" %>
    <%@page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language="javascript">
function closeWindow(){
window.close();
}
</script>
<title>선택알바정보</title>
</head>
<body onclick="javascript:closeWindow();">
<h2>클릭시 꺼집니다.</h2>
<c:forEach var="ALBA" items="${ALBA}">
알바장소: ${ALBA.COMPANY_INFORMATION}<br>
알바종류:${ALBA.JOB_FAMILY}<br>
직 위:${ALBA.JOB_GESTALT}<br>
기 간:${ALBA.JOB_DAY}<br>
타 임:${ALBA.JOB_TIME}<br>
알바 비:${ALBA.JOB_MONEY}<br>
</c:forEach>

</body>
</html>