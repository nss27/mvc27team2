<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
		body{
			background: linear-gradient(to right,rgba(255,0,0,0.5), rgba(209,178,255,1));
		}
		.page-header{
			text-align: center;
		}
	</style>
</head>
<body>
	<div class="page-header">
		<h1>
			index
			<small>
				메인
			</small>
		</h1>
	</div>
	<!-- 나성수 -->
	<div class="row">
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/addStudentController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>student추가</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getStudentListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>student리스트</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>studentAddr리스트</label>
		</div>
	</div>
	<!-- 배건혜 -->
	<div class="row">
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/addEmployeeController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>employee추가</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getEmployeeListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>employee리스트</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getEmplyeeAddrListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>employeeAddr리스트</label>
		</div>
	</div>
	<!-- 나윤주 -->
	<div class="row">
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/addTeacherController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>teacher추가</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getTeacherListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>teacher리스트</label>
		</div>
		<div class="col-xs-6 col-md-4">
			<a href="${pageContext.request.contextPath}/getTeacherAddrListController.team2" class="thumbnail">
				<img src="${pageContext.request.contextPath}/image/sample2.svg" alt="...">
			</a>
			<label>teacherAddr리스트</label>
		</div>
	</div>
</body>
</html>