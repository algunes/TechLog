<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
	<%@ page import="com.TechLog.Customers.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>

	<% List<Customer> customers = (List<Customer>)request.getAttribute("customers"); %>
	<% ListIterator<Customer> iteratorC = customers.listIterator(); %>
	<% Customer customer = new Customer(); %>
	
	<% 	while (iteratorC.hasNext()) {
			
			customer = iteratorC.next(); %>
	<details>
	<summary> <%= customer.getFirstname() %> <%= customer.getLastname() %> </summary>
	<table>
	<tr>
	<td>
	Some value
	</td>
	</tr>
	</table>
	</details>
	<% } %>
	
</body>
</html>