<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="error" class = "models.Employee" scope="request"></jsp:useBean>
	<center><br><br><br>
	<jsp:getProperty property = "msg" name = "error"></jsp:getProperty><br><br>
	<h1>Login View</h1><br>
	<form method = "POST">
		User name: <input type = "text" name = "username"><br><br>
		Password: <input type = "password" name = "pwd"><br><br>
		<input type = "submit" name = "submit" value = "Login">
	</form>
	</center>
</body>
</html>