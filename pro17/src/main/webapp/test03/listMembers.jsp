<%@ page language="java" contentType="text/html; charset=UTF-8"
	import=" java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"
	isELIgnored="false"    
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	System.out.println("");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창dd</title>
<style type="text/css">
	.cls1 {
		font-size: 40px;
		text-align: center;
	}
</style>
</head>
<body>
<h1 class="cls1">회원정보dd</h1>
<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="5%"><b>이름</b></td>
			<td width="5%"><b>이메일</b></td>
			<td width="5%"><b>주소</b></td>
			<td width="5%"><b>수정</b></td>
			<td width="5%"><b>삭제 ${membersList[0].id }</b></td>
		</tr>
	<c:choose>
		<c:when test='${msg == "addMember" }'>
			<script>
				window.onload = function () {
					alert("회원을 등록했습니다.");
				}
			</script>
		</c:when>
				<c:when test='${msg == "modified" }'>
			<script>
				window.onload = function () {
					alert("회원정보를 수정했습니다.");
				}
			</script>
		</c:when>
				<c:when test='${msg == "deleted" }'>
			<script>
				window.onload = function () {
					alert("회원정보를 삭제했습니다.");
				}
			</script>
		</c:when>
	</c:choose>
	<c:choose>
   <c:when test="${membersList == null}">
            <tr align="center">
               <td colspan=7>
                  <b>등록된 회원이 없습니다.</b>
               </td>
            </tr>
         </c:when>
         <c:when test="${membersList != null}">
            <c:forEach var = "mem" items = "${membersList}" >
               <tr align=center>
                  <td>${mem.id}</td>
                  <td>${mem.pwd}</td>
                  <td>${mem.name}</td>
                  <td>${mem.email}</td>
                  <td>${mem.joinDate}</td>
                  <td><a href="${contextPath }/member/modMemberForm.do?id=${mem.id }">수정</a></td>
                  <td><a href="${contextPath }/member/delMember.do?id=${mem.id }">삭제</a></td>
               </tr>
            </c:forEach>
         </c:when>

	</c:choose>
</table>
<a href="${contextPath }/member/memberForm.do" align="center">
	<p class="cls2"> 회원 가입하기 </p>
</a>
</body>
</html>