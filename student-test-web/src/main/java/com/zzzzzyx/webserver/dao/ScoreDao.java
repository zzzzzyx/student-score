package com.zzzzzyx.webserver.dao;

import java.util.ArrayList;

import com.zzzzzyx.webserver.model.Score;

public interface ScoreDao {

	public ArrayList<Score> findScoreByID(String userid);
}
