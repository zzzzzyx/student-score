package com.zzzzzyx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzzzzyx.ejb.model.LoginCountBean;
import com.zzzzzyx.ejb.model.Score;
import com.zzzzzyx.ejb.model.ScoreListBean;
import com.zzzzzyx.ejb.service.LoginCountService;
import com.zzzzzyx.ejb.service.ScoreService;

public class ScoreServlet extends HttpServlet {

	/**
	 * 获得新闻的servlet
//	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	ScoreService scoreService;
	@EJB
	LoginCountService lService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		ArrayList<Score> scoreList = scoreService.findScoreByID(userid);
		String unfinished = scoreService.getUnfinished(scoreList);

		if (!unfinished.equals("")) {
			session.setAttribute("unfinished", unfinished.substring(0, unfinished.length() - 2));
			response.sendRedirect("unfinished");
		}else{
		
			LoginCountBean loginCount = lService.getLoginCountBean();
			ScoreListBean scoreBean = new ScoreListBean(scoreList);
			request.setAttribute("loginCount", loginCount);
			request.setAttribute("scoreList", scoreBean);
			
			request.getRequestDispatcher("score.jsp").forward(request, response);
		}

	}

}
