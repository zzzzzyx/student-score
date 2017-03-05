package com.zzzzzyx.webserver.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zzzzzyx.webserver.dao.ScoreDao;
import com.zzzzzyx.webserver.model.Score;

public class ScoreDaoImpl implements ScoreDao{

	DataSource ds;
	
	private static ScoreDaoImpl simpleton = new ScoreDaoImpl();

	private ScoreDaoImpl(){
		
		try {
			Context ctx = new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/venezia");
		} catch (NamingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public static ScoreDaoImpl getInStance() {
		return simpleton;
	}
	
	public ArrayList<Score> findScoreByID(String userid) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		
		try {
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery
					("select * from score where student_id = '" + userid + "'");
			
			while(rs.next()){				
				Score score = new Score(rs.getString("course_name"), rs.getInt("score"));
				scoreList.add(score);					
			}

			connection.close();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return scoreList;
	}

}
