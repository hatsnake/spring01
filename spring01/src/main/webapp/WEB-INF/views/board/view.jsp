<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 보기</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="container">
	<h2 class="mt-sm-5">게시글 보기</h2>
	<button class="btn btn-primary mb-2 list" style="margin-left:39%;">목록</button>
	<button class="btn btn-primary mb-2 ml-1 writereply">답글</button>
	<input type="hidden" id="no" value="">
	<input type="hidden" id="gNo" value="">
	<input type="hidden" id="step" value="">
	<input type="hidden" id="indent" value="">
	<input type="text" class="form-control w-50 mb-sm-1" readonly="readonly" value="">
	<input type="text" class="form-control w-50 mb-sm-1" readonly="readonly" value="">
	<textarea rows="10" class="form-control w-50 mb-sm-1" readonly="readonly"></textarea>
	
	<div class="row mt-3 ml-5">
		<form class="form-inline" name="commentForm">
			<input type="hidden" name="bNo" value="">
			<input type="text" class="w-25 comments_writer" name="id" placeholder="작성자">
			<input type="text" class="w-50 comments_content" name="content" placeholder="내용">
			<button type="button" class="ml-4 btn btn-danger writecomments">작성</button>
		</form>
	</div>
	
	<div class="comments_list">
		<div class="row mt-1">
			<div class="col-2">hatsnake</div>
			<div class="col-3">하하</div>
			<div class="col-3">2019-01-15</div>
		</div>
	</div>
</div>
</body>
</html>