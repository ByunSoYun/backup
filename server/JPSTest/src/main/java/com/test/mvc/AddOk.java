package com.test.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.jdbc.DBUtil;

public class AddOk extends HttpServlet{
	
	
	// POST -> doPost()
	// GET -> doGet()
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//할일 
		//1. Post - > 인코딩 처리 
		//2. 데이터 가져오기
		//3. DB 작업 -> insert 
		//4. JSP 호출하기 + 결과 출력 
		
		
		
		//1. 
		req.setCharacterEncoding("UTF-8");
		
		//2. 
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		
		//3. 
		Connection conn = null;
		PreparedStatement stat = null;
		int result = -1; // result 변수가 절대로 가질수 없는 값
		
		try {
			String sql = "insert into tbladdress (seq, name, age, gender, address) "
					+ " values (seqAddress.nextVal, ?, ?, ?, ?)";
			
			conn = DBUtil.open();
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, name);
			stat.setString(2, age);
			stat.setString(3, gender);
			stat.setString(4, address);
			stat.setString(4, address);
			
					
			result = stat.executeUpdate(); // 성공(1) 실패(0) 다른 경우의 수 존재x / 성공적으로 실행되면 행 1개가 업데이터 됨(실행되는 행의갯수) 
	
			
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		//** 출력할 내용이 거의 없는 경우엔 
		// JSP와 짝을 맺지 않고, Servlet 혼자 일을 마무리하는 경우도 종종 있다.
		
		/*
		 * if(result == 1) { resp.sendRedirect("/jsp/list.do"); } else {
		 * //resp.sendRedirect("/jsp/add.do"); PrintWriter writer = resp.getWriter();
		 * writer.print("<script>"); writer.print("history.back();");
		 * writer.print("</script>"); writer.close(); }
		 */
		
		//4. 결과값을 받아서 JSP 에 넘겨주기 !
		req.setAttribute("result", result);
		System.out.println(result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/address/addok.jsp");
		dispatcher.forward(req, resp);
	}

}

