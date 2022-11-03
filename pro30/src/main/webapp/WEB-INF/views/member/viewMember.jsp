<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <h1 align="center">회원 상세 정보</h1>
   <form method="post" action="${contextPath}/member/modMember.do">
   <table align="center">
      <tr>
      <td width="200"><p align="right">사용자 아이디</td>
      <td width="400"><input type="text" name="id" value=${member.id } readonly></td>
      </tr>
      <tr>
      <td width="200"><p align="right">사용자 비밀번호</td>
      <td width="400"><input type="text" name="pwd" value=${member.pwd }></td>
      </tr>
      <tr>
      <td width="200"><p align="right">사용자 이름</td>
      <td width="400"><input type="text" name="name" value=${member.name }></td>
      </tr>
      <tr>
      <td width="200"><p align="right">사용자 이메일</td>
      <td width="400"><input type="text" name="email" value=${member.email }></td>
      </tr>      
      <tr>
      <td width="200"><p>&nbsp;</p></td>
      <td width="400">
      <input type="submit" value="수정하기">
      <input type="reset" value="다시입력">
      </tr>
   </table>
   </form>
</body>
</html>