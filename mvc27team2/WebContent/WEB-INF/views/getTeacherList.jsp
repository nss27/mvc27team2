<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Teacher" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>getTeacherList</h1>
	<table>
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
		<%
			ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("list");
			for(Teacher teacher : list){
		%>
				<tr>
					<th>
						<%=teacher.getTeacherNo() %>
					</th>
					<th>
						<%=teacher.getTeacherId() %>
					</th>
					<th>
						*****
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/addTeacherAddrController.team2?teacherNo=<%=teacher.getTeacherNo() %>">주소추가</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/updateTeacherController.team2?teacherNo=<%=teacher.getTeacherNo() %>">수정하기</a>
					</th>
					<th>
						<a href="<%=request.getContextPath()%>/deleteTeacherController.team2?teacherNo=<%=teacher.getTeacherNo() %>">삭제하기</a>
					</th>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>