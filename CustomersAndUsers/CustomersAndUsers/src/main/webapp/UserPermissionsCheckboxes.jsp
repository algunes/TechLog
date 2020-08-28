<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.TechLog.Entity.Permissions.*"%>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script><title>Input</title>
<title>User Permissions</title>
</head>
<body>

<div class="container">
 
 <c:if test = "${message != null}">
      <div class='alert alert-success'><strong>  
      <c:out value="${message}"/>
      </strong></div>
</c:if>
<c:if test = "${alert != null}">
      <div class='alert alert-warning'><strong>  
      <c:out value="${alert}"/>
      </strong></div>
</c:if>

<form action="updateUser?job=updateUserPermissions" method="post">
<div class="col-sm-10">

 <p><b>Customer Domain Permissions:</b></p>
 
 <input type="checkbox" id="customerDomainCreate" name="customerDomainCreate" value=true 
 <c:if test = "${domainPermissions.getCustomerDomain().is_create()}"> checked </c:if> >
  <label for="customerDomainCreate"> Create</label><br>
  <input type="checkbox" id="customerDomainRead" name="customerDomainRead" value=true
  <c:if test = "${domainPermissions.getCustomerDomain().is_read()}"> checked </c:if> >
  <label for="customerDomainRead"> Read</label><br>
  <input type="checkbox" id="customerDomainUpdate" name="customerDomainUpdate" value=true
  <c:if test = "${domainPermissions.getCustomerDomain().is_update()}"> checked </c:if> >
  <label for="customerDomainUpdate"> Update</label><br>
  <input type="checkbox" id="customerDomainDelete" name="customerDomainDelete" value=true 
  <c:if test = "${domainPermissions.getCustomerDomain().is_delete()}"> checked </c:if> >
  <label for="customerDomainDelete"> Delete</label><br>
 
 </div>
 
 <div class="col-sm-10">
 <p><b>User Domain Permissions:</b></p>
 
 <input type="checkbox" id="userDomainCreate" name="userDomainCreate" value=true 
 <c:if test = "${domainPermissions.getUserDomain().is_create()}"> checked </c:if> >
  <label for="userDomainCreate"> Create</label><br>
  <input type="checkbox" id="userDomainRead" name="userDomainRead" value=true
  <c:if test = "${domainPermissions.getUserDomain().is_read()}"> checked </c:if> >
  <label for="userDomainRead"> Read</label><br>
  <input type="checkbox" id="userDomainUpdate" name="userDomainUpdate" value=true
  <c:if test = "${domainPermissions.getUserDomain().is_update()}"> checked </c:if> >
  <label for="userDomainUpdate"> Update</label><br>
  <input type="checkbox" id="userDomainDelete" name="userDomainDelete" value=true 
  <c:if test = "${domainPermissions.getUserDomain().is_delete()}"> checked </c:if> >
  <label for="userDomainDelete"> Delete</label><br>
 
 </div>
 
 <%-- <div class="col-sm-10">
 <p><b>Product Domain Permissions:</b></p>
 
 <input type="checkbox" id="productDomainCreate" name="productDomainCreate" value=true
 <c:if test = "${domainPermissions.getProductDomain().is_create()}"> checked </c:if> >
  <label for="productDomainCreate"> Create</label><br>
  <input type="checkbox" id="productDomainRead" name="productDomainRead" value=true
  <c:if test = "${domainPermissions.getProductDomain().is_read()}"> checked </c:if> >
  <label for="productDomainRead"> Read</label><br>
  <input type="checkbox" id="productDomainUpdate" name="productDomainUpdate" value=true
  <c:if test = "${domainPermissions.getProductDomain().is_update()}"> checked </c:if> >
  <label for="productDomainUpdate"> Update</label><br>
  <input type="checkbox" id="productDomainDelete" name="productDomainDelete" value=true
  <c:if test = "${domainPermissions.getProductDomain().is_delete()}"> checked </c:if> >
  <label for="productDomainDelete"> Delete</label><br>
 
 </div>
 
 <div class="col-sm-10">
 <p><b>Stock Domain Permissions:</b></p>
 
 <input type="checkbox" id="stockDomainCreate" name="stockDomainCreate" value=true
 <c:if test = "${domainPermissions.getStockDomain().is_create()}"> checked </c:if> >
  <label for="stockDomainCreate"> Create</label><br>
  <input type="checkbox" id="stockDomainRead" name="stockDomainRead" value=true
  <c:if test = "${domainPermissions.getStockDomain().is_read()}"> checked </c:if> >
  <label for="stockDomainRead"> Read</label><br>
  <input type="checkbox" id="stockDomainUpdate" name="stockDomainUpdate" value=true
  <c:if test = "${domainPermissions.getStockDomain().is_update()}"> checked </c:if> >
  <label for="stockDomainUpdate"> Update</label><br>
  <input type="checkbox" id="stockDomainDelete" name="stockDomainDelete" value=true
  <c:if test = "${domainPermissions.getStockDomain().is_delete()}"> checked </c:if> >
  <label for="stockDomainDelete"> Delete</label><br>
 
 </div> --%>
 <input type="hidden" value="${id}" name="id"><br>
<input class="btn btn-primary" value="Submit" type="submit">

</form>

</div>

</body>
</html>