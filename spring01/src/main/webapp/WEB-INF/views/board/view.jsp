<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 보기</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function() {
	
	/* 목록버튼 클릭시 글 리스트 페이지 이동 */
	$('.list').on('click', function() {
		location.href='/board/list';
	});

	/* 게시글의 답글 작성 페이지 이동 */
	$('.writereply').on('click', function() {
		var no = $('#no').val();
		var gNo = $('#gNo').val();
		var step = $('#step').val();
		var indent = $('#indent').val();
		location.href='/board/write?no='+no+"&gNo="+gNo+"&step="+step+"&indent="+indent;
	});

	/* 댓글 작성 */
	$(".writeComments").on('click', function() {
		//폼의 객체들을 한번에 받을 수 있음
		var insertData = $('[name=commentForm]').serialize();
		$.ajax({
			url : '/board/writeComments',
			type : 'POST',
			data : insertData,
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('error');
			},
			complete : function() {
				console.log('complete');
				$('.comments_writer').val('');
				$('.comments_content').val('');
				commentsList();
			}
		});
	});

	/* 댓글 리스트 출력 */
	function commentsList() {
		$.ajax({
			url : '/board/listComments',
			type : 'POST',
			data : {
				bNo : $('input[name=bNo]').val()
			},
			dataType : 'JSON',
			success : function(response) {
				console.log(response);
				$('.comments_list').html('');
				$.each(response.result, function(index, item) {
					var comments = {
						id : item.id,
						content : item.content,
						cDate : item.cDate
					};
					addComments(comments);
				});
			},
			error : function() {
				console.log('error');
			},
			complete : function() {
				console.log('complete');
			}
		});
	}

	/* 하나의 댓글 HTML */
	function addComments(comments) {
		$('.comments_list').append(
			'<div class="row mt-1">'
			+ '<div class="col-2">'+comments.id+'</div>'
			+ '<div class="col-3">'+comments.content+'</div>'
			+ '<div class="col-3">'+comments.cDate+'</div>'
			+ '</div>'
		);
	}});
</script>

</head>
<body>
<div class="container">
	<h2 class="mt-sm-5">게시글 보기</h2>
	<button class="btn btn-primary mb-2 list" style="margin-left:39%;">목록</button>
	<button class="btn btn-primary mb-2 ml-1 writereply">답글</button>
	<input type="hidden" id="no" value="${board.no}">
	<input type="hidden" id="gNo" value="${board.gNo}">
	<input type="hidden" id="step" value="${board.step}">
	<input type="hidden" id="indent" value="${board.indent}">
	<input type="text" class="form-control w-50 mb-sm-1" readonly="readonly" value="${board.title}">
	<input type="text" class="form-control w-50 mb-sm-1" readonly="readonly" value="${board.id}">
	<textarea rows="10" class="form-control w-50 mb-sm-1" readonly="readonly">${board.content}</textarea>
	
	<div class="row mt-3 ml-5">
		<form class="form-inline" name="commentForm">
			<input type="hidden" name="bNo" value="${board.no}">
			<input type="text" class="w-25 comments_writer" name="id" placeholder="작성자">
			<input type="text" class="w-50 comments_content" name="content" placeholder="내용">
			<button type="button" class="ml-4 btn btn-danger writeComments">작성</button>
		</form>
	</div>
	
	<div class="comments_list">
		<c:forEach items="${comments}" var="comments">
			<div class="row mt-1">
				<div class="col-2">${comments.id}</div>
				<div class="col-3">${comments.content}</div>
				<div class="col-3">${comments.cDate}</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>