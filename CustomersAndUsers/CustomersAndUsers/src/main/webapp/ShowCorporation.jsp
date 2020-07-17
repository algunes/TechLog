<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="com.TechLog.Customers.Corporation"%>
<%@ page import="com.TechLog.Customers.Customer"%>
<%@ page import="java.util.*"%>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Corporation Details</title>
</head>
<body>
<% 
 String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
 Corporation corporation = (Corporation)request.getAttribute("corporation");
 List<Customer> customers = corporation.getCustomers(); 
 ListIterator<Customer> iteratorC = customers.listIterator();
 Customer customer = null; 
 %>
<i>
<% if(!message.isEmpty()) { 
	out.println("<i>" + message + "</i>" + "<br>" + "<hr>");
 } %>
 </i>
 
 <table class="table table-striped">
 <tr>
 <td>
 Name:
 </td>
 <td>
 <%= corporation.getName() %> | Sector: <%= corporation.getSector() %>
 </td>
 </tr>
 </table>
<hr>
<Table>
<% while(iteratorC.hasNext()) { 
customer = iteratorC.next(); %>
<tr>
<td>
<a href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCustomer_id() %>&job=getCustomer"><%= customer.getFirstname() %> <%= customer.getLastname() %></a><br>
</td>
</tr>
<% } %>
</Table>
<hr>
<small><a href="<%= request.getContextPath() %>/AddCustomer?job=addCustomerIntoACorporation&id=<%= corporation.getId() %>">Add</a></small><br>

</body>
</html>