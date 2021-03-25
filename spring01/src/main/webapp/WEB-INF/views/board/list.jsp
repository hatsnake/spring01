<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 리스트</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="container">
	<h2 class="mt-sm-5">게시판 리스트</h2>
	<button class="btn btn-primary float-right mb-sm-2 move" data="write">글작성</button>
	
	<table class="table text-center">
		<thead class="table-dark">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td style="cursor:pointer;">하하</td>
				<td>hatsnake</td>
				<td>19-01-15</td>
				<td>0</td>
			</tr>
		</tbody>
	</table>
	
	<ul class="pagination" style="margin-left:42%;">
		<li class="page-item">
			<a class="page-link" href="#">1</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">2</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">3</a>
		</li>				
	</ul>
</div>
</body>
</html>