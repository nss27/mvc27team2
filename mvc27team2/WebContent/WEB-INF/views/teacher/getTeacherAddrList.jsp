<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.TeacherAddr" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getTeacherAddrList</title>
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
	<h2>getTeacherAddrList</h2>
		<div class="center-block">
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>
						teacherAddrNo
					</th>
					<th>
						teacherNo
					</th>
					<th>
						teacherId
					</th>
					<th>
						address
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
				//TeacherAddr의 리스트를 정렬 시켜준다.
				ArrayList<TeacherAddr> list = (ArrayList<TeacherAddr>)request.getAttribute("list");
				for( TeacherAddr teacherAddr : list){
			%>
					<tr>
						<td>
							<%=teacherAddr.getTeacherAddrNo() %>
						</td>
						<td>
							<%=teacherAddr.getTeacherNo() %>
						</td>
						<td>
							<%=teacherAddr.getTeacherId() %>
						</td>
						<td>
							<%=teacherAddr.getAddress() %>
						</td>
						<td>
							<a href="#">수정하기</a>
						</td>
						<td>
							<a href="#">삭제하기</a>
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