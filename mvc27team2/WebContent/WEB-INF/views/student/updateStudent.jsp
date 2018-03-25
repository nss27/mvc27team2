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
	<script type="text/javascript">
		$(document).ready(function(){
			$('div.invalid-feedback').hide();
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
			$("button#change").click(function(){
				if($("input.studentPw").val() == "" || $("input.studentPw").val().length < 10){
					alert("비밀번호를 다시입력하세요");
					$("input.studentPw").focus();
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
		<img alt="addStudent" src="${pageContext.request.contextPath}/image/addStudent.png">
	</div>
	
	<div id="form">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/getStudentListController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form action="${pageContext.request.contextPath}/updateStudentController.team2" method="post">
			<fieldset>
				<input type="hidden" name="studentNo" value="${student.studentNo}">
				<div class="form-group row">
					<label for="studentId" class="col-sm-2 col-form-label">student_id</label>
					<div class="col-sm-10">
						<input type="text" readonly="readonly" class="form-control-plaintext" id="studentId" value="${student.studentId}">
					</div>
				</div>
				<div class="studentPw form-group">
					<label for="studentPw" class="control-label">student_pw</label>
					<input type="password" id="studentPw" name="studentPw" class="studentPw form-control form-control-sm" value="${student.studentPw}">
					<div class="invalid-feedback">비밀번호는 10글자 이상입니다</div>
				</div>	
				<button type="button" id="change" class="btn btn-outline-primary btn-lg btn-block">student수정</button>
			</fieldset>
		</form>
	</div>
</body>
</html>