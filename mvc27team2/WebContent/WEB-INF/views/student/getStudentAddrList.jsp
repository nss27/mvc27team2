<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.StudentAddr" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
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
			background-color: rgba(245,245,245,.5);
		}
	</style>
</head>
<body>
	<h2>getStudentAddrList.jsp</h2>
	<div class="center-block">
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>
						studentAddrNo
					</th>
					<th>
						studentNo
					</th>
					<th>
						studentId
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
				ArrayList<StudentAddr> list = (ArrayList<StudentAddr>)request.getAttribute("list");
				for(StudentAddr studentAddr : list){
			%>
					<tr>
						<td>
							<%=studentAddr.getStudentAddrNo() %>
						</td>
						<td>
							<%=studentAddr.getStudentNo() %>
						</td>
						<td>
							<%=studentAddr.getStudentId() %>
						</td>
						<td>
							<%=studentAddr.getAddress() %>
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