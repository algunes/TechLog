<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
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

		<input type="text" placeholder="Firstname" name="firstname" maxlength="255"><br>
		<input type="text" placeholder="Lastname" name="lastname" maxlength="255"><br>

		<select name="corporation">
		<option value="">Select a Corporation</option>

			<% 	while (iteratorC.hasNext()) {
			
			corporation = iteratorC.next(); %>
			<option value="<%= corporation.getId() %>"><%= corporation.getName() %></option>
			<% } %>
		</select><br> 
		<input type="text" placeholder="Department" name="department" maxlength="255"><br>
		<input type="text" placeholder="Position" name="position" maxlength="255"><br>
		<input type="email" placeholder="Email" name="email" maxlength="255"><br>
		<input type="tel" placeholder="Telephone Number" name="telNum" maxlength="255"><br>
		<input type="text" placeholder="Address" name="address" maxlength="255"><br>
		<input type="hidden" name="job" value="1"><br>
		
		<input value="Submit" type="submit">

	</form>
</body>
</html>