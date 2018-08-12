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
<body><br><br><br>
	<center>
	<h1>Sale Report</h1><br>
	<a href = "/inventory/productSell">Back</a><br><br>
	<jsp:useBean id="sales" class = "models.Sale" scope="request"></jsp:useBean>
	<jsp:getProperty property = "msg" name = "sales"/><br><br>
	<form method = "post">
		Customer Name: <select name = "cusName">
							<c:forEach  var="s" items="${cuslist}">
							  	<option>
							  		${s.customerName}
							  	</option>
					 		</c:forEach>
					   </select><br><br>
		Sale Quantity: <input type = "text" name = "quantity"><br><br>
		sale Date: <input type = "date" name = "sellDate"><br><br>
					<input type = "submit" name = "submit" value = "Sale">
	</form>
	</center>
</body>
</html>