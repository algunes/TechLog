<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Customers.Customer"%>
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
<title>Customer List</title>
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
<b>Customers: </b><br>
<Table class="table table-sm">

<c:forEach items ="${customers}" var = "e">
<tr>
<td>

<a href="<%=request.getContextPath()%>
/GetCustomer?
id=${e.getCustomer_id()}&
job=getCustomer">
${e.getFirstname()} ${e.getLastname()}</a>
</td>
</tr>
</c:forEach>

</Table>
</div>
</body>
</html>