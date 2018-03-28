<!-- 나윤주 -->
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
			$("input.teacherId").blur(function(){
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
			$("input.teacherPw").blur(function(){
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
			$("input.teacherPwCheck").blur(function(){
				if($(this).val() === $("input.teacherPw").val()){
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
				if($("input.teacherId").val() == "" || $("input.teacherId").val().length < 5){
					alert("아이디를 다시입력하세요");
					$("input.teacherId").focus();
				}else if($("input.teacherPw").val() == "" || $("input.teacherPw").val().length < 10){
					alert("비밀번호를 다시입력하세요");
					$("input.teacherPw").focus();
				}else if($("input.teacherPwCheck").val() == "" || $("input.teacherPwCheck").val() != $("input.teacherPw").val()){
					alert("비밀번호가 일치하는지 확인하세요");
					$("input.teacherPwCheck").focus();
				}else{
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
		<img alt="addTeacher" src="${pageContext.request.contextPath}/image/addTeacher.png">
	</div>
	
	<div id="form">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form method="post" action="${pageContext.request.contextPath}/addTeacherController.team2">
			<fieldset>
				<div class="teacherId form-group">
					<label for="teacherId" class="control-label">teacher_id</label>
					<input type="text" id="teacherId" name="teacherId" class="teacherId form-control form-control-sm" placeholder="아이디를 입력하세요">
					<div class="invalid-feedback">아이디는 5글자 이상입니다</div>
				</div>
				<div class="teacherPw form-group">
					<label for="teacherPw" class="control-label">teacher_pw</label>
					<input type="password" id="teacherPw" name="teacherPw" class="teacherPw form-control form-control-sm" placeholder="비밀번호를 입력하세요">
					<div class="invalid-feedback">비밀번호는 10글자 이상입니다</div>
				</div>
				<div class="teacherPwCheck form-group">
					<label for="teacherPwCheck" class="control-label">teacher_pw 확인</label>
					<input type="password" id="teacherPwCheck" name="teacherPwCheck" class="teacherPwCheck form-control form-control-sm"  placeholder="입력한 비밀번호를 확인해주세요">
					<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
				</div>	
				<button type="button" id="add" class="btn btn-outline-primary btn-lg btn-block">teacher추가</button>
			</fieldset>
		</form>
	</div>
</body>
</html>
