<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null) {
    	response.sendRedirect("UserLogin.jsp");
    }
    else {
    	Users user = (Users)session.getAttribute("user");
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">

<title>Customer Cards Home</title>
</head>

<body>


<% if(session.getAttribute("welcomeMessage") != null ) { 
	out.println(
			
			"<div class='alert alert-success'><strong>"
			+
			session.getAttribute("welcomeMessage")
			+
			"</strong></div>"
			
			);
	session.removeAttribute("welcomeMessage");
 } %>

    
</body>
  
</html>