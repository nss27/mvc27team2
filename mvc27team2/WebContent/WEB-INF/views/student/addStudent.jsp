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
		h2{
			text-align: center;
			padding-bottom: 20px;
		}
		div#form{
			margin: 0 auto;
			padding: 10px 10px 10px 10px;
			width: 60%;
			background-color: rgba(255,255,255,.5);
			border-radius: 7px;
			box-shadow: 5px 5px 5px rgba(58,58,58,.5);
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("p").hide();
			$("input.studentId").blur(function(){
				if($("input.studentId").val().length < 5){
					$("div.studentId").addClass("has-error");
					$("span.studentId").addClass("glyphicon glyphicon-alert");
					$("p.studentId").show();
				}else{
					$("div.studentId").removeClass("has-error");
					$("div.studentId").addClass("has-success");
					$("span.studentId").removeClass("glyphicon glyphicon-alert");
					$("span.studentId").addClass("glyphicon glyphicon-ok");
					$("p.studentId").hide();
				}
			});
			$("input.studentPw").blur(function(){
				if($("input.studentPw").val().length < 10){
					$("div.studentPw").addClass("has-error");
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
			$("input.studentPwCheck").blur(function(){
				if($("input.studentPwCheck").val() === $("input.studentPw").val()){
					$("div.studentPwCheck").removeClass("has-error");
					$("div.studentPwCheck").addClass("has-success");
					$("span.studentPwCheck").removeClass("glyphicon glyphicon-alert");
					$("span.studentPwCheck").addClass("glyphicon glyphicon-ok");
					$("p.studentPwCheck").hide();
				}else{
					$("div.studentPwCheck").addClass("has-error");
					$("span.studentPwCheck").addClass("glyphicon glyphicon-alert");
					$("p.studentPwCheck").show();
				}
			});
			$("button").click(function(){
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
	<h2>addStudent</h2>
	<div id="form">
		<form method="post" action="<%=request.getContextPath()%>/addStudentController.team2" class="form-horizontal">
			<div class="studentId form-group has-feedback">
				<label for="studentId" class="col-sm-2 control-label">student_id</label>
				<div class="col-sm-10">
					<input type="text" id="studentId" name="studentId" class="studentId form-control" placeholder="아이디를 입력하세요">
					<span class="studentId form-control-feedback"></span>
					<p class="studentId">아이디는 5글자 이상입니다</p>
				</div>
			</div>
			<div class="studentPw form-group has-feedback">
				<label for="studentPw" class="col-sm-2 control-label">student_pw</label>
				<div class="col-sm-10">
					<input type="password" id="studentPw" name="studentPw" class="studentPw form-control" placeholder="비밀번호를 입력하세요">
					<span class="studentPw form-control-feedback"></span>
					<p class="studentPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
			<div class="studentPwCheck form-group has-feedback">
				<label for="studentPwCheck" class="col-sm-2 control-label">student_pw 확인</label>
				<div class="col-sm-10">
					<input type="password" id="studentPwCheck" name="studentPwCheck" class="studentPwCheck form-control"  placeholder="입력한 비밀번호를 확인해주세요">
					<span class="studentPwCheck form-control-feedback"></span>
					<p class="studentPwCheck">비밀번호가 일치하지 않습니다</p>
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">student추가</button>			 
		  	</div>
		</form>
	</div>
</body>
</html>
