<%@page import="com.test.jsp.jdbc.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		String sql = "select * from tblTodo order by regdate asc";
		
		rs = stat.executeQuery(sql);
		
		
		
	}catch(Exception e){
		System.out.println(e);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.container {
		width: 500px;
		box-shadow: 0px 0px 5px #777;
		height: 100vh;
	}
	.container .page-header {
		font-variant: small-caps;
		letter-spacing: -1px;
	}
	
	.container .table th {
		text-align: center;
		vertical-align: middle;
		font-variant: small-caps;
	}
	
	.container .table th:nth-child(1) {
		width: 50px;
	}
	.container .table th:nth-child(3) {
		width: 70px;
	}
	
	.container .table td {
		text-align: center;
		vertical-align: middle;
	}
	.container .table td:nth-child(2) {
		text-align: left;
	}
	
	td .glyphicon {
		font-size: 12px;
		display: flex;
		padding: 3px;
	}
	
	td:nth-child(2) {
		cursor: pointer;
	}
	
	td:nth-child(2):hover {
		background-color: #EEE;
	}
	
	td small {
		font-size: 10px;
		color: #AAA;
	}
	
	.btns {
		display: flex;
		justify-content: space-between;
	}
	
	.complete {
		text-decoration: line-through;
		opacity: .7;
	}
	
	ol {
	    counter-reset: section;
	    list-style-type: none;
	}
	
	li:before {
	    counter-increment: section;
	    content: counters(section, ".") ".";
	}
	
	#descicon span {
		margin-top: 50px;	
		font-size: 1.5em;
		opacity: .3;
		cursor: pointer;
	}
	
	#desc {
		margin-top: 20px;
		display: none;
	}
	
	#sel1 {
		width: 100px;
		margin-left: auto;
		margin-right: 0px;
		margin-bottom: 10px;
	}
	
</style>

</head>
<body>
	<!-- todo_list.jsp -->
	<div class="container">
		<h1 class="page-header">Todo List <small>List</small></h1>		
		
		<table class="table table-bordered">
			<tr>
				<th><input type="checkbox" name="cbAll" id="cbAll"></th>
				<th>Todo</th>
				<th></th>
			</tr>
			
			<% 
			while (rs.next()) {
			
			%>
			
			<tr>
				<td><input type="checkbox" name="cbItem" class="cbItem"></td>
				<td><span><%= rs.getString("todo") %></span> <small><%= rs.getString("regdate") %></small></td>
				<td><button type="button" class="btn btn-success btn-xs" data-toggle="tooltip" title="????????? ???????????????." onclick="edit();"><span class="glyphicon glyphicon-edit"></span></button></td>
			</tr>
			
			<%
			}
			%>
			
		</table>
		<div class="btns">
			<input type="button" value="????????????" class="btn btn-danger" data-toggle="tooltip" title="????????? ????????? ???????????????." onclick="del();">
			<button type="button" class="btn btn-primary" data-toggle="tooltip" title="????????? ???????????????." onclick="add();">????????????</button>
		</div>
		
		
		<div id="descicon"><span class="glyphicon glyphicon-list" data-toggle="tooltip" title="?????? ???????????????."></span></div>
		
		<div id="desc">	
			<h3>????????? ???</h3>
			<ol>
				<li>?????? ?????? ??????</li>
				<li>?????? ??????</li>
				<li>?????? ??????</li>
				<li>?????? ??????
					<ol>
						<li>????????????: ?????? ?????? ??????/??????</li>
						<li>???????????? ????????????</li>
					</ol>
				</li>
				<li>?????? ??????
					<ol>
						<li>?????? ??????(??????/?????????)</li>
					</ol>
				</li>
			</ol>			
		</div>
	</div>	
	
	<script>
	  
		$('[data-toggle="tooltip"]').tooltip();	
		
		$("#descicon span").click(function() {
			$("#desc").toggle();
		});
	
	  	function add() {
	  		location.href = 'todo_add.jsp';
	  	}
	  	
	  	function edit() {
	  		location.href = 'todo_edit.jsp';
	  	}
	  	
	  	function del() {
	  		if (confirm('????????? ????????? ??????????????????????')) {
	  			
	  		}
	  	}
		
	</script>
</body>
</html>















