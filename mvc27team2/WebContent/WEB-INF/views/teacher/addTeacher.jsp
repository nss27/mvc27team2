<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			$("input.teacherId").blur(function(){
				if($("input.teacherId").val().length < 5){
					$("div.teacherId").removeClass("has-success");
					$("div.teacherId").addClass("has-error");
					$("span.teacherId").removeClass("glyphicon glyphicon-ok");
					$("span.teacherId").addClass("glyphicon glyphicon-alert");
					$("p.teacherId").show();
				}else{
					$("div.teacherId").removeClass("has-error");
					$("div.teacherId").addClass("has-success");
					$("span.teacherId").removeClass("glyphicon glyphicon-alert");
					$("span.teacherId").addClass("glyphicon glyphicon-ok");
					$("p.teacherId").hide();
				}
			});
			$("input.teacherPw").blur(function(){
				if($("input.teacherPw").val().length < 10){
					$("div.teacherPw").removeClass("has-success");
					$("div.teacherPw").addClass("has-error");
					$("span.teacherPw").removeClass("glyphicon glyphicon-ok");
					$("span.teacherPw").addClass("glyphicon glyphicon-alert");
					$("p.teacherPw").show();
				}else{
					$("div.teacherPw").removeClass("has-error");
					$("div.teacherPw").addClass("has-success");
					$("span.teacherPw").removeClass("glyphicon glyphicon-alert");
					$("span.teacherPw").addClass("glyphicon glyphicon-ok");
					$("p.teacherPw").hide();
				}
			});
			$("input.teacherPwCheck").blur(function(){
				if($("input.teacherPwCheck").val() === $("input.studentPw").val()){
					$("div.teacherPwCheck").removeClass("has-error");
					$("div.teacherPwCheck").addClass("has-success");
					$("span.teacherPwCheck").removeClass("glyphicon glyphicon-alert");
					$("span.teacherPwCheck").addClass("glyphicon glyphicon-ok");
					$("p.teacherPwCheck").hide();
				}else{
					$("div.teacherPwCheck").removeClass("has-success");
					$("div.teacherPwCheck").addClass("has-error");
					$("span.teacherPwCheck").removeClass("glyphicon glyphicon-ok");
					$("span.teacherPwCheck").addClass("glyphicon glyphicon-alert");
					$("p.teacherPwCheck").show();
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
	<div class="page-header">
		<h1>
			addTeacher
			<small>
				선생님추가
			</small>
		</h1>
	</div>
		<div id="form">
			<form method="post" action="${pageContext.request.contextPath}/addTeacherController.team2" class="form-horizontal">
				<div class="teacherId form-group has-feedback">
					<label for="teacherId" class="col-sm-2 control-label">teacher_Id</label>
					<div class="col-sm-10">
						<input type="text" id="teacherId" name="teacherId" class="teacherId form-control" placeholder="아이디를 입력하세요">
						<span class="teacherId form-control-feedback"></span>
						<p class="teacherId">아이디는 5글자 이상입니다</p>
					</div>
				</div>
				<div class="teacherPw form-group has-feedback">
					<label for="teacherPw" class="col-sm-2 control-label">teacher_pw</label>
					<div class="col-sm-10">
						<input type="password" id="teacherPw" name="teacherPw" class="teacherPw form-control" placeholder="비밀번호를 입력하세요">
						<span class="teacherPw form-control-feedback"></span>
						<p class="teacherPw">비밀번호는 10글자 이상입니다</p>
					</div>
				</div>
				<div class="teacherPwCheck form-group has-feedback">
					<label for="teacherPwCheck" class="col-sm-2 control-label">teacher_pw 확인</label>
					<div class="col-sm-10">
						<input type="password" id="teacherPwCheck" name="teacherPwCheck" class="teacherPwCheck form-control"  placeholder="입력한 비밀번호를 확인해주세요">
						<span class="teacherPwCheck form-control-feedback"></span>
						<p class="teacherPwCheck">비밀번호가 일치하지 않습니다</p>
					</div>
				</div>
				<button type="button" class="btn btn-primary btn-lg btn-block">teacher추가</button>	
				<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'">메인으로 돌아가기</button>		 
			</form>
		</div>
	</body>
</html>