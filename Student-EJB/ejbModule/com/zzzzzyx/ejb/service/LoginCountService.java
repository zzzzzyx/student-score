package com.zzzzzyx.ejb.service;

import javax.ejb.Local;

import com.zzzzzyx.ejb.model.LoginCountBean;

@Local
public interface LoginCountService {

	public LoginCountBean getLoginCountBean();
}
