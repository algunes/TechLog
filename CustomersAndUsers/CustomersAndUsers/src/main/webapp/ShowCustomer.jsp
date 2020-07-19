<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Customers.Customer"%>
    <%@ page import="com.TechLog.Customers.Corporation"%>
    <%@ page import="java.util.*"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
	<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<script>
function deleteMsg() {
  alert("Are you sure to delete this?");
}
</script>
<title>Customer Details</title>
</head>
<body>

<% 
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
String alert = (request.getAttribute("alert") != null ? (String)request.getAttribute("alert") : "");// a text alert if want to show
%>
 
 <div class="container">
 
 <% if(!message.isEmpty()) { 
	out.println(
			
			"<div class='alert alert-success'><strong>"
			+
			message
			+
			"</strong></div>"
			
			);
 } %>
  <% if(!alert.isEmpty()) { 
	out.println(
			
			"<div class='alert alert-danger'>"
			+
			alert
			+
			"</strong></div>"
			
			);
 } %>
 
<Table class="table table-sm">

<tr>
<td>
Firstname: 
</td>
<td>
${customer.getFirstname()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerFirstname">edit</a>)</small><br>
</td>
</tr>
<tr>
<td>
Lastname:
</td>
<td>
${customer.getLastname()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerLastname">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Corporation:  
</td>
<% %>
<td>
<a href="<%= request.getContextPath()%>
/GetCustomer?
id=${customer.getCorporation().getId()}&
job=getCorporation">${customer.getCorporation().getName()}</a><br>
</td>
</tr>

<tr>
<td>
Department:  
</td>
<% %>
<td>
${customer.getDepartment()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerDepartment">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Position:  
</td>
<% %>
<td>
${customer.getPosition()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerPosition">edit</a>)</small><br>
</td>
</tr>


<tr>
<td>
Email:  
</td>
<td>

<c:forEach items ="${customer.getEmails()}" var = "e">
${e} <small>(<a href="<%= request.getContextPath() %>

/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerEmail&
index=${customer.getEmails().indexOf(e)}">edit</a> | <a href="<%= request.getContextPath() %>

/DeleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerEmail&
index=${customer.getEmails().indexOf(e)}" onclick="deleteMsg()">remove</a>)</small><br>
</c:forEach>

<small><a href="<%= request.getContextPath() %>
/AddCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerEmail"> Add</a></small>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>

<c:forEach items = "${customer.getTelNums()}" var = "e">
${e} <small>(<a href="<%= request.getContextPath()%>

/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerTelNum&
index=${customer.getTelNums().indexOf(e)}">edit</a> | <a href="<%= request.getContextPath() %>

/DeleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerTelNum&
index=${customer.getTelNums().indexOf(e)}" onclick="deleteMsg()">remove</a>)</small><br>
</c:forEach>

<small><a href="<%= request.getContextPath() %>
/AddCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerTelNum"> Add</a></small>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>

<c:forEach items = "${customer.getAddresses()}" var = "e">
${e} <small>(<a href="<%= request.getContextPath()%>

/CustomerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerAddress&
index=${customer.getAddresses().indexOf(e)}">edit</a> | <a href="<%= request.getContextPath() %>

/DeleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerAddress&
index=${customer.getAddresses().indexOf(e)}" onclick="deleteMsg()">remove</a>)</small><br>
</c:forEach>

<small><a href="<%= request.getContextPath() %>
/AddCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerAddress"> Add</a></small><br>
</td>
</tr>
</Table>

<a href="<%= request.getContextPath() %>
/DeleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomer" onclick="deleteMsg()" style="float:center"> Delete This</a>
</div>
</body>
</html>