<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/searchEmployeeAddrController.team2" method="post">
	<select name="employeeSelect">
		<option>
			직원아이디
		</option>
		<option>
			직원주소
		</option>
		<option>
			직원번호 
		</option>
	</select>
	<input type="text" name="employeeSearch">

</form>
