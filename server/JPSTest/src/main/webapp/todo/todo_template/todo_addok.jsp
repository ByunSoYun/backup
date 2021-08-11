<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.jdbc.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//할일
	//1. 데이터 가져오기(request.getParameter())
	//2. DB 작업 -> insert
	//3. 페이지 이동하기 -> todo_list.jsp
	
	
		
	request.setCharacterEncoding("UTF-8");
	
	String todo = request.getParameter("todo");
	
	Connection conn = null;
	PreparedStatement pstat = null;
	int result = -1;
	
	try{
		
		conn = DBUtil.open();
		
		String sql = "insert into tblTodo (seq,todo,complete,regdate) values (seqTodo.Nextval ,? , '0'  , to_char(sysdate, 'yyyy-mm-dd'))";
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, todo);
		
		result = pstat.executeUpdate();
		

		pstat.close();
		conn.close();
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	if(result == 1){
		response.sendRedirect("todo_list.jsp");
		} else {
		response.sendRedirect("todo_add.jsp");
		}
		
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
	<!-- todo_addok.jsp -->
	
</body>
</html>















