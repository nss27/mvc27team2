<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<a>주소추가</a>
					</th>
					<th>
						<a>수정하기</a>
					</th>
					<th>
						<a>삭제하기</a>
					</th>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>