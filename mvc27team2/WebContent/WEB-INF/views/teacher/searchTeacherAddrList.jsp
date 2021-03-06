<!-- 나윤주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('select[name="teacherSelect"]').click(function(){
			var option = $(this).val();
			if(option == 'teacherId'){
				$('input[name=teacherSearch]').attr('placeholder','검색할 선생님아이디를 입력하세요.');
			}else if(option == 'address'){
				$('input[name=teacherSearch]').attr('placeholder','검색할 선생님주소를 입력하세요.');
			}else if(option == 'teacherNo'){
				$('input[name=teacherSearch]').attr('placeholder','검색할 선생님번호를 입력하세요.');
			}
		});
	});
</script>
<form action="${pageContext.request.contextPath}/getTeacherAddrListController.team2"  method="get" class="form-inline my-2 my-lg-0">
	<select name="teacherSelect" class="form-control mr-sm-2">
		<option value="teacherId" selected="selected">선생님아이디</option>
		<option value="address">선생님주소</option>
		<option value="teacherNo">선생님번호</option>	
	</select>
	<input type="text" name="teacherSearch" placeholder="검색할 아이디를 입력하세요.">
	<button type="submit" class="btn btn-secondary my-2 my-sm-0">검색하기</button>
</form>