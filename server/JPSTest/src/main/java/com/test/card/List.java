package com.test.card;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/card/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		//할일 
		//1. DB 작업 > 위임 > select 
		//2. 결과 반환 > 출력 > JSP 호출하기 
		
		//1. 
		CardDAO dao = new CardDAO();
		/*
		 * ResultSet rs= dao.list();  -> 사람이 관리하기 힘듬 (담당자 아닌 사람한테 하라는것)
		 */
		//ResultSet <-> ArrayList<CardDTO>
		//ResultSet : 테이블
		//ArrayList<CardDTO> : 2차원 배열 -> 테이블
		// ArrayList<HashMap>
		
		ArrayList<CardDTO> list = dao.list();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/card/list.jsp");
		dispatcher.forward(req, resp);

	}

}
