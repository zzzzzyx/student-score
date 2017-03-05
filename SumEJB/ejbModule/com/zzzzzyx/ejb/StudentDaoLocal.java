package com.zzzzzyx.ejb;

import javax.ejb.Local;

@Local
public interface StudentDaoLocal{

	public Student findByName(String name);
}
