package com.zzzzzyx.webserver.factory;

import com.zzzzzyx.webserver.dao.ScoreDao;
import com.zzzzzyx.webserver.dao.StudentDao;
import com.zzzzzyx.webserver.dao.impl.ScoreDaoImpl;
import com.zzzzzyx.webserver.dao.impl.StudentDaoImpl;

public class DaoFactory {
	
	StudentDao studentDao = StudentDaoImpl.getInStance();
	ScoreDao scoreDao = ScoreDaoImpl.getInStance();

	public StudentDao getStudentDao() {
		return studentDao;
	}
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}
}
