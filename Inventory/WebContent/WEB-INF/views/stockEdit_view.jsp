<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br>
	<center>
	<h1>Add Stock</h1><br>
	<jsp:useBean id="s" class = "models.Stock" scope="request"></jsp:useBean>
	<jsp:getProperty property = "msg" name = "s"/><br><br>
	<form method = "post">
		Enter Amount : <input type = "text" name = "amount"/><br /><br>
				   <input type = "submit" name = "submit" value ="Submit"><br><br>
				   <a href="/inventory/ProductWithStock">Back</a>
	</form>
	</center>
</body>
</html>