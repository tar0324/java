<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>

</head>
<body>
	<table border="1" width="80%" align="center">
		<tr align="center" bgcolor="pink">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입일</b></td>
			<td><b>    </b></td>
		</tr>
		<c:forEach var="member" items="${membersList }">
		<tr align="center">
			<td><a href="${contextPath}/member/viewMember.do?id=${member.id }">${member.id }</a></td>
			<td>${member.pwd}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
			<td>${member.joinDate}</td>
			<td><a href="${contextPath}/member/removeMember.do?id=${member.id }">삭제</a></td>
		</tr>
		</c:forEach>
	</table> <br>
	<form action="${contextPath }/member/searchMember.do" align="center">
		<input type="text" name="value" />
		<select name="action">
			<option value="selectlistMembers"> 전체 </option>
			<option value="selectMemberById"> 아이디 </option>
			<option value="selectMemberByPwd"> 비밀번호 </option>
		</select> &nbsp;
		<input type="submit" value="검색" />
</form>
	<%-- <a href="${contextPath }/member/search.jsp"><h6 style="text-align:center">검색</h6></a> --%>
	<a href="${contextPath }/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>