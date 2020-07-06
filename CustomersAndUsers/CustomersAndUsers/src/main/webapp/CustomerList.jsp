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

	<% @SuppressWarnings(value={"unchecked"}) 
		List<Customer> customers = (request.getAttribute("customers") instanceof java.util.List ? (List<Customer>)request.getAttribute("customers") : new ArrayList<>()); %>
	<% String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : ""); %>
	<% String hr = "</hr>"; %>
	<% String br = "<br>"; %>
	<% ListIterator<Customer> iteratorC = customers.listIterator(); %>
	<% Customer customer = new Customer(); %>
	
	<% if(!message.isEmpty()) { 

		out.print(message);
		out.print(br);
		out.print(hr);
	
 	} %>
	
	<% 	while (iteratorC.hasNext()) {
			
			customer = iteratorC.next(); %>
	<details>
	<summary> <a href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCustomer_id() %>&job=getCustomer"><%= customer.getFirstname() %> <%= customer.getLastname() %></a></summary>
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