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
<body><br><br><br><br>
	<center>
	<h1>Admin</h1><br>
	<a href = "/inventory/seeProducts">Products</a> ||
	<a href= "/inventory/addNewProduct">Add new product</a> ||
	<a href= "/inventory/seeStock">Stock</a> ||
	<a href = "/inventory/SoldProduct">Sold Product</a> ||
	<a href= "/inventory/Logout">Logout</a><br><br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>POSITION</th>
			<th>PHONE</th>
		</tr>
		<c:forEach var="emp" items="${emplist}">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.empSalary}</td>
			<td>${emp.empPosition}</td>
			<td>${emp.empPhone}</td>
		</tr>
		</c:forEach>
	</table>
	<center/>
</body>
</html>