<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	isELIgnored="false"    
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<c:choose>
	<c:when test="${empty param.id }">
		<a href="login.jsp">로그인하러가기</a>
	</c:when>
	<c:otherwise>
		<h1>${param.id }님 !!! 환영합니다😆😆</h1>
	</c:otherwise>
</c:choose>

</body>
</html>