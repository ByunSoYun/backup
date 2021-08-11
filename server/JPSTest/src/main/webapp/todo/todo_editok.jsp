<%@page import="com.test.jsp.jdbc.DBUtil"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%


//이 페이지가 할 일!!
//1. 데이터 가져오기
//2. DB -> update 실행
//3. 페이지 이동하기 -> list.jsp


request.setCharacterEncoding("UTF-8");

String seq = request.getParameter("seq");
String todo = request.getParameter("todo");
String regdate = request.getParameter("regdate");

Connection conn = null;
Statement stat = null;
int result = -1;

try{
	
	conn = DBUtil.open();
	stat = conn.createStatement();
	
	String sql = String.format("update tblTodo set todo = '%s', regdate= to_char(sysdate, 'yyyy-mm-dd') where seq = %s ",todo,seq);


	result = stat.executeUpdate(sql); //1(성공), 0(실패)	

	
	
	
	stat.close();
	conn.close();

}catch(Exception e){
	System.out.println(e);
}



 if (result == 1) {
	response.sendRedirect("/jsp/todo/todo_list.jsp");
} else {
	response.sendRedirect("/jsp/todo/todo_edit.jsp");
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
	<!-- todo_editok.jsp -->
	<div class="container">
		<h1 class="page-header"></h1>		
		
	</div>	
	
	<script>


	</script>
</body>
</html>















