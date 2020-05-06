<%@ page language="java" contentType="text/html; charset = UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>TechLog Customer Management System</title>
</head>
<body>
<h2>TechLog Customer Management System</h2>
<h3>Search for a customer:</h3>
<form action = "searchCustomer" >
	<label for = "name">Name: </label><input type = "text" name = "ad"> <br><br>
	<label for = "surname">Surname: </label><input type = "text" name = "soyad"> <br><br>
	<input type = "submit" value = "Search">
</form>
</body>
</html>
