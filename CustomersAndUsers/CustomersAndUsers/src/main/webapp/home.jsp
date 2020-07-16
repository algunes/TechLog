<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.TechLog.Users.Users"%>
<%@ page isELIgnored="false" %>
<%
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

<div class='alert alert-danger'>
Hi ${user.getFirstname()} !
</div>
    
</body>
  
</html>