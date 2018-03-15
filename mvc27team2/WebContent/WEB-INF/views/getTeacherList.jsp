<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getTeacherList</title>
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
			for(Teacher teacher :list){
		%>
			<tr>
				<th>
					<%=teacher.getTeacherNo() %>
				</th>
				<th>
					<%=teacher.getTeacherId() %>
				</th>
				<th>
					****
				</th>
				<th>
					<a href="">주소</a>
				</th>
				<th>
					<a href="">수정</a>
				</th>
				<th>
					<a href="">삭제</a>
				</th>
			</tr>
		<%
		}
		%>
		</tbody>
		</table>
	</body>
</html>