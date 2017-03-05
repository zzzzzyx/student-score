package com.zzzzzyx.ejb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zzzzzyx.ejb.dao.ScoreDao;
import com.zzzzzyx.ejb.model.Score;
@Stateless
@LocalBean
public class ScoreDaoImpl implements ScoreDao{

	DataSource ds;
	
	private static ScoreDaoImpl simpleton = new ScoreDaoImpl();

	private ScoreDaoImpl(){
		
		try {
			Context ctx = new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/venezia");
		} catch (NamingException e) {
			// TODO 自动生成�? catch �?
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
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}
		return scoreList;
	}

}
