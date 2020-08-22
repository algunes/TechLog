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
<title>Password Change</title>
</head>
<body class="text-center">

<% 
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
String alert = (request.getAttribute("alert") != null ? (String)request.getAttribute("alert") : "");// a text alert if want to show
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

<form action="updateUser" method="post" oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
<input type="hidden" name="job" value="updatePassword" >
<div class="form-group">
<div class="col-sm-10">
<input type="hidden" name ="id" value="${id}" >
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="Current Password" id="password" required name=oldPassword><br>
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="New Password" id="password1" required name=up><br>
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="Re-Enter New Password" id="password2" name=up2><br>
</div>
<div class="col-sm-10">
<input class="btn btn-primary" value="Submit" type="submit">
</div>


</div>
</form>

</body>
</html>