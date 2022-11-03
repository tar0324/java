<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동' }" scope="page" />
<c:set var="age" value="${22}" scope="page" />
<c:set var="height" value="${177 }" scope="page" />
<c:remove var="age" />
<c:remove var="height" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력 창</title>
<style type="text/css">
	table,tr,td,th {
		border : 1px solid black;
	}
	td {
		width:150px;
	}
	#tr1 {
		background-color:#33FF33;
	}
</style>
</head>
<body>

<table align="center">
	<tr align="center" id="tr1">
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>키</th>
	</tr>
	<tr align="center">
		<td>${id}</td>
		<td>${pwd}</td>
		<td>${name}</td>
		<td>${age}</td>
		<td>${height}</td>
	</tr>
</table>

</body>
</html>