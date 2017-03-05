package com.zzzzzyx.ejb.service.impl;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.zzzzzyx.ejb.dao.ScoreDao;
import com.zzzzzyx.ejb.model.Score;
import com.zzzzzyx.ejb.service.ScoreService;

@Stateless
@LocalBean
public class ScoreServiceImpl implements ScoreService{
	
	@EJB
	ScoreDao scoreDao;

	private static ScoreServiceImpl simpleton = new ScoreServiceImpl();
	
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
		
		ArrayList<Score> scoreList = scoreDao.findScoreByID(userid);
		return scoreList;
	}
	
	

}
