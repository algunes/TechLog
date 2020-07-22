<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
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
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script><title>Input</title>
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
<form action="${formaction}" id="input" method="post">
<input type="hidden" value="${value}" name="oldValue"><br>
<input type="hidden" value="${job}" name="job"><br>
<input type="hidden" value="${id}" name="id"><br>
<textarea form="input" class="form-control" maxlength="255" 
placeholder="${placeholder}" name="output" rows="6" cols="50">${value}</textarea><br>
<input class="btn btn-primary" value="Submit" type="submit">
</form>
</td>
</tr>
</Table>
</div>

</body>
</html>