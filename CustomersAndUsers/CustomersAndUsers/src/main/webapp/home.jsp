<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.TechLog.Users.Users"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
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