<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="loginCount"
	type="com.zzzzzyx.webserver.model.LoginCountBean" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- for HTML5 -->
<title>学生成绩查看系统</title>
</head>
<body>
	<h1>
		学生成绩查看系统
		<h1 />
		<form method="POST" action="login">
			<span style="float: left;">用户名:</span> <input name="username"
				type="text" value="" /> <span>密码:</span> <input name="password"
				size="16" type="password" value="" /> <input type="submit" value="登录">
		</form>
		<p>
		在线人数：<jsp:getProperty name="loginCount" property="totalPeopleNum" /></p>
	<p>
		总登录人数：<jsp:getProperty name="loginCount" property="loginNum" /></p>
	<p>
		游客人数：<jsp:getProperty name="loginCount" property="travellerNum" /></p>
</body>
</html>