<!-- 배건혜 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('select[name=employeeSelect]').click(function(){
			var option = $(this).val();
			if(option == 'employeeId'){
				$('input[name=employeeSearch]').attr('placeholder','검색할 직원아이디를 입력하세요.');
			}else if(option == 'address'){
				$('input[name=employeeSearch]').attr('placeholder','검색할 직원주소를 입력하세요.');
			}else if(option == 'employeeNo'){
				$('input[name=employeeSearch]').attr('placeholder','검색할 직원번호를 입력하세요.');
			}
		});
	});
</script>
<form action="${pageContext.request.contextPath}/getEmplyeeAddrListController.team2" method="post">
	<select name="employeeSelect" class="form-control mr-sm-2">
		<option value="employeeId" selected="selected">
			직원아이디
		</option>
		<option value="address">
			직원주소
		</option>
		<option value="employeeNo">
			직원번호 
		</option>
	</select>
	<input type="text" name="employeeSearch" class="form-control mr-sm-2" placeholder="검색할 직원아이디를 입력하세요.">
	<button type="submit" class="btn btn-secondary my-2 my-sm-0">검색하기</button>
</form>
