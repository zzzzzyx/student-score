package com.zzzzzyx.webserver.dao;

import com.zzzzzyx.webserver.model.Student;

public interface StudentDao{

	public Student findByName(String name);
}
