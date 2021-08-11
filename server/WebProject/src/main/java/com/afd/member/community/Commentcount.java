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
 * 가지고있는 데이터들의 댓글수의 값을 가져와주고 그 값을 list.jsp로 전달하고 불러오는 클래스 
 *       
 *       */


@WebServlet("/main/member/community/commentcount.do")
public class Commentcount extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/list.jsp");
		dispatcher.forward(req, resp);

	}

}
