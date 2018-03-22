<!-- 나성수 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('select[name=studentSelect]').click(function(){
			var option = $(this).val();
			if(option == 'studentId'){
				$('input[name=studentSearch]').attr('placeholder','검색할 학생아이디를 입력하세요.');
			}else if(option == 'address'){
				$('input[name=studentSearch]').attr('placeholder','검색할 학생주소를 입력하세요.');
			}else if(option == 'studentNo'){
				$('input[name=studentSearch]').attr('placeholder','검색할 학생번호를 입력하세요.');
			}
		});
	});
</script>
<form action="${pageContext.request.contextPath}/getStudentAddrListController.team2" method="post">
	<select name="studentSelect">
		<option value="studentId" selected="selected">학생아이디</option>
		<option value="address">학생주소</option>
		<option value="studentNo">학생번호</option>
	</select>
	<input type="text" name="studentSearch" placeholder="검색할 아이디를 입력하세요.">
	<button type="submit">검색하기</button>
</form>