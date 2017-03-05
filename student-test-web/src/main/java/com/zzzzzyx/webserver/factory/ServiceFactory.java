package com.zzzzzyx.webserver.factory;

import com.zzzzzyx.webserver.service.LoginCountService;
import com.zzzzzyx.webserver.service.ScoreService;
import com.zzzzzyx.webserver.service.StudentService;
import com.zzzzzyx.webserver.service.impl.LoginCountServiceImpl;
import com.zzzzzyx.webserver.service.impl.ScoreServiceImpl;
import com.zzzzzyx.webserver.service.impl.StudentServiceImpl;

public class ServiceFactory {
	StudentService studentDao = StudentServiceImpl.getInStance();

	public StudentService getStudentService() {
		return studentDao;
	}
	
	ScoreService scoreService = ScoreServiceImpl.getInStance();

	public ScoreService getScoreService() {
		return scoreService;
	}
	
	LoginCountService loginCountService = LoginCountServiceImpl.getInStance();

	public LoginCountService getLoginCountService() {
		return loginCountService;
	}
}
