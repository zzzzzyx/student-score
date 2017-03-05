package com.zzzzzyx.ejb.model;

public class Score {

	private String courseName;
	
	private int score;
	
	public Score() {
		// TODO 自动生成的构造函数存�?
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Score(String courseName, int score) {
		super();
		this.courseName = courseName;
		this.score = score;
	}
	
	
}
