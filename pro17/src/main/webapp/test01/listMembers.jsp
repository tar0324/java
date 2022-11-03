<%@ page language="java" contentType="text/html; charset=UTF-8"
	import=" java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"
	isELIgnored="false"    
%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style type="text/css">
	.cls1 {
		font-size: 40px;
		text-align: center;
	}
</style>
</head>
<body>
<h1 class="cls1">회원정보</h1>
<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="5%"><b>이름</b></td>
			<td width="5%"><b>이메일</b></td>
			<td width="5%"><b>주소</b></td>
		</tr>
	<c:choose>
		<c:when test="${ membersList == null }">
			<tr align="center">
				<td colspan=5>
				 	<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		</c:when>
		<c:when test="${membersList != null }">
			<c:forEach var="mem" items="${membersList }">
				<tr align="center">
					<td width="7%">${mem.id } </td>
					<td width="7%">${mem.pwd } </td>
					<td width="7%">${mem.name } </td>
					<td width="7%">${mem.email } </td>
					<td width="7%">${mem.joinDate } </td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
</table>
<a href="#" align="center">
	<p class="cls2"> 회원 가입하기 </p>
</a>
</body>
</html>