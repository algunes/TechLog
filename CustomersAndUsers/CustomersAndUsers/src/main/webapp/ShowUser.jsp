<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Entity.Customers.Customer"%>
    <%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
    <%@ page import="com.TechLog.Entity.Users.Users"%>
    <%@ page import="com.TechLog.Services.User.UserService"%>
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
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
 
<b>User Details:</b> <br>
<Table class="table table-sm">
<% 
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
String alert = (request.getAttribute("alert") != null ? (String)request.getAttribute("alert") : "");// a text alert if want to show
Users user = (request.getAttribute("user") != null ? (Users)request.getAttribute("user") : null);
String username = new UserService().byteToUsername(user.getUserAuth().getUserName());
%>

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
 
<tr>
<td>
Username: 
</td>
<td>
<%= username %> <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateUsername">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updatePassword">Change Password </a><br>
</td>
</tr>

<tr>
<td>
Firstname: 
</td>
<td>
${user.getFirstname()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateFirstname">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Lastname:
</td>
<td>
${user.getLastname()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateLastname">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Department:  
</td>
<td>
${user.getDepartment()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateDepartment">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Position: 
</td>
<td>
${user.getPosition()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updatePosition">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Role:   
</td>
<td>
<form action="UserController" method="post" >
<input type="hidden" name="id" value="${user.getId()}"> 
<input type="hidden" name="job" value="updateRole"> 
<input type="radio" id="admin" name="role" value="Admin"> 
<label for="male">Admin</label>
<input type="radio" id="accounter" name="role" value="Accounter"> 
<label for="male">Accounter</label>
<input type="radio" id="salesPerson" name="role" value="Sales Person"> 
<label for="male">Sales Person</label>
<input type="radio" id="techPerson" name="role" value="Tech. Person"> 
<label for="male">Tech. Person</label>
<input class="btn btn-primary" value="Submit" type="submit">
</form>
</td>
</tr>

<tr>
<td>
Email:   
</td>
<td>
${user.getEmail()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateEmail">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Tel. Number:   
</td>
<td>
${user.getTelNumber()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateTelNumber">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Address:   
</td>
<td>
${user.getAddress()} <small>(<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=updateAddress">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=getCreatedCorporations">Created Corporations </a><br>
</td>
</tr>

<tr>
<td>
<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=getCreatedCustomers">Created Customers </a><br>
</td>
</tr>

<tr>
<td>
Last Login:   
</td>
<td>
${user.getLastLogin()}<br>
</td>
</tr>

<tr>
<td>
Start Date:   
</td>
<td>
${user.getStartDate()}<br>
</td>
</tr>

<tr>
<td>
Sum of Sales:   
</td>
<td>
${user.getTotalSales()}<br>
</td>
</tr>

</Table>

<a href="<%= request.getContextPath() %>
/UserController?
id=${user.getId()}&
job=removeUser" onclick="deleteMsg()" style="float:center"> Delete This</a>
</div>
</body>
</html>