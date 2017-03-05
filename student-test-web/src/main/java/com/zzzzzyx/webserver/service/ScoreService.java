package com.zzzzzyx.webserver.service;

import java.util.ArrayList;

import com.zzzzzyx.webserver.model.Score;

public interface ScoreService {

	public String getUnfinished(ArrayList<Score> scoreList);
	
	public ArrayList<Score> findScoreByID(String userid) ;
}
