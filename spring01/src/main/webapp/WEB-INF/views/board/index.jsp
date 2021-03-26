<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인화면</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function() {
	$('.board').on('click', function() {
		location.href='/board/list';
	});
});
</script>
</head>
<body>
	<h2>메인화면</h2>
	<button class="btn btn-primary mb-2 ml-1 board">게시판 이동</button>
</body>
</html>