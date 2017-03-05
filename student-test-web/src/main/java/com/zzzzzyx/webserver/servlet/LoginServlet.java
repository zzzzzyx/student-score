package com.zzzzzyx.webserver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzzzzyx.webserver.factory.ServiceFactory;
import com.zzzzzyx.webserver.model.LoginCountBean;
import com.zzzzzyx.webserver.service.LoginCountService;
import com.zzzzzyx.webserver.service.LoginResult;
import com.zzzzzyx.webserver.service.StudentService;


public class LoginServlet extends HttpServlet {

	/**
	 * 登陆验证servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(true);
		session.removeAttribute("login");
		
		ServiceFactory sFactory= new ServiceFactory(); 
		LoginCountService lService = sFactory.getLoginCountService();
		LoginCountBean loginCount = lService.getLoginCountBean();
		req.setAttribute("loginCount", loginCount);

		req.getRequestDispatcher("index.jsp").forward(req, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServiceFactory sFactory= new ServiceFactory(); 
		StudentService studentService = sFactory.getStudentService();
		
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
