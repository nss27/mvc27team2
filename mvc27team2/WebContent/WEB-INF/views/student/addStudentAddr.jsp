<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			$("button").click(function(){
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
	<h2>addStudentAddr.jsp</h2>
	<%
		int studentNo = (int)request.getAttribute("studentNo");
		String studentId = (String)request.getAttribute("studentId");
	%>
	<div id="form">
		<form action="<%=request.getContextPath() %>/addStudentAddrController.team2" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">studentNo</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=studentNo %></p>
					<input type="hidden" name="studentNo" value="<%=studentNo %>">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">studentId</label>
				<div class="col-sm-10">
					<p class="form-control-static"><%=studentId %></p>
				</div>
			</div>
			<div class="address form-group has-feedback">
				<label for="address" class="col-sm-2 control-label">address</label>
				<div class="col-sm-10">
					<input type="text" class="address form-control" id="address" name="address" placeholder="주소를 입력해주세요">
					<span class="address form-control-feedback"></span>
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">studentAddress 추가</button>
		</form>
	</div>
</body>
</html>