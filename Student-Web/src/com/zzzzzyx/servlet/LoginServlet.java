package com.zzzzzyx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzzzzyx.ejb.service.LoginResult;
import com.zzzzzyx.ejb.service.StudentService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 登陆验证servlet
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	StudentService studentService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(true);
		session.removeAttribute("login");

		req.getRequestDispatcher("index.jsp").forward(req, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginResult isValidate = studentService.verify(username,password,req);

		if (isValidate == LoginResult.Login) {
			// find such user
			response.sendRedirect("score");
		} else if (isValidate == LoginResult.PswIncorrect) {
			out.println("Password incorrect.");
		}else{
			out.println("Do not exist such a student.");
		}


	}

}
