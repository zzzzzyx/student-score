package com.zzzzzyx.webserver.service.impl;

import com.zzzzzyx.webserver.listener.SessionTracker;
import com.zzzzzyx.webserver.model.LoginCountBean;
import com.zzzzzyx.webserver.service.LoginCountService;

public class LoginCountServiceImpl implements LoginCountService{

	private static LoginCountServiceImpl simpleton = new LoginCountServiceImpl();

	private LoginCountServiceImpl(){}
	
	public static LoginCountServiceImpl getInStance() {
		return simpleton;
	}
	
	public LoginCountBean getLoginCountBean() {
		LoginCountBean loginCount = new LoginCountBean(SessionTracker.getSessionCount()
				,SessionTracker.getSessionCount() - SessionTracker.getLoginCount()
				,SessionTracker.getLoginCount());
		return loginCount;
	}

}
