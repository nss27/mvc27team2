<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>getEmployeeList</h1>
	<table>
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
		<%
			ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
			for(Employee employee : list){
				
			
		%>
				<tr>
					<th>
						<%=employee.getEmployeeNo() %>
					</th>
					<th>
						<%=employee.getEmployeeId() %>
					</th>
					<th>
						*************
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/addEmployeeAddrController.team2?employeeNo=<%=employee.getEmployeeNo() %>">주소추가</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/updateEmployeeController.team2?employeeNo=<%=employee.getEmployeeNo() %>">수정하기</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/deleteEmployeeController.team2?employeeNo=<%=employee.getEmployeeNo() %>">삭제하기</a>
					</th>
				</tr>
			<%
				}
			%>
		</tbody>
	
	</table>
</body>
</html>