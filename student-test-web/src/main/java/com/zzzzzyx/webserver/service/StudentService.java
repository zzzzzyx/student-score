package com.zzzzzyx.webserver.service;

import javax.servlet.http.HttpServletRequest;

public interface StudentService {

	LoginResult verify(String username, String password, HttpServletRequest req);

}
