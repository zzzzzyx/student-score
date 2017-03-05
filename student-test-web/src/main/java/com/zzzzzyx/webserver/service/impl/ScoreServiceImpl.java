package com.zzzzzyx.webserver.service.impl;

import java.util.ArrayList;

import com.zzzzzyx.webserver.dao.ScoreDao;
import com.zzzzzyx.webserver.factory.DaoFactory;
import com.zzzzzyx.webserver.model.Score;
import com.zzzzzyx.webserver.service.ScoreService;

public class ScoreServiceImpl implements ScoreService{

	private static ScoreServiceImpl simpleton = new ScoreServiceImpl();

	private ScoreServiceImpl(){}
	
	public static ScoreServiceImpl getInStance() {
		return simpleton;
	}
	
	public String getUnfinished(ArrayList<Score> scoreList) {
		String unfinished = "";

		for (Score score : scoreList) {
			if (score.getScore() < 0) {
				unfinished += score.getCourseName() + ", ";
			}
		}
		return unfinished;
	}

	public ArrayList<Score> findScoreByID(String userid) {
		DaoFactory daoFactory= new DaoFactory(); 
		ScoreDao scoreDao = daoFactory.getScoreDao(); 
		
		ArrayList<Score> scoreList = scoreDao.findScoreByID(userid);
		return scoreList;
	}
	
	

}
