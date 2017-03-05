package com.zzzzzyx.ejb.dao;

import java.util.ArrayList;

import javax.ejb.Local;

import com.zzzzzyx.ejb.model.Score;
@Local
public interface ScoreDao {

	public ArrayList<Score> findScoreByID(String userid);
}
