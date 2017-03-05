package com.zzzzzyx.ejb.service;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentService {

	LoginResult verify(String username, String password, HttpServletRequest req);

}
