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
			var count = ${count};
			if(count>=5){
				$('input.address').attr('disabled','disabled');
			}
			$("input.address").blur(function(){
				if($(this).val() == ""){
					$(this).parent().removeClass("has-success");
					$(this).parent().addClass("has-danger");
					$(this).removeClass("is-valid");
					$(this).addClass("is-invalid");
				}else{
					$(this).parent().removeClass("has-danger");
					$(this).parent().addClass("has-success");
					$(this).removeClass("is-invalid");
					$(this).addClass("is-valid");
				}
			});
			$("button#add").click(function(){
				if($('input.address').attr('disabled')){
					alert('주소 등록 횟수를 초과하였습니다');
				}else if($("input.address").val() == ""){
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
		<img alt="addStudentaddrList" src="${pageContext.request.contextPath}/image/addStudentaddrList.png">
	</div>
	
	<div id="form">
		<button type="button" class="close" aria-label="Close" onclick="location.href='${pageContext.request.contextPath}/getStudentListController.team2'"><span aria-hidden="true">&times;</span></button>
		<br>
		<form action="${pageContext.request.contextPath}/addStudentAddrController.team2" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">studentNo</label>
				<div class="col-sm-10">
					<p class="form-control-static">${studentNo}</p>
					<input type="hidden" name="studentNo" value="${studentNo}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">studentId</label>
				<div class="col-sm-10">
					<p class="form-control-static">${studentId}</p>
				</div>
			</div>
			<div class="address form-group has-feedback">
				<label for="address" class="col-sm-2 control-label">address</label>
				<div class="col-sm-10">
					<input type="text" class="address form-control" id="address" name="address" placeholder="주소를 입력해주세요">
					<span class="address form-control-feedback"></span>
				</div>
			</div>
			<button type="button" id="add" class="btn btn-outline-primary btn-lg btn-block">studentAddress 추가</button>
		</form>
	</div>
</body>
</html>