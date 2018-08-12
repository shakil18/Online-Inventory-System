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
	<h1>Saler</h1><br>
	<a href= "/inventory/Logout">Logout</a><br><br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PRICE</th>
			<th>STOCK</th>
			<th colspan="2">OPTION</th>
		</tr>
		<c:forEach var="pro" items="${prolist}">
		<tr>
			<td>${pro.productId}</td>
			<td>${pro.productName}</td>
			<td>${pro.productPrice}</td>
			<td>${pro.productQuantity}</td>
			<td><a href="/inventory/SaleProduct?id=${pro.productId}">Sell</a></td>
		</tr>
		</c:forEach>
	</table>
	<center/>
</body>
</html>