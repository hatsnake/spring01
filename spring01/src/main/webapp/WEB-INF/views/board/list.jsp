<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 리스트</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
$(document).ready(function() {
	$('.move').on('click', function() {
		var data = $(this).attr('data');
		console.log(data);

		if(data == 'write') {
			location.href='/board/write';
		} else if(data == "view") {
			var no = $(this).parent('tr').children('td:nth-of-type(1)').html();
			location.href='/board/view?no='+no;
			console.log(no);
		}
	});
});
</script>

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
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.no}</td>
					<td class="move text-left" style="cursor:pointer;" data="view">
						<c:if test="${list.indent > 0}">
							<c:set value="${list.indent * 10}" var="width"/>
							<img src="/resources/image/blank.png" width="${width}">
							<span>→</span>
						</c:if>
						${list.title}
					</td>
					<td>${list.id}</td>
					<td>${list.bDate}</td>
					<td>${list.count}</td>
				</tr>	
			</c:forEach>
			
		</tbody>
	</table>
	
	<div class="text-center">
		<ul class="pagination" style="margin-left:42%;">
			<c:choose>
				<c:when test="${page.startPage > page.pageBlock}">
					<li class="page-item">
						<a class="page-link" href="/board/list?pageNum=${page.startPage-1}">&lt;&lt;</a>
					</li>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
	
			<c:choose>
				<c:when test="${page.pageNum > 1}">
					<li class="page-item">
						<a class="page-link" href="/board/list?pageNum=${page.pageNum-1}">&lt;</a>
					</li>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		
			<c:forEach begin="${page.startPage}" end="${page.endPage}" step="1" var="i">
				<li class="page-item <c:if test="${i eq page.pageNum}">active</c:if>">
					<a class="page-link" href="/board/list?pageNum=${i}">${i}</a>
				</li>		
			</c:forEach>
			
			<c:choose>
				<c:when test="${page.pageNum < page.pageCount}">
					<li class="page-item">
						<a class="page-link" href="/board/list?pageNum=${page.pageNum+1}">&gt;</a>
					</li>
				</c:when>
				<c:otherwise></c:otherwise>		
			</c:choose>
			
			<c:choose>
				<c:when test="${page.endPage < page.pageCount}">
					<li class="page-item">
						<a class="page-link" href="/board/list?pageNum=${page.endPage+1}">&gt;&gt;</a>
					</li>
				</c:when>
				<c:otherwise></c:otherwise>		
			</c:choose>	
		</ul>
	</div>
</div>
</body>
</html>