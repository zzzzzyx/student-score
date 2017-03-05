package com.zzzzzyx.ejb.service;

import java.util.ArrayList;

import javax.ejb.Local;

import com.zzzzzyx.ejb.model.Score;

@Local
public interface ScoreService {

	public String getUnfinished(ArrayList<Score> scoreList);
	
	public ArrayList<Score> findScoreByID(String userid) ;
}
