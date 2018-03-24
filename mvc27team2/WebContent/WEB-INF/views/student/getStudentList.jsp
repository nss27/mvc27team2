<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/team2_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('a.delete').click(function(){
				var count = $(this).parents('tr').find('span').text();
				if(count != 0){
					alert('등록된 주소 '+count+'개를 모두 지우시면 삭제가능합니다');
					$(this).attr('href','#');
				}
			});
		});
	</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/indexController.team2">TEAM2</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="#">
						Home<span class="sr-only">(current)</span>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Features</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Pricing</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">About</a>
				</li>
			</ul>
			<form class="nav-link form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	
	<div class="title">
		<img alt="addStudent" src="${pageContext.request.contextPath}/image/addStudent.png">
	</div>
	
	<div id="list" class="center-block">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>
						studentNo
					</th>
					<th>
						studentId
					</th>
					<th>
						studentPw
					</th>
					<th>
						주소 <span class="badge badge-primary badge-pill">${sumCount}</span>
					</th>
					<th>
						수정
					</th>
					<th>
						삭제
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${list}">
					<tr>
						<td>
							${student.studentNo}
						</td>
						<td>
							${student.studentId}
						</td>
						<td>
							*****
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/addStudentAddrController.team2?studentNo=${student.studentNo}">주소추가 <span class="badge badge-primary badge-pill">${student.studentAddrCount}</span></a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/updateStudentController.team2?studentNo=${student.studentNo}">수정하기</a>
						</td>
						<td>
							<a class="delete" href="${pageContext.request.contextPath}/deleteStudentController.team2?studentNo=${student.studentNo}" >삭제하기</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="page" class="center-block">
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/getStudentListController.team2">처음으로</a>
				<a href="${pageContext.request.contextPath}/getStudentListController.team2?currentPage=${currentPage - 1}">이전</a>
			</c:if>
			<c:forEach var="pageNumber" items="${pageNumber}">
				<a href="${pageContext.request.contextPath}/getStudentListController.team2?currentPage=${pageNumber}">${pageNumber}</a>
			</c:forEach>
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/getStudentListController.team2?currentPage=${currentPage + 1}">다음</a>
				<a href="${pageContext.request.contextPath}/getStudentListController.team2?currentPage=${lastPage}">마지막으로</a>
			</c:if>
		</div>
	</div>
</body>
</html>