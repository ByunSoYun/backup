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
 * 필요한 데이터들을 받고 edit.jsp를 불러내는 클래스
 *       
 *       */



@WebServlet("/main/member/community/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//할일
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select where seq
		//3. BoardDTO 반환 > JSP 호출하기 + 전달하기
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		
		CommunityDTO commentlist = dao.get(seq);
		
		//3.
		req.setAttribute("dto", commentlist);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/member/community/edit.jsp");
		dispatcher.forward(req, resp);

	}

}
