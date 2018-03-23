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
		#list.center-block{
			width: 50%;
		}
		#page.center-block{
			width: 100%;
			text-align: center;
		}
		.table-hover > tbody > tr:hover{
			background-color: rgba(245,245,245,.5);
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
<body>
	<div class="page-header">
		<h1>
			getStudentAddrList
			<small>
				학생주소리스트
			</small>
		</h1>
	</div>
	<div id="list" class="center-block">
		<%@ include file="/WEB-INF/views/student/searchStudentAddrList.jsp" %><br>
		<form action="${pageContext.request.contextPath}/deleteStudentAddrController.team2" method="post">
			<table class="table table-hover table-condensed">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="allAddrNo">
							studentAddrNo
						</th>
						<th>
							studentNo
						</th>
						<th>
							studentId
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
					<c:forEach var="studentAddr" items="${list}">
						<tr>
							<td>
								<input type="checkbox" name="studentAddrNo" value="${studentAddr.studentAddrNo}">
								${studentAddr.studentAddrNo}
							</td>
							<td>
								${studentAddr.studentNo}
							</td>
							<td>
								${studentAddr.studentId}
							</td>
							<td>
								${studentAddr.address}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/updateStudentAddrController.team2?studentAddrNo=${studentAddr.studentAddrNo}">수정하기</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="page" class="center-block">
				<c:if test="${currentPage > 1}">
					<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2">처음으로</a>
					<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${currentPage - 1}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">이전</a>
				</c:if>
				<c:forEach var="pageNumber" items="${pageNumber}">
					<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${pageNumber}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">${pageNumber}</a>
				</c:forEach>
				<c:if test="${currentPage < lastPage}">
					<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${currentPage + 1}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">다음</a>
					<a href="${pageContext.request.contextPath}/getStudentAddrListController.team2?currentPage=${lastPage}&studentSelect=${studentSelect}&studentSearch=${studentSearch}">마지막으로</a>
				</c:if>
			</div>
			<button id="delete" type="button" class="btn btn-primary btn-lg btn-block">삭제하기</button>
			<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='${pageContext.request.contextPath}/indexController.team2'">메인으로 돌아가기</button>
		</form>
	</div>
</body>
</html>