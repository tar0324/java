<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	html, body {
		width:900px;
		height:70%;
		margin: 0 auto;
	}
	
	.bg {
		background-color: skyblue;
		border : 1px solid black;
		padding: 10px;
		margin: 10px;
	}
	
	#header {
		background-color: blue;
		color : white;
		border:1px solid black;
		padding-left: 30px;
	}

	
	li {
		list-style : none;
		display: inline-block;
		margin-left:15px;
	}
	aside {
		float: right;
		width : 190px;
		height: 280px;
		
	}
	section {
		float: left;
		width : 630px;
	}
	footer {
		clear: both;
		text-align : center;
		
	}
	#div1 {
		background-color: gray;
		height: 150px;
	}
	#div2 {
		position:relative;
		top:50px;
	}
	

</style>
</head>
<body>
	<header id="header">
		<h1>책읽는 사람이 세상을 바꾼다!!</h1>
		<span  style="position: relative; left:750px; bottom:60px;">by 홍길동</span>
	</header>
	<nav>
		<ul>
			<li>국내도서</li>
			<li>서양도서</li>
			<li>베스트셀러</li>
			<li>e-book</li>
			<li>아동전집</li>
			<li>이벤트</li>
			<li>문화행사</li>
		</ul>
	</nav>
	<aside class="bg" style="margin-left: 0;">
		<div id="div1">
			문화 강좌 광고
		</div>
		<div id="div2">
			<b >html5강좌</b> <br>
			<b >컴퓨터강좌</b> <br>
			<b >독서강좌</b> <br>
		</div>

	</aside>
	<section class="bg">
		<article>
			<h1>첫 번째 도서 제목</h1>
			<p> 첫 번째 도서 내용</p>
		</article>
		<article>
			<h1>두 번째 도서 제목</h1>
			<p> 두 번째 도서 내용 </p>
			
		</article>
		<article>
			<h1>세번째 도서 제목</h1>
			<p> 세번째 도서 내용 </p>
		</article>
	</section>

	<footer class="bg" style="padding: 20px;">
		이메일: admin@test.com <br>
		회사주소 : 서울시 강동구 <br>
		찾아오시는 길 : <a href="#"> 약도</a>
	</footer>
</body>
</html>