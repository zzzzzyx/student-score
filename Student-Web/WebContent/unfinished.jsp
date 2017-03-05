<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- for HTML5 -->
<title>学生成绩查看系统</title>
</head>
<body bgcolor="#f0f0f0">
	<p align="center">
		You have unfinished courses: <%=session.getAttribute("unfinished") %>  
	</p>
	<form align="center" method="GET" action="logout">
	<input type="submit" value="logout"/> </form>
	</body>
</html>