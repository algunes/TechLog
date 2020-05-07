<%@ page language="java" contentType="text/html; charset = UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>TechLog Customer Management System</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

td:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>TechLog Customer Management System</h2>

<table>
<caption><h3>Search for a customer:</h3></caption>
<tr>
<td>
<form action = "searchCustomer" method = "get" >
	<input type = "text" placeholder = "Enter Name" name = "ad"><br>
	<input type = "text" placeholder = "Enter Surname" name = "soyad"><br><br>
	<input type = "submit" value = "Search">
</form>
</td>
</tr>
</table>
</body>
</html>
