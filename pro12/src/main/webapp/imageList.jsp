<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

li {
	list-style:none;

}
</style>
</head>

<body>
	<ul class="lst_type">
		<li>
			<span style='margin-left:20%'>이미지</span>
			<span style='margin-left:20%'>이미지 이름</span>
			<span style='margin-left:20%'>선택하기</span>
		</li>
		<%
		for(int i=0; i<10; i++){
		%>
		<li>
			<a href='#' style='margin-left:20%' >
				<img alt="이미지" src="image/dog.jpg" width='90' height='90'>
			</a>
			<a href='#' style='margin-left:20%'><strong>이미지 이름: 댕댕이 <%=i %></strong></a>
			<a href='#' style='margin-left:20%'> <input name='chk<%=i %>' type='checkbox' /> </a>
		</li>
		<hr>
		<%
		}
		%>
	</ul>
</body>
</html>