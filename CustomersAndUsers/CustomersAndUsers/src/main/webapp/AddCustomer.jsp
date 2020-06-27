<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Customers.Corporation"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/default.css" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/syntax.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Add Customer</title>

</head>
<body>

	<% List<Corporation> corporations = (List<Corporation>)request.getAttribute("corporations"); %>
	<% ListIterator<Corporation> iteratorC = corporations.listIterator(); %>
	<% Corporation corporation = new Corporation(); %>


	<form action="addCustomer" method="post">

		<input type="text" placeholder="Firstname" name="firstname"><br>
		<input type="text" placeholder="Lastname" name="lastname"><br>

		<select name="corporation">
		<option value="">Select a Corporation</option>

			<% 	while (iteratorC.hasNext()) {
			
			corporation = iteratorC.next(); %>
			<option value="<%= corporation.getId() %>"><%= corporation.getName() %></option>
			<% } %>
		</select><br> 
		<input type="email" placeholder="Email" name="email"><br>
		<input type="tel" placeholder="Telephone Number" name="telNumber"><br>
		<input type="text" placeholder="Address" name="address"><br>
		
		<input value="Submit" type="submit">

	</form>
</body>
</html>