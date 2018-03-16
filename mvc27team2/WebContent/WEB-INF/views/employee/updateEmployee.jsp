<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
body {
	background: linear-gradient(to right, rgba(255, 0, 0, 0.5),
		rgba(209, 178, 255, 1));
}

h2 {
	text-align: center;
	padding-bottom: 20px;
}

div#form {
	margin: 0 auto;
	padding: 10px 10px 10px 10px;
	width: 60%;
	background-color: rgba(255, 255, 255, 5);
	border-radius: 7px;
	box-shadow: 5px, 5px, 5px rgba(58, 58, 58, 5);
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("p.employeePw").hide();
		$("input.employeePw").blur(function(){
			if($("input.employeePw").val().length<10){
				$("div.employeePw").removeClass("has-success");
				$("div.employeePw").addClass("has-error");
				$("span.employeePw").addClass("glyphicon glyphicon-alert");	
				$("p.employeePw").show();
			}else{
				$("div.employeePw").removeClass("has-error");
				$("div.employeePw").addClass("has-success");
				$("span.employeePw").removeClass("glyphicon glyphicon-alert");
				$("span.employeePw").addClass("glyphicon glyphicon-ok");
				$("p.employeePw").hide();
				
			}
		});
		$("button").click(function() {
			if($("input.employeePw").val()=="" || $("input.employeePw").val().length<10){
				alert("비밀번호를 다시 입력하세요");
				$("input.employeePw").focus();
			}else {
				$("form").submit();
			}
		});
	});
</script>
</head>
<body>
	<h2>updateEmployee</h2>

	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>
	<div id="form">
		<form action="<%=request.getContextPath()%>/updateEmployeeController.team2" class="form-horizontal" method="post">
			<input type="hidden" name="employeeNo" value="<%=employee.getEmployeeNo() %>">
			<div class="form-group">
				<label class="col-sm-2 control-label">employee_id</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=employee.getEmployeeId()%></p>
					<input type="hidden" name="employeeId" value="<%=employee.getEmployeeId()%>">
				</div>
			</div>
			<div class="employeePw form-group has-feedback" >
				<label for="employeePw" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="text" class="employeePw form-control" id="employeePw" name="employeePw" value="<%=employee.getEmployeePw()%>">
					<span class="employeePwCheck form-control-feedback"></span>
					<p class="employeePwCheck">비밀번호가 일치하지 않습니다</p>
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">employee수정</button>
		</form>
	</div>
</body>
</html>