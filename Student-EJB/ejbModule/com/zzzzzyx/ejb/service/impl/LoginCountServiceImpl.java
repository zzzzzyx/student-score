package com.zzzzzyx.ejb.service.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.zzzzzyx.ejb.listener.SessionTracker;
import com.zzzzzyx.ejb.model.LoginCountBean;
import com.zzzzzyx.ejb.service.LoginCountService;

@Stateless
@LocalBean
public class LoginCountServiceImpl implements LoginCountService{

	private static LoginCountServiceImpl simpleton = new LoginCountServiceImpl();
	
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
