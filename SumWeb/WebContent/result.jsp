<%@ pagelanguage="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE htmlPUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Insert titlehere</title>
</head>
<body>
<jsp:useBean id="number"
type="com.zzzzzyx.servlet.Number"
scope="request" />
 
<jsp:getProperty name="number" property="param1"/><br>
<jsp:getProperty name="number" property="param2"/><br>
<jsp:getProperty name="number" property="result"/><br>
</body>
</html>