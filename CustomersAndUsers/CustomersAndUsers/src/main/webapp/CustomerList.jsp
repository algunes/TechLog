<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Customers.Customer"%>
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
<title>Customer List</title>
</head>
<body>

	<% List<Customer> customers = (List<Customer>)request.getAttribute("customers"); %>
	<% ListIterator<Customer> iteratorC = customers.listIterator(); %>
	<% Customer customer = new Customer(); %>
	
	<% 	while (iteratorC.hasNext()) {
			
			customer = iteratorC.next(); %>
	<details>
	<summary> <%= customer.getFirstname() %> <%= customer.getLastname() %> <a class="external" href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCustomer_id() %>"> </a></summary>
	<table>
	<tr>
	<td>
	Corporation: 
	</td>
	<td>
	<%= customer.getCorporation().getName() %>
	</td>
	</tr>
	</table>
	</details>
	<% } %>
	
</body>
</html>