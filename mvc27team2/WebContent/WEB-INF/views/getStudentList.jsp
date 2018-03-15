<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>getStudentList</h1>
	<table>
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
		<%
			ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
			for(Student student : list){
		%>
				<tr>
					<th>
						<%=student.getStudentNo() %>
					</th>
					<th>
						<%=student.getStudentId() %>
					</th>
					<th>
						*****
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/addStudentAddrController.team2?studentNo=<%=student.getStudentNo() %>">주소추가</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/updateStudentController.team2?studentNo=<%=student.getStudentNo() %>">수정하기</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/deleteStudentController.team2?studentNo=<%=student.getStudentNo() %>">삭제하기</a>
					</th>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>