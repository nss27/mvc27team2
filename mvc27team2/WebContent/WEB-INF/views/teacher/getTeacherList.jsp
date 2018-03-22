<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getTeacherList</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style>
		body{
			background: linear-gradient(to right,rgba(255,0,0,0.5), rgba(209,178,255,1));
		}
		h2{
			text-align: center;
		}
		.center-block{
			width: 50%;	
		}
		.table-hover > tbody > tr:hover{
			background-color:rgba(245,245,245,.5);
		}
	</style>
</head>
<body>
	<div class="page-header">
		<h1>
			getTeacherList
			<small>
				선생님리스트
			</small>
		</h1>
	</div>
	<div class="center-block">
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>
						teacherNo
					</th>
					<th>
						teacherId
					</th>
					<th>
						teacherPw
					</th>
					<th>
						주소
					</th>
					<th>
						수정
					</th>
					<th>
						삭제
					</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="teacher" items="${list}">
						<tr>
							<td>
								${teacher.teacherNo}
							</td>
							<td>
								${teacher.teacherId}
							</td>
							<td>
								*****
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/addTeacherAddrController.team2?teacherNo=${teacher.teacherNo}">주소추가</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/updateTeacherController.team2?teacherNo=${teacher.teacherNo}">수정하기</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/deleteTeacherController.team2?teacherNo=${teacher.teacherNo}">삭제하기</a>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'">메인으로 돌아가기</button>
	</div>
</body>
</html>