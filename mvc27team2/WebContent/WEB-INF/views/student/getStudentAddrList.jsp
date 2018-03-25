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
			if(${pageMaker.totalCurrentPage} == $('a#'+${pageMaker.totalCurrentPage}).text()){
				$('a#'+${pageMaker.totalCurrentPage}).parent().addClass('active');
			}
			$('input#allAddrNo').click(function(){				
				var allCheck = $('input#allAddrNo').is(':checked');
				if(allCheck == true){
					$('input:checkbox').prop('checked',true);
				}else{
					$('input:checkbox').prop('checked',false);
				}
			});
			$('button#delete').click(function(){
				if($('input:checkbox').is(':checked')){
					$('form').submit();
				}else{
					alert('선택한 항목이 없습니다');
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
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/indexController.team2?#student">student</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/indexController.team2?#employee">employee</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/indexController.team2?#teacher">teacher</a>
				</li>
			</ul>
			<%@ include file="/WEB-INF/views/student/searchStudentAddrList.jsp" %><br>
		</div>
	</nav>
	
	<div class="title">
		<img alt="addStudent" src="${pageContext.request.contextPath}/image/addStudent.png">
	</div>
	
	<div id="list" class="center-block">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form action="${pageContext.request.contextPath}/deleteStudentAddrController.team2" method="post">
			<table class="table table-hover table-light">
				<thead>
					<tr>
						<th scope="col">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="allAddrNo">
								<label class="custom-control-label" for="allAddrNo">studentAddrNo</label>
							</div>
						</th>
						<th scope="col">
							studentNo
						</th>
						<th scope="col">
							studentId
						</th>
						<th scope="col">
							address
						</th>
						<th scope="col">
							수정
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="studentAddr" items="${list}">
						<tr>
							<th scope="row">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" id="${studentAddr.studentAddrNo}" name="studentAddrNo" value="${studentAddr.studentAddrNo}">
									<label class="custom-control-label" for="${studentAddr.studentAddrNo}">${studentAddr.studentAddrNo}</label>
								</div>
							</th>
							<td>
								${studentAddr.studentNo}
							</td>
							<td>
								${studentAddr.studentId}
							</td>
							<td>
								${studentAddr.address}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/updateStudentAddrController.team2?studentAddrNo=${studentAddr.studentAddrNo}">수정하기</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="paging" class="center-block">
				<ul class="pagination pagination-sm">
					<c:if test="${pageMaker.totalCurrentPage > 1}">
						<li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/getStudentAddrListController.team2">&laquo;</a>
					    </li>
						<li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${pageMaker.totalCurrentPage - 1}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">이전</a>
					    </li>
					</c:if>
					<c:forEach var="pageNumber" items="${pageNumber}">
						<li id="pageNumber" class="page-item">
					      <a class="page-link" id="${pageNumber}" href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${pageNumber}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">${pageNumber}</a>
					    </li>
					</c:forEach>
					<c:if test="${pageMaker.totalCurrentPage < pageMaker.totalPage}">
						<li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${pageMaker.totalCurrentPage + 1}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">다음</a>
					    </li>
						<li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${pageMaker.totalPage}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">&raquo;</a>
					    </li>
					</c:if>
				</ul>
			</div>
			<br>
			<button id="delete" type="button" class="btn btn-outline-primary btn-lg btn-block">삭제하기</button>
		</form>
	</div>
</body>
</html>