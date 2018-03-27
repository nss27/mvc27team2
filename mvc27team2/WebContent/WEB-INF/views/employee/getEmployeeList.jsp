<!-- 배건혜 -->
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
			if(${pageMaker.totalCurrentPage} == $(('a#'+${pageMaker.totalCurrentPage}).text()){
				$('a#'+${pageMaker.totalCurrentPage}).parent().addClass('active');
			}
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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
			<form class="nav-link form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<div class="title">
		<img alt="addEmployee" src="${pageContext.request.contextPath}/image/getEmployeeList.png">	
	</div>
	<div id="list" class="center-block">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<table class="table table-hover table-light" >
			<thead>
				<tr>
					<th scope="col">
						employeeNo
					</th>
					<th scope="col">
						employeeId
					</th>
					<th scope="col">
						employeePw
					</th>
					<th scope="col">
						주소<span class="badge badge-primary badge-pill">${sumCount}</span>
					</th>
					<th scope="col">
						수정
					</th>
					<th scope="col">
						삭제
					</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${list}">
					<tr>
						<td scope="col">
							${employee.employeeNo}
						</td>
						<td>
							${employee.employeeId}
						</td>
						<td>
							*************
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/addEmployeeAddrController.team2?employeeNo=${employee.employeeNo}">주소추가 <span class="badge badge-primary badge-pill">${employee.employeeAddrCount}</span></a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/updateEmployeeController.team2?employeeNo=${employee.employeeNo}">수정하기</a>
						</td>
						<td>
							<a class="delete" href="${pageContext.request.contextPath}/deleteEmployeeController.team2?employeeNo=${employee.employeeNo}">삭제하기</a>
						</td>
					</tr>					
				</c:forEach>
			</tbody>
		</table>
		<div id="paging">
			<ul class="pagination pagination-sm">
				<c:if test="${pageMaker.totalCurrentPage > 1}">
					<li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/getEmployeeListController.team2">&laquo;</a>
				    </li>
					<li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/getEmployeeListController.team2?currentPage=${pageMaker.totalCurrentPage - 1}">이전</a>
				    </li>
				</c:if>
				<c:forEach var="pageNumber" items="${pageNumber}">
					<li id="pageNumber" class="page-item">
				      <a class="page-link" id="${pageNumber}" href="${pageContext.request.contextPath}/getEmployeeListController.team2?currentPage=${pageNumber}">${pageNumber}</a>
				    </li>
				</c:forEach>
				<c:if test="${pageMaker.totalCurrentPage < pageMaker.totalPage}">
					<li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/getEmployeeListController.team2?currentPage=${pageMaker.totalCurrentPage + 1}">다음</a>
				    </li>
					<li class="page-item">
				      <a class="page-link" href="${pageContext.request.contextPath}/getEmployeeListController.team2?currentPage=${pageMaker.totalPage}">&raquo;</a>
				    </li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>