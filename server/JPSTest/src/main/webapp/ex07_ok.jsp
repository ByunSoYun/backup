<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setCharacterEncoding("UTF-8");

	String width = request.getParameter("width"); 
	String height = request.getParameter("height"); 
	String txt1 = request.getParameter("txt1"); 
	String backgroundcolor = request.getParameter("backgroundcolor"); 
	String fontcolor = request.getParameter("fontcolor"); 
	String size = request.getParameter("size"); 
	String leftright = request.getParameter("leftright");
	String topbottom = request.getParameter("topbottom");
	int btnnumber = Integer.parseInt(request.getParameter("btnnumber"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<style>
	#tbl { width: 600px }
	#tbl td { text-align: center; }
	#tbl td { padding: 50px; }
	
	.button {
		 
		width: <%= width %>px;
		height: <%= height %>px;
		background-color: <%= backgroundcolor %>;
		color: <%= fontcolor %>;
		font-size: <%= size %>px;
		margin: <%= topbottom %>px <%= leftright %>px;
		
</style>

</head>
<body>
	<!--  -->
	<div class="container">
		<h1 class="page-header">결과</h1>
 	<form method="GET" action="ex07_ok.jsp">
	<table id="tbl" class="table table-bordered">
	
	
	<tr>
	<td>버튼</td>
	</tr>
	
	<tr>
	<td><% for (int i=0; i<btnnumber; i++) { %>
						<button class="button">
							<%= txt1 %>
						</button>
					<% } %></td>
	</tr>
	
	</table>
	
	
	
	
	</div>
	

	<script>
	
	
	
	</script>	
</body>
</html>