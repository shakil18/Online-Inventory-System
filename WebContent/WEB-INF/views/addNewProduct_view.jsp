<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><br><br>
	<h1> Add Product</h1>
	<jsp:useBean id="inputs" class = "models.Product" scope="request"></jsp:useBean>
	<jsp:getProperty property = "msg" name = "inputs"/><br><br>
	<form method = "post">
		Product Name: <input type = "text" name = "productName" value = "<jsp:getProperty property = "productName" name = "inputs"/>"><br /><br>
		Product Price: <input type = "text" name = "productPrice" value = "<jsp:getProperty property = "productPrice" name = "inputs"/>"><br /><br>
		categories: <select name = "cate">
					 <c:forEach  var="s" items="${catlist}">
					  	<option>
					  		${s.categoryName}
					  	</option>
					 </c:forEach>
				   </select><br><br>
				   <input type = "submit" name = "submit" value ="Add"><br><br>
	</form>
	<a href = "/inventory/EmployeeList">Back</a>
	<center/>
</body>
</html>