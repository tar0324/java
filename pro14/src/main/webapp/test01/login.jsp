<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 상대경로 설정하기 -->
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<title>로그인창</title>
</head>
<body>
	<form action="result.jsp">
		아이디: <input type="text" size="20" name="id" /> <br>
		비밀번호: <input type="password" size="20" name="pwd" /> <br>
		<input type="submit" value="로그인" /> <input type="reset" value="다시 입력" />
	</form>
	<br><br>
	<%-- <a href="<%=request.getContextPath() %>/test01/memberForm.jsp">회원가입하기</a> --%>
	<a href="${contextPath}/test01/memberForm.jsp">회원가입하기</a>
</body>
</html>