<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.StudentAddr" %>
<!DOCTYPE html PUBLIC>
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
			$("input.address").blur(function(){
				if($("input.address").val() == ""){
					$("div.address").removeClass("has-success");
					$("div.address").addClass("has-error");
					$("span.address").removeClass("glyphicon glyphicon-ok");
					$("span.address").addClass("glyphicon glyphicon-alert");
				}else{
					$("div.address").removeClass("has-error");
					$("div.address").addClass("has-success");
					$("span.address").removeClass("glyphicon glyphicon-alert");
					$("span.address").addClass("glyphicon glyphicon-ok");
				}
			});
			$("button#change").click(function(){
				if($("input.address").val() == ""){
					alert("주소를 입력해주세요");
					$("input.address").focus();
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
			updateStudentAddr
			<small>
				학생주소수정
			</small>
		</h1>
	</div>
	<%
	StudentAddr studentAddr = (StudentAddr)request.getAttribute("studentAddr");
	%>
	<div id="form">
		<form action="<%=request.getContextPath() %>/updateStudentAddrController.team2" class="form-horizontal" method="post">
			<input type="hidden" name="studentAddrNo" value="<%=studentAddr.getStudentAddrNo()%>">
			<div class="form-group">
				<label class="col-sm-2 control-label">student_id</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=studentAddr.getStudentId()%></p>
				</div>
			</div>
			<div class="address form-group has-feedback">
				<label for="address" class="col-sm-2 control-label">address</label>
				<div class="col-sm-10">
					<input type="text" class="address form-control" id="address" name="address" value="<%=studentAddr.getAddress()%>">
					<span class="address form-control-feedback"></span>
				</div>
			</div>
			<button type="button" id="change" class="btn btn-primary btn-lg btn-block">studentAddr 수정</button>
			<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='<%=request.getContextPath()%>/getStudentAddrListController.team2'">학생주소리스트로 돌아가기</button>
		</form>
	</div>
</body>
</html>