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
	<h1>Stock Manager</h1>
	<a href="/inventory/Logout">LOGOUT</a><br><br>
	<table border="1">
		<tr>
			<th>PRODUCT ID</th>
			<th>PRODUCT NAME</th>
			<th>QUANTITY</th>
			<th>OPTION</th>
		</tr>
		<c:forEach var="sto" items="${stolist}">
		<tr>
			<td>${sto.productId}</td>
			<td>${sto.productName}</td>
			<td>${sto.stockQuantity}</td>
			<td><a href="/inventory/StockEdit?id=${sto.productId}">Add Stock</a></td>
		</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>