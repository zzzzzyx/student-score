package com.zzzzzyx.webserver.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzzzzyx.webserver.dao.StudentDao;
import com.zzzzzyx.webserver.factory.DaoFactory;
import com.zzzzzyx.webserver.model.Student;
import com.zzzzzyx.webserver.service.LoginResult;
import com.zzzzzyx.webserver.service.StudentService;

public class StudentServiceImpl implements StudentService{

	
	private static StudentService simpleton = new StudentServiceImpl();

	private StudentServiceImpl(){}
	
	public static StudentService getInStance() {
		return simpleton;
	}

	public LoginResult verify(String username, String password, HttpServletRequest req) {
		
		DaoFactory dFactory = new DaoFactory();
		StudentDao studentDao = dFactory.getStudentDao();
		Student student = studentDao.findByName(username);
		if(student == null){
			return LoginResult.NotExist;
		}else if(!student.getPassword().equals(password)){//password not true
			return LoginResult.PswIncorrect;
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("username",username);
		session.setAttribute("login",true);
		session.setAttribute("userid",Integer.toString(student.getId()));
		return LoginResult.Login;
	}
}
