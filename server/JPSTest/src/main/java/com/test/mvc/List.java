package com.test.mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.jdbc.DBUtil;

public class List extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//1.DB 작업 -> select 
		//2.  ResultSet
		//3. 호출하기 + ResultSet 
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		ArrayList<HashMap<String,String>>list = new ArrayList<HashMap<String,String>>();
		
		try {
			conn = DBUtil.open();
			stat= conn.createStatement();
			
			String sql = "select * from tblAddress order by seq";
			
			rs = stat.executeQuery(sql);
			
			//결과 테이블 -> 행+열 -> 2차원 배열 
		
			while (rs.next()){
				//레코드 1줄 -> HashMap 1개
				HashMap<String,String> map = new HashMap<String,String>();
				
				//*********
				map.put("seq", rs.getString("seq"));
				map.put("name", rs.getString("name"));
				map.put("age", rs.getString("age"));
				map.put("gender", rs.getString("gender"));
				map.put("address", rs.getString("address"));
				
				list.add(map);
			}
			
			// list ==rs
			// ResultSet의 모든 내용을 ArrayList<HashMap>에 복사를 했다!!!!!!!!!
			
			
			
			rs.close();
			stat.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//RsultSet을 직접 전달하지 않고, ArrayList에 담아서 전달하는 이유
		//1. MVC 디자인 패턴을 구현하기 위해서 (************************)
		//2. JSTL을 사용하기 위해서 
		//	- JSTL이 ArrayList는 forEach로 탐색이 가능하지만,
		// 	  ResultSet은 탐색할 수 없다.
		
		//JSP에 전달하기 위해서 ArrayList<Hashmap>을 담는다.(****) -> 화면에 출력하라고!!
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/address/list.jsp");
		dispatcher.forward(req, resp);
	}

}
