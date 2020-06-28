<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="com.TechLog.Customers.Corporation"%>
<%@ page import="com.TechLog.Customers.Customer"%>
<%@ page import="java.util.*"%>
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
<title>Corporation Details</title>
</head>
<body>
<% Corporation corporation = (Corporation)request.getAttribute("corporation"); %>
<% List<Customer> customers = corporation.getCustomers(); %>
<% ListIterator<Customer> iteratorC = customers.listIterator(); %>
<% Customer customer = new Customer(); %>
<p><%= corporation.getName() %></p>
<Table>
<% while(iteratorC.hasNext()) { 
customer = iteratorC.next(); %>
<tr>
<td>
<%= customer.getFirstname() %> <%= customer.getLastname() %> <a class="external" href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCustomer_id() %>"> </a>
</td>
</tr>
<% } %>
</Table>
</body>
</html>