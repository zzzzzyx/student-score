package com.zzzzzyx.ejb.dao;

import javax.ejb.Local;

import com.zzzzzyx.ejb.model.Student;
@Local
public interface StudentDao{

	public Student findByName(String name);
}
