package com.zzzzzyx.ejb.service.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zzzzzyx.ejb.dao.StudentDao;
import com.zzzzzyx.ejb.model.Student;
import com.zzzzzyx.ejb.service.LoginResult;
import com.zzzzzyx.ejb.service.StudentService;

@Stateless
@LocalBean
public class StudentServiceImpl implements StudentService{

	@EJB
	StudentDao studentDao;
	
	private static StudentService simpleton = new StudentServiceImpl();
	
	public static StudentService getInStance() {
		return simpleton;
	}

	public LoginResult verify(String username, String password, HttpServletRequest req) {
		
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
