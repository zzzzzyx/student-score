package com.zzzzzyx.ejb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zzzzzyx.ejb.dao.StudentDao;
import com.zzzzzyx.ejb.model.Student;
@Stateless
@LocalBean
public class StudentDaoImpl implements StudentDao{

	
	DataSource ds;
	
	private static StudentDaoImpl simpleton = new StudentDaoImpl();

	private StudentDaoImpl(){
		
		try {
			Context ctx = new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/venezia");
		} catch (NamingException e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}
		
	}
	
	public static StudentDaoImpl getInStance() {
		return simpleton;
	}

	public Student findByName(String name) {
		Student student = null;
		Connection connection;
		try {
			connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery
					("select * from student where username = '" + name + "'");
			if(rs.next()){
				student = new Student(
						rs.getInt("id"),
						rs.getString("username"), 
						rs.getString("password"));
			}else{
				student = null;
			}
			
		} catch (SQLException e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}
		return student;
	}
	
	
	
	
}
