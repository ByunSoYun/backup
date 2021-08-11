package com.test.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/admin.do")
public class Admin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 인증받지 못한 사용자를 쫓아내기!!
				HttpSession session = req.getSession();
				
				if(session.getAttribute("id") == null){
					// 로그인 안한사람
					
					resp.sendRedirect("/jsp/auth/login.do");
					
					return; // 끝나버리고 밑에꺼 안하고 끝남 break 같은것 
					
					
				}
				
				
				//관리자 아닌 인증 사용자를 쫓아내기!!
				
				if(!session.getAttribute("lv").toString().equals("3")) {
					//일반 회원!!
					resp.sendRedirect("/jsp/auth/index.do");
					return;
				}
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/auth/admin.jsp");
		dispatcher.forward(req, resp);

	}

}

