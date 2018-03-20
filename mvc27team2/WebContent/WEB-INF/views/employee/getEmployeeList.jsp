<!-- ����� -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Employee"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
		body {
			background: linear-gradient(to right, rgba(255, 0, 0, 0.5),
				rgba(209, 178, 255, 1));
		}
		.page-header {
			text-align: center;
		}
		.center-block {
			width:50%;
		}
		.table-hover > tbody > tr:hover{
			background-color: rgba(245,245,245,.5);
		}
	</style>
</head>
<body>
	<div class="page-header">
		<h1>
			getEmployeeList
			<small>
				��������Ʈ
			</small>
		</h1>		
	</div>
	<div class="center-block">
		<table class="table table-hover table-condensed " >
			<thead>
				<tr>
					<th>
						employeeNo
					</th>
					<th>
						employeeId
					</th>
					<th>
						employeePw
					</th>
					<th>
						�ּ�
					</th>
					<th>
						����
					</th>
					<th>
						����
					</th>
	
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
					for (Employee employee : list) {
				%>
				<tr>
					<td>
						<%=employee.getEmployeeNo()%>
					</td>
					<td>
						<%=employee.getEmployeeId()%>
					</td>
					<td>
						*************
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/addEmployeeAddrController.team2?employeeNo=<%=employee.getEmployeeNo()%>">�ּ��߰�</a>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/updateEmployeeController.team2?employeeNo=<%=employee.getEmployeeNo()%>">�����ϱ�</a>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/deleteEmployeeController.team2?employeeNo=<%=employee.getEmployeeNo()%>">�����ϱ�</a>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>	
		<button type="button" id="return" class="btn btn-default btn-lg btn-block" onclick="location.href='<%=request.getContextPath()%>/indexController.team2'">�������� ���ư���</button>	
	</div>
</body>
</html>