<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<title>Customer Cards</title>
</head>
<body>

<!-- Navigation -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="#">
          <img src="http://placehold.it/150x50?text=Logo" alt="">
        </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".<%request.getContextPath();%>/home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".<%request.getContextPath();%>/addCustomer?job=addCustomer">Add Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".<%request.getContextPath();%>/addCustomer?job=addCorporation">Add Corporation</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" target="iframe_a" href=".<%request.getContextPath();%>/getCustomer?job=getCorporationList" target="iframe_a">Show Customers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=".<%request.getContextPath();%>/searchCustomer" target="iframe_a">Search Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=".<%request.getContextPath();%>/users" target="iframe_a">Users</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Page Content -->
<div class="container">
  <h1 class="mt-4">Customer Cards</h1>
  <iframe src=".<%request.getContextPath();%>/home.jsp" width="100%" height="500" name="iframe_a" style="border:none;"></iframe>
</div>
<!-- /.container -->
		
</body>
</html>
