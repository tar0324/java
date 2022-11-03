<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:redirect url="member1.jsp" >
		<c:param name="id" value="${'kim' }" />
		<c:param name="pwd" value="${'12345' }" />
		<c:param name="name" value="${'김자바' }" />
		<c:param name="email" value="${'kim@test.com' }" />
	</c:redirect>
</body>
</html>