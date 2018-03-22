<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addEmployee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
		body{
			background : linear-gradient(to right,rgba(255,0,0,0.5), rgba(209,178,255,1));
		 }
		 .page-header{
			 text-align: center;
		 }
		 div#form{
			 margin: 0 auto;
			 padding: 10px 10px 10px 10px;
			 width: 60%;
			 background-color: rgba(255, 255, 255, 5);
			 border-radius: 7px;
			 box-shadow: 5px, 5px, 5px rgba(58, 58, 58, 5);
			 
		 }
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("p").hide();
			$("input.employeeId").blur(function(){
				if($("input.employeeId").val().length<5){
					$("div.employeeId").removeClass("has-success");
					$("div.employeeId").addClass("has-error");
					$("span.studentId").removeClass("glyphicon glyphicon-ok");	
					$("span.employeeId").addClass("glyphicon glyphicon-alert");
					$("p.employeeId").show();
				}else{
					$("div.employeeId").removeClass("has-error");
					$("div.employeeId").addClass("has-success");
					$("span.employeeId").removeClass("glyphicon glyphicon-alert");
					$("span.employeeId").addClass("glyphicon glyphicon-ok");
					$("p.employeeId").hide();
					
				}
			});
		$("input.employeePw").blur(function(){
			if($("input.employeePw").val().length<10){
				$("div.employeePw").removeClass("has-success");
				$("div.employeePw").addClass("has-error");
				$("span.employeePw").removeClass("glyphicon glyphicon-ok");
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
		$("input.employeePwCheck").blur(function(){
			if($("input.employeePwCheck").val() === $("input.employeePw").val()){
				$("div.employeePwCheck").removeClass("has-error");
				$("div.employeePwCheck").addClass("has-success");
				$("span.employeePwCheck").removeClass("glyphicon glyphicon-alert");
				$("span.employeePwCheck").addClass("glyphicon glyphicon-ok");
				$("p.employeePwCheck").hide();
			}else{
				$("div.employeePwCheck").removeClass("has-success");
				$("div.employeePwCheck").addClass("has-error");
				$("span.employeePwCheck").removeClass("glyphicon glyphicon-ok");
				$("span.employeePwCheck").addClass("glyphicon glyphicon-alert");	
				$("p.employeePwCheck").show();
			}
		});
		$("button#add").click(function(){
			if($("input.employeeId").val()=="" || $("input.employeeId").val().length<5){
				alert("아이디를 입력하세요");
				$("input.employeeId").focus();
			}else if ($("input.employeePw").val()=="" || $("input.employeePw").val().length<10){
				alert("비밀번호를 입력하세요");
				$("input.employeePw").focus();
			}else if($("input.employeePwCheck").val()=="" || $("input.employeePwCheck").val() != $("input.employeePw").val() ){
				alert("비밀번호가 일치하는지 확인하세요")
				$("input.employeePwCheck").focus();
			}else {
				$("form").submit();
			}
			
		});
	});
	</script>
</head>
<body>
	<div class="page-header">
		<h1>addEmployee
			<small>
				직원추가
			</small>		
		</h1>		
	</div>
	<div id="form">
		<form method = "post" action="${pageContext.request.contextPath}/addEmployeeController.team2" class="form-horizontal">
			 <div class="employeeId form-group has-feedback">
				<label for="employeeId" class="col-sm-2 control-label">employee_id</label>
				<div class="col-sm-10">
					<input type="text" id="employeeId" name="employeeId" class="employeeId form-control" placeholder="아이디를 입력하세요">
					<span class="employeeId form-control-feedback"></span>
					<p class="employeeId">아이디는 5글자 이상입니다</p>
				</div>
			</div>
			<div class="employeePw form-group has-feedback">
				<label for="employeePw" class="col-sm-2 control-label">employee_pw</label>
				<div class="col-sm-10">
					<input type="password" id="employeePw" name="employeePw" class="employeePw form-control" placeholder="비밀번호를 입력하세요">
					<span class="employeePw form-control-feedback"></span>
					<p class="employeePw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
			<div class="employeePwCheck form-group has-feedback">
				<label for="employeePwCheck" class="col-sm-2 control-label">employee_pw 확인</label>
				<div class="col-sm-10">
					<input type="password" id="employeePwCheck" name="employeePwCheck" class="employeePwCheck form-control" placeholder="입력한 비밀번호를  확인해주세요">
					<span class="employeePwCheck form-control-feedback"></span>
					<p class="employeePwCheck">비밀번호가 일치하지 않습니다</p>
				</div>
			</div>
	      	<button type="button" id="add" class="btn btn-primary btn-lg btn-block">employee추가</button>
	      	<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'">메인으로 돌아가기</button>
		</form>
	</div>
</body>
</html>
