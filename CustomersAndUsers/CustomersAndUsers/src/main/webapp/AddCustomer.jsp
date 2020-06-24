<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Customers.Corporation"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>

</head>
<body>

	<% List<Corporation> corporations = (List<Corporation>)request.getAttribute("corporations"); %>
	<% ListIterator<Corporation> iteratorC = corporations.listIterator(); %>
	<% Corporation corporation = new Corporation(); %>


	<p>Now you can add a Customer.</p>
	<form action="addCustomer" method="post">

		<input type="text" placeholder="Firstname" name="firstname"><br>
		<input type="text" placeholder="Lastname" name="lastname"><br>

		<select name="corporation">
		<option value="">Select a Corporation</option>

			<% 	while (iteratorC.hasNext()) {
			
			corporation = iteratorC.next(); %>
			<option value="<%= corporation.getId() %>"><%= corporation.getName() %></option>
			<% } %>
		</select><br> <input type="submit">

	</form>
</body>>
</html>