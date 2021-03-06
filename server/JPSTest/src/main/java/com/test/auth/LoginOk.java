package com.test.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/loginok.do")
public class LoginOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//LoginOk.java
		
		//request.getParameter() -> 한글깨짐
		// 1. GET 전송 -> UTF-8 전송 -> 한글 안깨짐
		// 2. POST 전송 -> ISO 8859-1 전송 -> 한글 깨짐
		// 결론: POST 넘길 때만 인코딩 처리를 한다.
		
		//할일
		//1. 데이터 가져오기(id,pw)
		//2. DB 작업 -> 회원 확인?
		//3. 결과
		//	3.1 일치 -> 인증티켓 발금
		//	3.2 일치 -> 경고
		
		//1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2. DB작업을 서블릿이 직접하지 않고 다른 클래스(객체)에게 위임한다.(**********)
		AuthDAO dao = new AuthDAO();
		
		//**객체와 객체간의 호출 시 -> 인자값 1개면 그냥 전달, 인자값 2개 이상이면 무조건 포장해서 전달한다.
		AuthDTO dto = new AuthDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		
		/*
		int result = dao.login(dto); //1(로그인성공), 0(로그인 실패)
		
		//****** 중요한 작업 -> 인증 티켓 발급!!
		if (result == 1) {
			
			//JSP의 session 객체와 같음
			HttpSession session = req.getSession();
			
			
			//**이 값을 사이트 전테를 다 통틀어 반드시 이 곳 딱 1군데에서만 값을 할당할 수 있다.
			session.setAttribute("id", id); //인증 티겟! -> 로그인!
		}
		*/
		
		
		AuthDTO resultDTO = dao.login2(dto);
		
		if (resultDTO != null) {
			
			//로그인 성공O -> 인증티켓 발급
			
			HttpSession session = req.getSession();
			
			session.setAttribute("id", resultDTO.getId());
			
			//인증 티켓 발급과 동시에 이 사람의 부가 정보를 같이 session에 담아두낟.
			session.setAttribute("name", resultDTO.getName());
			session.setAttribute("lv", resultDTO.getLv());
			session.setAttribute("regdate", resultDTO.getRegdate());
		
		}

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/auth/loginok.jsp");
		dispatcher.forward(req, resp);
	}

}