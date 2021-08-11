<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<style>

</style>

</head>
<body>
	<!-- ex03.jsp -->
	<div class="container">
		<h1 class="page-header">쿠키 예제</h1>
		
		<form method="post" action='login.ok'>
		<table class="table table-bordered" style='width:300px;'>
			<tr>
				<th style="width:100px;">아이디</th>
				<td><input type="text" name="txtid" id="txtid" class="form-control"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="txtpw" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="btn btn-default" value="로그인">\
					
					<label><input type="checkbox" id="cb">아이디 저장하기</label>
				<td>
			</tr>
		</table>
		</form>
		
		
	</div>

	<script src="<%= request.getContextPath() %>/asset/js/cookie.js"></script>
	<script>
	
	 	$('#btn').click(function(){
	 		//로그인 처리 !!
	 		 this.form.submit(); // 폼 전송 (에뮬레이터 함수 )
	 		
	 	})
	
	</script>	
</body>
</html>