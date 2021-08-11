package com.test.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/index.do")
public class index extends HttpServlet {
	
	@Override //Annotation -프로그래밍 주석
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//		http://localhost:8090/jsp/auth/member.do
			
		
		
		
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/auth/index.jsp");
		dispatcher.forward(req, resp);
		System.out.println();
	}

}


