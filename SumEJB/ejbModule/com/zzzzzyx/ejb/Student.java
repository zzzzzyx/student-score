package com.zzzzzyx.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1112236857634673420L;
	
	@Id
	private int id;
	private String username;
	private String password;
	
	public Student() {
		// TODO 自动生成的构造函数存根
	}
	
	public Student(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
