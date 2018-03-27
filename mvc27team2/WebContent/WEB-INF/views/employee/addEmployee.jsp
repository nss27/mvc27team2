<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addEmployee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/team2_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$('div.invalid-feedback').hide();
			$("input.employeeId").blur(function(){
				if($(this).val().length<5){
					$(this).parent().removeClass("has-success");
					$(this).parent().addClass("has-error");
					$(this).removeClass("is-valid");	
					$(this).addClass("is-valid");
					$(this).parent().find('div').show();
				}else{
					$(this).parent().removeClass("has-danger");
					$(this).parent().addClass("has-success");
					$(this).removeClass("is-invalid");
					$(this).addClass("is-valid");
					$(this).parent().find('div').hide();
				}
			});
		$("input.employeePw").blur(function(){
			if($(this).val().length < 10){
				$(this).parent().removeClass("has-success");
				$(this).parent().addClass("has-danger");
				$(this).removeClass("is-valid");
				$(this).addClass("is-invalid");
				$(this).parent().find('div').show();
			}else{
				$(this).parent().removeClass("has-danger");
				$(this).parent().addClass("has-success");
				$(this).removeClass("is-invalid");
				$(this).addClass("is-valid");
				$(this).parent().find('div').hide();				
			}
		});
		$("input.employeePwCheck").blur(function(){
			if($(this).val() === $("input.employeePw").val()){
				$(this).parent().removeClass("has-danger");
				$(this).parent().addClass("has-success");
				$(this).removeClass("is-invalid");
				$(this).addClass("is-valid");
				$(this).parent().find('div').hide();
			}else{
				$(this).parent().removeClass("has-success");
				$(this).parent().addClass("has-danger");
				$(this).removeClass("is-valid");
				$(this).addClass("is-invalid");
				$(this).parent().find('div').show();
			}
		});
		$("button#add").click(function(){
			if($("input.employeeId").val()=="" || $("input.employeeId").val().length<5){
				alert("아이디를 입력하세요");
				$("input.employeeId").focus();
			}else if ($("input.employeePw").val()=="" || $("input.employeePw").val().length<10){
				alert("비밀번호를 입력하세요");
				$("input.employeePw").focus();
			}else if($("input.employeePwCheck").val()=="" || $("input.employeePwCheck").val() != $("input.employeePw").val() ){
				alert("비밀번호가 일치하는지 확인하세요")
				$("input.employeePwCheck").focus();
			}else {
				$("form").submit();
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
		</div>
	</nav>
	<div class="title">
		<img alt="addEmployee" src="${pageContext.request.contextPath}/image/addEmployee.png">
	</div>
	<div id="form">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form method = "post" action="${pageContext.request.contextPath}/addEmployeeController.team2">
			 <fieldset>
				 <div class="employeeId form-group">
					<label for="employeeId" class="control-label">employee_id</label>
						<input type="text" id="employeeId" name="employeeId" class="employeeId form-control form-control-sm" placeholder="아이디를 입력하세요">
						<div class="invalid-feedback">아이디는 5글자 이상입니다</p></div>
				</div>
				<div class="employeePw form-group">
					<label for="employeePw" class="control-label">employee_pw</label>
						<input type="password" id="employeePw" name="employeePw" class="employeePw form-control form-control-sm" placeholder="비밀번호를 입력하세요">
						<div class="invalid-feedback">비밀번호는 10글자 이상입니다</div>
				</div>
				<div class="employeePwCheck form-group">
					<label for="employeePwCheck" class="control-label">employee_pw 확인</label>
						<input type="password" id="employeePwCheck" name="employeePwCheck" class="employeePwCheck form-control form-control-sm" placeholder="입력한 비밀번호를  확인해주세요">
						<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
				</div>
		      	<button type="button" id="add" class="btn btn-outline-primary btn-lg btn-block">employee추가</button>
	      	</fieldset>
		</form>
	</div>
</body>
</html>
