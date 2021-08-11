package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 이 Add라는 서블릿은 할일이 없다. -> jsp만 부르는 행동을 함 / 스스로 할일은 X
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/address/add.jsp");
		dispatcher.forward(req, resp);
	}

}
