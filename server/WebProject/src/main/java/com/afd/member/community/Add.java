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
 * 게시글을 추가하기 위해 add.jsp를 불러오는 클래스
 *       
 *       */
@WebServlet("/main/member/community/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/add.jsp");
		dispatcher.forward(req, resp);

	}

}
