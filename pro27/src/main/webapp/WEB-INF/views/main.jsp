<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<style>
	.no-underline{
		text-decoration:none;
	}
</style>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script scr="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<h1>메인 페이지 입니다!!</h1>

</body>
</html>