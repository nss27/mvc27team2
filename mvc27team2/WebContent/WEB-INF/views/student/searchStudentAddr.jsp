<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/searchStudentAddrController.team2" method="post">
	<select name="studentSelect">
		<option value="studentId">학생아이디</option>
		<option value="address">학생주소</option>
		<option value="studentNo">학생번호</option>
	</select>
	<input type="text" name="studentSearch">
	<button type="submit">검색하기</button>
</form>