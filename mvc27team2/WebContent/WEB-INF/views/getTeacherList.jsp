<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Teacher" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style>
		body{
			background: linear-gradient(to right,rgba(255,0,0,0.5), rgba(209,178,255,1));
		}
		h2{
			text-align: center;
			padding-bottom: 20px;
		}
		.center-block{
			width: 50%;	
		}
		.table-hover > tbody > tr:hover{
			background-color:rgba(245,245,245,.5);
		}
	</style>
</head>
<body>
	<h2>getTeacherList</h2>
	<div class="center-block">
		<table class="table table-hover table-condensed">
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
					<tr >
						<td>
							<%=teacher.getTeacherNo() %>
						</td>
						<td>
							<%=teacher.getTeacherId() %>
						</td>
						<td>
							*****
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/addTeacherAddrController.team2?teacherNo=<%=teacher.getTeacherNo() %>">주소추가</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/updateTeacherController.team2?teacherNo=<%=teacher.getTeacherNo() %>">수정하기</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/deleteTeacherController.team2?teacherNo=<%=teacher.getTeacherNo() %>">삭제하기</a>
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