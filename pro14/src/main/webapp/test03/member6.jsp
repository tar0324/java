<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List dataList = new ArrayList();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!!");
%>
<c:set var="list" value="<%=dataList %>" />    <!-- 표현언어에서 사용할 수 있도록 c:set 태그를 이용해 변수에 dataList 할당  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문 실습</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${i} &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count}<br>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i } = ${5 * i} <br>
	</c:forEach>
	<br>
	<c:forEach var="data" items="${list }">
		${data } <br>
	</c:forEach>
	<br>
	
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
	<c:forTokens items="${fruits }" var="token" delims=",">
		${token } <br>
	</c:forTokens>
	
</body>
</html>