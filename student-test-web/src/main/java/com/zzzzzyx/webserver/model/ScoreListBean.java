package com.zzzzzyx.webserver.model;

import java.util.ArrayList;

public class ScoreListBean {

	private ArrayList<Score> scoreList;

	public ScoreListBean(ArrayList<Score> scoreList) {
		super();
		this.scoreList = scoreList;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
}
