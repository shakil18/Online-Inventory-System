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
<body>
	<center><br><br><br>
	<h1>Product Information</h1>
	<a href = "/inventory/EmployeeList">Back</a><br><br>
	<jsp:useBean id="searchs" class = "models.Product" scope="request"></jsp:useBean>
	<form method ="post">
		Category: <select name = "cate">
					 <c:forEach  var="s" items="${catlist}">
					  	<option>
					  		${s.categoryName}
					  	</option>
					 </c:forEach>
				   </select>
		<input type = "submit" name ="submit" value = "Search"><br><br>
	</form>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PRICE</th>
			<th colspan="2">OPTION</th>
		</tr>
		<c:forEach var="pro" items="${prolist}">
		<tr>
			<td>${pro.productId}</td>
			<td>${pro.productName}</td>
			<td>${pro.productPrice}</td>
			<td><a href="/inventory/EditandDeleteProduct?id=${pro.productId}&s=1">Edit</a></td>
			<td><a href="/inventory/EditandDeleteProduct?id=${pro.productId}&s=2">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<jsp:getProperty property = "msg" name = "searchs"/>
	</center>
</body>
</html>