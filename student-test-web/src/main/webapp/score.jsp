<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="scoreList"
	type="com.zzzzzyx.webserver.model.ScoreListBean" scope="request"></jsp:useBean>
<jsp:useBean id="loginCount"
	type="com.zzzzzyx.webserver.model.LoginCountBean" scope="request"></jsp:useBean>
<jsp:useBean id="singleScore" class="com.zzzzzyx.webserver.model.Score"
	scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for HTML5 -->
<title>学生成绩查看系统</title>
</head>
<body bgcolor="#f0f0f0">
	<h1 align="center">
		你好,
		<%=session.getAttribute("username") %>
		.
	</h1>
	<h2 align="center">Score Information</h2>
	<table border="1" align="center">
		<tr bgcolor="#949494">
			<th>course name</th>
			<th>score</th>
		</tr>

		<% for(int i = 0 ; i < scoreList.getScoreList().size() ; i ++){
		        	pageContext.setAttribute("singleScore", scoreList.getScoreList().get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleScore" property="courseName" /></td>
			<td><jsp:getProperty name="singleScore" property="score" /></td>
		</tr>
		<% } %>
	</table>
	<form align="center" method="GET" action="logout">
		<input type="submit" value="logout" />
	</form>

	<p>
		在线人数：<jsp:getProperty name="loginCount" property="totalPeopleNum" /></p>
	<p>
		总登录人数：<jsp:getProperty name="loginCount" property="loginNum" /></p>
	<p>
		游客人数：<jsp:getProperty name="loginCount" property="travellerNum" /></p>
</body>
</html>