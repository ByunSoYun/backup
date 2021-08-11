<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//스크립틀릿 영역 
	//  = service 메소드 영역 
	
	//지역 변수
	int a = 10;


	//메소드안에 메소드 x 즉 메소드 못만듬 
%>
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
	<!-- ex10.jsp -->
	<div class="container">
		<h1 class="page-header">JSP 페이지</h1>
				
		<div>a: <%= a %></div>
		
		<%= request.getRealPath(".") %>
		
		C:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JPSTest
		---------------- workspace
		--------------------------metadata -> 이클립스나 톰킷이 쓰는 폴더
		<!-- 아파치톰캣을 웹사이트를 실행(운영)할 때
			 개발자가 만든 소스를 직접 사용하지 않는다!!!
			 -> 반드시 복사본을 만들어서 사용한다.
			 -> 그 복사본을 .metadata 이하에 저장해서 사용한다.
		-->
	
	</div>
	

	<script>
	
	
	
	</script>	
</body>
</html>