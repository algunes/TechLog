<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
<%@ page import="com.TechLog.Entity.Customers.Customer"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Corporation Details</title>
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
 <b>Corporation Details:</b><br>
 <Table class="table table-sm">

<tr>
<td>
Name: 
</td>
<td>
${corporation.getName()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${corporation.getId()}&
job=updateCorporationName">
update
</a>
 | 
<a href="<%= request.getContextPath() %>
/DeleteCustomer?
id=${corporation.getId()}&
job=removeCorporation">
remove
</a>
)</small><br>
</td>
</tr>

<tr>
<td>
Sector:
</td>
<td>
${corporation.getSector()} <small>(<a href="<%= request.getContextPath() %>
/CustomerUpdate?
id=${corporation.getId()}&
job=updateCorporationSector">
update
</a>
)</small>
</td>
</tr>

<tr>
<td>
Created By:
</td>
<td>
<a href="<%= request.getContextPath() %>
/UserController?
id=${corporation.getCreated_by().getId()}&
job=details">
${corporation.getCreated_by().getFirstname()} ${corporation.getCreated_by().getLastname()}
</a><small>(${corporation.getCreation_date()})</small>
</td>
</tr>

<tr>
<td>
Last Update:
</td>
<td>
<a href="<%= request.getContextPath() %>
/UserController?
id=${corporation.getCreated_by().getId()}&
job=details">
${corporation.getUpdated_by().getFirstname()} ${corporation.getUpdated_by().getLastname()}
</a><small>(${corporation.getLast_update()})</small>
</td>
</tr>
</Table>

<b>Customer List:</b><br>
<Table class="table table-sm">

<c:forEach items ="${corporation.getCustomers()}" var = "e">
<tr>
<td>
<a href="<%=request.getContextPath()%>
/GetCustomer?
id=${e.getCustomer_id()}&
job=getCustomer">${e.getFirstname()} ${e.getLastname()}</a>

</td>
</tr>
</c:forEach>
</Table>
</div>
</body>
</html>