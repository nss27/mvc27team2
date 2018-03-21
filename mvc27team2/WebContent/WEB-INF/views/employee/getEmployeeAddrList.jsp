<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.EmployeeAddr"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
		body {
			background: linear-gradient(to right, rgba(255, 0, 0, 0.5), rgba(209, 178, 255, 1));
		}
		.page-header {
			text-align: center;
		}
		.center-block {
			width: 50%;
		}
		.table-hover>tbody>tr:hover {
			background-color: rgba(245, 245, 245, .5);
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('input#allAddrNo').click(function() {
				var allCheck = $('input#allAddrNo').is(':checked');
				if (allCheck == true) {
					$('input:checkbox').prop('checked', true);
				} else {
					$('input:checkbox').prop('checked', false);
				}
			});
			$('button#delete').click(function() {
				if ($('input:checkbox').is(':checked')) {
					$('form').submit();
				} else {
					alert('선택한 항목이 없습니다');
				}
			});
		});
	</script>
</head>
<body>
	<div class="page-header">
		<h1>
			getEmployeeAddrList
			<small>
				직원주소리스트
			</small>
		</h1>		
	</div>
	<div class="center-block">
		<form action="<%=request.getContextPath()%>/deleteEmployeeAddrController.team2" method="post">
			<table class="table table-hover table-condensed ">
				<thead>
					<tr>
						<th>
						<input type="checkbox" id="allAddrNo">
							employeeAddrNo
						</th>
						<th>
							employeeNo
						</th>
						<th>
							employeeId
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
					<%
						ArrayList<EmployeeAddr> list = (ArrayList<EmployeeAddr>) request.getAttribute("list");
						for (EmployeeAddr employeeAddr : list) {
					%>
					<tr>
						<td>
							<input type="checkbox" name="employeeAddrNo" value="<%=employeeAddr.getEmployeeAddrNo()%>">
							<%=employeeAddr.getEmployeeAddrNo()%>
						</td>
						<td>
							<%=employeeAddr.getEmployeeNo()%>
						</td>
						<td>
							<%=employeeAddr.getEmployeeId()%>
						</td>
						<td>
							<%=employeeAddr.getAddress()%>
						</td>
						<td>
							<a href="<%=request.getContextPath() %>/updateEmployeeAddrComtroller.team2?employeeAddrNo=<%=employeeAddr.getEmployeeAddrNo()%>">수정하기</a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
	
			</table>
		</form>
		<button id="delete" type="button" class="btn btn-primary btn-lg btn-block">삭제하기</button>
		<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='<%=request.getContextPath()%>/indexController.team2'">메인으로 돌아가기</button>

	</div>
</body>
</html>