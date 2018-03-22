<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		.page-header{
			text-align: center;
		}
		.center-block{
			width: 50%;
		}
		.table-hover > tbody > tr:hover{
			background-color: rgba(245,245,245,.5);
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('a.delete').click(function(){
				var count = $(this).parents('tr').find('span.studentAddrCount').text();
				if(count != 0){
					alert('등록된 주소 '+count+'개를 모두 지우시면 삭제가능합니다');
					$(this).attr('href','#');
				}
			});
		});
	</script>
</head>
<body>
	<div class="page-header">
		<h1>
			getStudentList
			<small>
				학생리스트
			</small>
		</h1>
	</div>
	<div class="center-block">
		<%@ include file="/WEB-INF/views/student/searchStudentAddr.jsp" %>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>
						studentNo
					</th>
					<th>
						studentId
					</th>
					<th>
						studentPw
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
				<c:forEach var="student" items="${list}">
					<tr>
						<td>
							${student.studentNo}
						</td>
						<td>
							${student.studentId}
						</td>
						<td>
							*****
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/addStudentAddrController.team2?studentNo=${student.studentNo}">주소추가<span class="studentAddrCount badge">${student.studentAddrCount}</span></a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/updateStudentController.team2?studentNo=${student.studentNo}">수정하기</a>
						</td>
						<td>
							<a class="delete" href="${pageContext.request.contextPath}/deleteStudentController.team2?studentNo=${student.studentNo}" >삭제하기</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'">메인으로 돌아가기</button>
	</div>
</body>
</html>