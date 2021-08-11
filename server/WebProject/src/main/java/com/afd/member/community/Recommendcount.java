package com.afd.member.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  
 *@author 3조
 * 
 *  list.jsp를 불러내는 클래스 

 *       
 *       */
@WebServlet("/main/member/community/recommendcount.do")
public class Recommendcount extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/list.jsp");
		dispatcher.forward(req, resp);

	}

}
