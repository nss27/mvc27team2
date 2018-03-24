<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/team2_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$('div.invalid-feedback').hide();
			$("input.studentId").blur(function(){
				if($(this).val().length < 5){
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
			$("input.studentPw").blur(function(){
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
			$("input.studentPwCheck").blur(function(){
				if($(this).val() === $("input.studentPw").val()){
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
				if($("input.studentId").val() == "" || $("input.studentId").val().length < 5){
					alert("아이디를 다시입력하세요");
					$("input.studentId").focus();
				}else if($("input.studentPw").val() == "" || $("input.studentPw").val().length < 10){
					alert("비밀번호를 다시입력하세요");
					$("input.studentPw").focus();
				}else if($("input.studentPwCheck").val() == "" || $("input.studentPwCheck").val() != $("input.studentPw").val()){
					alert("비밀번호가 일치하는지 확인하세요");
					$("input.studentPwCheck").focus();
				}else{
					$("form").submit();
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
		</div>
	</nav>
	
	<div class="title">
		<img alt="addStudent" src="${pageContext.request.contextPath}/image/addStudent.png">
	</div>
	
	<div id="form">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form method="post" action="${pageContext.request.contextPath}/addStudentController.team2">
			<div class="studentId form-group">
				<label for="studentId" class="control-label">student_id</label>
				<input type="text" id="studentId" name="studentId" class="studentId form-control form-control-sm" placeholder="아이디를 입력하세요">
				<div class="invalid-feedback">아이디는 5글자 이상입니다</div>
			</div>
			<div class="studentPw form-group">
				<label for="studentPw" class="control-label">student_pw</label>
				<input type="password" id="studentPw" name="studentPw" class="studentPw form-control form-control-sm" placeholder="비밀번호를 입력하세요">
				<div class="invalid-feedback">비밀번호는 10글자 이상입니다</div>
			</div>
			<div class="studentPwCheck form-group">
				<label for="studentPwCheck" class="control-label">student_pw 확인</label>
				<input type="password" id="studentPwCheck" name="studentPwCheck" class="studentPwCheck form-control form-control-sm"  placeholder="입력한 비밀번호를 확인해주세요">
				<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
			</div>	
			<button type="button" id="add" class="btn btn-outline-primary btn-lg btn-block">student추가</button>	
		</form>
	</div>
</body>
</html>
