<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addTeacher</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	body{
		background: linear-gradient(to right, rgba(255,0,0,.5), rgba(209,178,255,1));
	}
	h2{
		text-align: center;
		padding-bottom: 20px;
	}
	div#form{
		margin: 30px auto;
		padding: 10px 10px 10px 10px;
		width: 60%;
		background-color: rgba(255,255,255,.5);
		border-radius : 7px;
		box-shadow: 5px 5px 5px rgba(58,58,58,.5);
	}
	
</style>
<script>
	$(document).ready(function(){
		$("p").hide();
		$("input.teacherId").blur(function(){
			if($("input.teacherId").val().length < 5){
				$("div.teacherId").addClass("has-error");
				$("span.teacherId").addClass("glyphicon glyphicon-alert");
				$("p.teacherId").show();
			}else {
				$("div.teacherId").removeClass("has-error");
				$("span.teacherId").removeClass("glyphicon glyphicon-alert");
				$("div.teacherId").addClass("has-success");
				$("span.teacherId").addClass("glyphicon glyphicon-ok");
				$("p.teacherId").hide();
			}
		});
		$("input.teacherPw").blur(function(){
			if($("input.teacherPw").val().length < 10){
				$("div.teacherPw").addClass("has-error");
				$("span.teacherPw").addClass("glyphicon glyphicon-alert");
				$("p.teacherPw").show();
			}else {
				$("div.teacherPw").removeClass("has-error");
				$("span.teacherPw").removeClass("glyphicon glyphicon-alert");
				$("div.teacherPw").addClass("has-success");
				$("span.teacherPw").addClass("glyphicon glyphicon-ok");
				$("p.teacherPw").hide();
			}
		});
		$("input.teacherPwCheck").blur(function(){
			if($("input.teacherPwCheck").val() === $("input.teacherPw").val()){
				$("div.teacherPwCheck").removeClass("has-error");
				$("span.teacherPwCheck").removeClass("glyphicon glyphicon-alert");
				$("div.teacherPwCheck").addClass("has-success");
				$("span.teacherPwCheck").addClass("glyphicon glyphicon-ok");
			}else {
				$("p.teacherPwCheck").hide();
				$("div.teacherPwCheck").addClass("has-error");
				$("span.teacherPwCheck").addClass("glyphicon glyphicon-alert");
				$("p.teacherPwCheck").show();
			}
		});
		$("button").click(function(){
			if($("input.teacherId").val() == "" || $("input.teacherId").val().length < 5){
				alert("아이디를 다시 입력하세요");
				$("input.teacherId").focus();
			}else if($("input.teacherPw").val() == "" || $("input.teacherPw").val().length < 10){
				alert("비밀번호를 다시 입력하세요");
				$("input.teacherPw").focus();
			}else if($("input.teacherPwCheck").val() == "" || $("input.teacherPw").val() == "" || $("input.teacherId").val() == ""){
				alert("비밀번호가 일치하는지 확인하세요.");
				$("input.teacherPw").focus();
			}else{
				$("form").submit();
			}
		});
	});
</script>
</head>
	<body>
		<div id="form">
			<h2>addTeacher</h2>
			<form method="post" action="<%=request.getContextPath()%>/addteacherController.team2" class="form-horizontal">
			<div class="teacherId form-group has-feedback">
				<label for="teacherId" class="col-sm-2 control-label">Teacher_id</label>
				<div class="col-sm-10">
					<input type="text" id="teacherId" name="teacherId" class="teacherId form-control" placeholder="아이디를 입력하세요">
					<span class="teacherId form-control-feedback"></span>
					<p class="teacherId">아이디는 5글자 이상입니다</p>
				</div>
			</div>
			<div class="teacherPw form-group has-feedback">
				<label for="teacherPw" class="col-sm-2 control-label">Teacher_pw</label>
				<div class="col-sm-10">
					<input type="password" id="teacherPw" name="teacherPw" class="teacherPw form-control" placeholder="비밀번호를 입력하세요" >
					<span class="teacherPw form-control-feedback"></span>
					<p class="teacherPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
				<div class="teacherPwCheck form-group has-feedback">
				<label for="teacherPwCheck" class="col-sm-2 control-label">Teacher_pw확인</label>
				<div class="col-sm-10">
					<input type="password" id="teacherPwCheck" name="teacherPwCheck" class="teacherPwCheck form-control" placeholder="입력한 비밀번호를 확인해주세요">
					<span class="teacherPwCheck form-control-feedback"></span>
					<p class="teacherPwCheck">비밀번호가 일치하지않습니다</p>
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">teacher추가</button>
		</form>
	</div>
	</body>
</html>
