<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ page isELIgnored="false"%>

<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");    
%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">


<title>Customer Cards</title>
</head>
<body>
<% Users user = ((Users)request.getSession().getAttribute("user")); %>
<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="${request.getContextPath()}">
          Customer Cards
        </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/home.jsp">Home</a>
        </li>
        
        <c:if test = "${user.getDomainPermissions().getCustomerDomain().is_create()}" >
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/createCustomer?job=addCustomer">Add Customer</a>
        </li>
        </c:if>
        
        <c:if test = "${user.getDomainPermissions().getCustomerDomain().is_create()}" >
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/createCustomer?job=addCorporation">Add Corporation</a>
        </li>
        </c:if>
        
        <c:if test = "${user != null}" >
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/readCustomer?job=getCorporationList" target="iframe_a">Show Customers</a>
        </li>
        </c:if>
        
<%--         <c:if test = "${user != null}" >
        <li class="nav-item">
          <a class="nav-link" href=".${request.getContextPath()}/searchCustomer" target="iframe_a">Search Customer</a>
        </li>
        </c:if> --%>
        
        <c:if test = "${user.getDomainPermissions().getUserDomain().is_read()}" >
        <li class="nav-item">
          <a class="nav-link" href=".${request.getContextPath()}/readUser?job=showUserList" target="iframe_a">Users</a>
        </li>
        </c:if>
        
        <c:if test = "${user == null}" >
        
      <li class="dropdown nav-item" id="menuLogin">
        <a class="dropdown-toggle nav-link" href="#" data-toggle="dropdown" id="navLogin">Login</a>

        <div class="dropdown-menu" style="padding:17px;">
           <form action="login" method="post" class="form-signin">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Username" name ="username" required>
            </div>

            <div class="form-group">
              <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>

            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-default">Sign in</button>
            </div>
          </form>
        </div>
        
      </li>
        </c:if>
        
        <c:if test = "${user != null}" >
        <li>
		 <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/readUser?job=details&id=${user.getId()}">Profile</a>
        </li>
        </c:if>
        
        <c:if test = "${user != null}" >
        <li>
		 <a class="nav-link" href=".${request.getContextPath()}/logout">Logout</a>
        </li>
        </c:if>
              
      </ul>
    </div>
  </div>
</nav>
<br>
<br>
<!-- Page Content -->
<div class="container">
  <iframe src=".${request.getContextPath()}/home.jsp" width=100% height="800" name="iframe_a" style="border:none;"></iframe>
</div>
<!-- /.container -->
		
</body>
</html>
