<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Student" %>
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
	<div class="page-header">
		<h1>
			updateStudent
			<small>
				학생수정
			</small>
		</h1>
	</div>
	<%
	Student student = (Student)request.getAttribute("student");
	%>
	<div id="form">
		<form action="<%=request.getContextPath() %>/updateStudentController.team2" class="form-horizontal" method="post">
			<input type="hidden" name="studentNo" value="<%=student.getStudentNo()%>">
			<div class="form-group">
				<label class="col-sm-2 control-label">student_id</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=student.getStudentId()%></p>
				</div>
			</div>
			<div class="studentPw form-group has-feedback">
				<label for="studentPw" class="col-sm-2 control-label">student_pw</label>
				<div class="col-sm-10">
					<input type="text" class="studentPw form-control" id="studentPw" name="studentPw" value="<%=student.getStudentPw()%>">
					<span class="studentPw form-control-feedback"></span>
					<p class="studentPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
			<button type="button" id="change" class="btn btn-primary btn-lg btn-block">student수정</button>
			<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='<%=request.getContextPath()%>/getStudentListController.team2'">학생리스트으로 돌아가기</button>
		</form>
	</div>
</body>
</html>