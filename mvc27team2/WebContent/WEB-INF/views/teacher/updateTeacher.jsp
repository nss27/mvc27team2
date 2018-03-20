<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Teacher" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>updateTeacher.jsp</title>
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
	<script type="text/javascript">
		$(document).ready(function(){
			$("p.teacherPw").hide();
			$("input.teacherPw").blur(function(){
				if($("input.teacherPw").val().length < 10){
					$("div.teacherPw").addClass("has-error");
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
			$("button").click(function(){
				if($("input.teacherPw").val() == "" || $("input.teacherPw").val().length < 10){
					alert("비밀번호를 다시입력하세요");
					$("input.teacherPw").focus();
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
			updateTeacher
			<small>
				선생님수정
			</small>
		</h1>
	</div>
	<%
		Teacher teacher = (Teacher)request.getAttribute("teacher");
	%>
	<div id="form">
		<form action="<%= request.getContextPath()%>/updateTeacherController.team2"class="form-horizontal" method="post">
			<input type="hidden" name="teacherNo" value="<%=teacher.getTeacherNo()%>">
			<div class="form-group">
				<label class="col-sm-2 control-label">teacher_Id</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=teacher.getTeacherId() %></p>
					<input type="hidden" name="teacherId" value="<%=teacher.getTeacherId() %>">
				</div>
			</div>
			<div class="teacherPw form-group has-feedback">
				<label for="teacherPw" class="col-sm-2 control-label">teacher_pw</label>
				<div class="col-sm-10">
					<input type="text" class="teacherPw form-control" id="teacherPw" name="teacherPw" value="<%=teacher.getTeacherPw() %>">
					<span class="teacherPw form-control-feedback"></span>
					<p class="teacherPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">teacher수정</button>
			<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='<%=request.getContextPath()%>/indexController.team2'">메인으로 돌아가기</button>
		</form>
	</div>
</body>
</html>