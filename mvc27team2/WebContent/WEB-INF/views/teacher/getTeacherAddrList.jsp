<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getTeacherAddrList</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/lux/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/sass/_bootswatch.scss">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/sass/_variables.scss">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
	<style type="text/css">
		html,body{
			width: 100%;
			height: 100%;
		}
		body{
			background-image: url("data:image/jpeg;base64,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");
			padding-top: 15%;
		}
		.page-header{
			text-align: center;
		}
		#list.center-block{
			width: 50%;
			padding: 25px 25px 25px 25px;
			background-color: rgba(255,255,255,.5);
			box-shadow: 5px 5px 5px rgba(58,58,58,.5);
		}
		#page.center-block{
			width: 100%;
			text-align: center;
		}
		.table-hover > tbody > tr:hover{
			background-color: rgba(245,245,245,.5);
		}
		div.title{
			font-family: 'Anton', sans-serif;
			text-align: center;
			font-size: 60pt;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('input#allAddrNo').click(function(){
				var allCheck = $('input#allAddrNo').is(':checked');
				if(allCheck == true){
					$('input:checkbox').prop('checked',true);
				}else{
					$('input:checkbox').prop('checked',false);
				}				
			});
			$('button#delete').click(function(){
				if($('input:checkbox').is(':checked')){
					$('form').submit();
				}else{
					alert('선택한 항목이 없습니다');
				}
			});
		});
	</script>
</head>
<body data-spy="scroll" data-target=".navbar-example">
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/indexController.team2">TEAM2</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navbar-example collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="#">
						Home<span class="sr-only">(current)</span>
					</a>
				</li>
				<li class="nav-item">
					<a role="presentation" class="nav-link" href="#student">STUDENT</a>
				</li>
				<li class="nav-item">
					<a role="presentation" class="nav-link" href="#employee">EMPLOYEE</a>
				</li>
				<li class="nav-item">
					<a role="presentation" class="nav-link" href="#teacher">TEACHER</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="title">
	<img src="./image/addTeacheraddr.png"/>
	</div>
	<div id="list" class="center-block">
			<form action="${pageContext.request.contextPath}/deleteTeacherAddrController.team2" method="post">
			<table class="table table-hover table-condensed">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="allAddrNo">
							teacherAddrNo
						</th>
						<th>
							teacherNo
						</th>
						<th>
							teacherId
						</th>
						<th>
							address
						</th>
						<th>
							수정
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="teacherAddr" items="${list}">
						<tr>
							<td>
								<input type="checkbox" name="teacherAddrNo" value="${teacherAddr.teacherAddrNo}">
								${teacherAddr.teacherAddrNo}
							</td>
							<td>
								${teacherAddr.teacherNo}
							</td>
							<td>
								${teacherAddr.teacherId}
							</td>
							<td>
								${teacherAddr.address}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/updateTeacherAddrController.team2?teacherAddrNo=${teacherAddr.teacherAddrNo}">수정하기</a>
							</td>
						</tr>
				</c:forEach>
				</tbody>
			</table>
			</form>
			<button id="delete" type="button" class="btn btn-primary btn-lg btn-block">삭제하기</button>
		</div>
</body>
</html>