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
<% 
 String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
 String hr = "<hr>";
 String br = "<br>";
 Corporation corporation = (Corporation)request.getAttribute("corporation");
 List<Customer> customers = corporation.getCustomers(); 
 ListIterator<Customer> iteratorC = customers.listIterator();
 Customer customer = null; 
 %>
<i>
<% if(!message.isEmpty()) { 

	out.print(message);
	out.print(br);
	out.print(hr);
	
 } %>
 </i>
 
<p><%= corporation.getName() %></p>
<Table>
<% while(iteratorC.hasNext()) { 
customer = iteratorC.next(); %>
<tr>
<td>
<a href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCustomer_id() %>&job=getCustomer"><%= customer.getFirstname() %> <%= customer.getLastname() %></a><br>
<small><a href="<%= request.getContextPath() %>/AddCustomer?job=addCustomerIntoACorporation&id=<%= corporation.getId() %>">Add</a></small><br>
</td>


</tr>
<% } %>
</Table>
</body>
</html>