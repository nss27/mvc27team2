<!-- ����� -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
body {
	background: linear-gradient(to right, rgba(255, 0, 0, 0.5),
		rgba(209, 178, 255, 1));
}

h2 {
	text-align: center;
	padding-bottom: 20px;
}

.center-block {
	width:50%;
}
.table-hover > tbody > tr:hover{
	background-color: rgba(245,245,245,.5);
}
</style>

<title>Insert title here</title>
</head>
<body>
	<h2>getEmployeeList</h2>
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
	
	</div>
</body>
</html>