<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec01.ex01.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m" property="id" />
<jsp:setProperty name="m" property="pwd" />
<jsp:setProperty name="m" property="name" />
<jsp:setProperty name="m" property="email" />

<%
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List membersList = memberDAO.listMembers();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center">
	<tr>
		<td width="200">
			<p align="right">아이디
		</td>
		<td width="400">
			<input type="text" name="id">
		</td>
	</tr>
	<tr>
		<td width="200">
			<p align="right">비밀번호
		</td>
		<td width="400">
			<input type="password" name="pwd">
		</td>
	</tr>
	<tr>
		<td width="200">
			<p align="right">이름
		</td>
		<td width="400">
			<input type="text" name="name">
		</td>
	</tr>
	<tr>
		<td width="200">
			<p align="right">이메일
		</td>
		<td width="400">
			<input type="text" name="email">
		</td>
	</tr>
		<tr>
		<td width="200">
			<p align="right">&nbsp;</p>
		</td>
		<td width="400">
			<input type="submit" value="가입하기">
			<input type="reset" value="다시입력">
		</td>
	</tr>
</table>
</body>
</html>