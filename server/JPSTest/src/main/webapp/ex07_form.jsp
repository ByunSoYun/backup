<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<style>
	input[type=number]{
		width : 120px;
		heigt : 34px ;
		text-align: right;
	
	}
	th{
		width: 120px;
		height: 50px;
		text-align: center;
	
	
	}
	
	
	.btns { margin: 20px 0; }
	.table{ width: 600px; }
	
	input[type=text]{
		width: 250px;
		height: 34px;
		
	}
	
	input[type=color]{
		width: 60px;
		height: 34px;
		
	}
	
	
	
</style>

</head>
<body>
	<!--  -->
	<div class="container">
		<h1 class="page-header">버튼 만들기</h1>
		

			<form method="GET" action="ex07_ok.jsp">
			<table class="table table-bordered">
			<tr>
				<th>너비(px)</th>
				<td><input type = "number" name = "width" min ="20" max = "300" value = "60" step ="10" class = "form-control "></td>
				
			</tr>
			<tr>
				<th>높이(px)</th>
				<td><input type = "number" name = "height" min ="10" max = "200" value = "30" step ="10" class = "form-control "></td>
			</tr>
			<tr>
				<th>텍스트</th>
				<td><input type = "text" name = "txt1"  value = "Button" class = "form-control" ></td>
			</tr>
			<tr>
				<th>배경색</th>
				<td><input type = "color" name = "backgroundcolor"  value = "#FFFFFF" class = "form-control" ></td>
			</tr>
			<tr>
				<th>글자색</th>
				<td><input type = "color" name = "fontcolor"  value = "#000000" class = "form-control" ></td>
			</tr>
			<tr>
				<th>글자 크기(px)</th>
				<td><input type = "number" name = "size"  value = "16" max = "100" min = "10" class = "form-control " ></td>
			</tr>
			<tr>
				<th>버튼 개수(ea)</th>
				<td><input type = "number" name = "btnnumber"  value = "1" max = "30" min = "1" class = "form-control " ></td>
			</tr>
			<tr>
				<th>버튼 간격()>
				<td>
					<div>좌우 간격 : <input type="range" min="0" max="50" value="0" name="leftright"></div>
					<div>상하 간격 : <input type="range" min="0" max="50" value="0" name="topbottom"></div>
				</td>
			</tr>
	
		</table>
		
		
		<div class="btns">
			<input type="submit" value="만들기" class="btn btn-success">
		</div>
		
	</div>


	<script>
	
	
	
	</script>	
</body>
</html>