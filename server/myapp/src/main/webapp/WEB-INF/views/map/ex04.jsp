<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp" %>

<style>
	
</style>

</head>
<body>
	<!-- template.jsp > ex01.jsp > ex04.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>Map API <small>즐겨찾기</small></h1>
		
		<div id="map" style="width: 100%; height: 400px;"></div>
		
		<hr>
		
		<table class="table table-bordered">
			<tr>
				<th style="width: 300px;">이름</th>
				<th>위치</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="#!" onclick="info(${dto.lat}, ${dto.lng});">${dto.name}</a></td>
				<td>위도(${dto.lat}) 경도(${dto.lng})</td>
			</tr>
			</c:forEach>
		</table>
		
		<hr>
		
		<input type="button" class="btn btn-default" value="추가하기" 
			onclick="location.href='/myapp/map/add.do';">
		
	</section>	
	
	
	<%@ include file="/inc/init.jsp" %>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c568aa74b3a9671ee3805242fef479b3"></script>
	<script>
	
		var container = document.getElementById('map'); //지도 태그 선택
		
		var options = {
			center: new daum.maps.LatLng(37.499331, 127.033181), //지도의 중앙 좌표
			level: 3 //지도의 레벨(확대,축소)
		};
		
		var map = new daum.maps.Map(container, options); //지도 생성(***)
		
		//----------------------------------------------------------------------
		
		 
		
		//목록 보기 페이지
		//마커 출력하기
		let list = [
			<c:forEach items="${list}" var="dto">
			{
				name: '${dto.name}',
				lat: ${dto.lat},
				lng: ${dto.lng}
			},
			</c:forEach>
		];
		
		
		<c:forEach items="${list}" var="dto">
		
		var m = new daum.maps.Marker({
			position: new daum.maps.LatLng(${dto.lat}, ${dto.lng})
		});
		
		m.setMap(map);
		
		
		//#d95050
		//#d95050
		
		//var content = '${dto.name}';
		var content =  ''
					 + '${dto.name}'
					 + '';
		var pos = new daum.maps.LatLng(${dto.lat}, ${dto.lng});
		
		var info = new daum.maps.InfoWindow({
			position: pos,
			content: content
		});
		
		info.open(map, m);
			
		
		
		</c:forEach>
		
		
		
		
		var m;
		
		function info(lat, lng) {
			
			if (m != null) {
				m.setMap(null);
			}
			
			m = new daum.maps.Marker({
				position: new daum.maps.LatLng(lat, lng)
			});
			
			m.setMap(map);

			//마커의 위치가 맵의 중앙이 되게 이동
			//map.setCenter(new daum.maps.LatLng(lat, lng));
			map.panTo(new daum.maps.LatLng(lat, lng));
		}
		
		$('.infoback').parent().parent().css({
			'background-color': 'transparent',
			'border': '0px',
			'z-index': '100',
			'left': '10px'
		});
		
	
	</script>
</body>
</html>	















