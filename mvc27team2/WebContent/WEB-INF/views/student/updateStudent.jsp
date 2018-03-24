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
			$("p.studentPw").hide();
			$("input.studentPw").blur(function(){
				if($("input.studentPw").val().length < 10){
					$("div.studentPw").removeClass("has-success");
					$("div.studentPw").addClass("has-error");
					$("span.studentPw").removeClass("glyphicon glyphicon-ok");
					$("span.studentPw").addClass("glyphicon glyphicon-alert");
					$("p.studentPw").show();
				}else{
					$("div.studentPw").removeClass("has-error");
					$("div.studentPw").addClass("has-success");
					$("span.studentPw").removeClass("glyphicon glyphicon-alert");
					$("span.studentPw").addClass("glyphicon glyphicon-ok");
					$("p.studentPw").hide();
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
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/getStudentListController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form action="${pageContext.request.contextPath}/updateStudentController.team2" class="form-horizontal" method="post">
			<input type="hidden" name="studentNo" value="${student.studentNo}">
			<div class="form-group">
				<label class="col-sm-2 control-label">student_id</label>
				<div class="col-sm-10">
					<p class="form-control-static">${student.studentId}</p>
				</div>
			</div>
			<div class="studentPw form-group has-feedback">
				<label for="studentPw" class="col-sm-2 control-label">student_pw</label>
				<div class="col-sm-10">
					<input type="text" class="studentPw form-control" id="studentPw" name="studentPw" value="${student.studentPw}">
					<span class="studentPw form-control-feedback"></span>
					<p class="studentPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
			<button type="button" id="change" class="btn btn-outline-primary btn-lg btn-block">student수정</button>
		</form>
	</div>
</body>
</html>