<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ page isELIgnored="false"%>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");

    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">


<title>Customer Cards</title>
</head>
<body>

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
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/addCustomer?job=addCustomer">Add Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/addCustomer?job=addCorporation">Add Corporation</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".${request.getContextPath()}/getCustomer?job=getCorporationList" target="iframe_a">Show Customers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=".${request.getContextPath()}/searchCustomer" target="iframe_a">Search Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=".${request.getContextPath()}/user?job=showUserList" target="iframe_a">Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=".${request.getContextPath()}/user?job=logout">Logout</a>
        </li>
        <li>
      <c:if test = "${user.getRole().equals('Admin')}">
         <p>Your role is:  <c:out value="admin"/><p>
      </c:if>          <a class="nav-link" href=".${request.getContextPath()}/user?job=logout">Login</a>
        </li>
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
