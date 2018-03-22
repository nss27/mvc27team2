<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<form action="${pageContext.request.contextPath}/searchTeacherAddrController.team2" method="post">
	<select>
		<option value="teacherId">선생님아이디</option>
		<option value="address">선생님주소</option>
		<option value="teacherNo">선생님번호</option>	
	</select>
	<input type="text" name="teacherSearch">
	<button type="submit">검색하기</button>
</form>