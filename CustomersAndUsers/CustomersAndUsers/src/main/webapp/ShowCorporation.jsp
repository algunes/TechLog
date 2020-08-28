<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
<%@ page import="com.TechLog.Entity.Customers.Customer"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Corporation Details</title>
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
 
 <b>Corporation Details:</b><br>
 <Table class="table table-sm">

<tr>
<td>
Name: 
</td>
<td>
${corporation.getName()}
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small> (<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${corporation.getId()}&
job=updateCorporationName">update</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
Sector:
</td>
<td>
${corporation.getSector()} 
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${corporation.getId()}&
job=updateCorporationSector">update</a>)</small>
</c:if>
</td>
</tr>

<tr>
<td>
Created By:
</td>
<td>
<a href="<%= request.getContextPath() %>
/readUser?
id=${corporation.getCreated_by().getId()}&
job=details">
${corporation.getCreated_by().getFirstname()} ${corporation.getCreated_by().getLastname()}
</a><small>(${corporation.getCreation_date()})</small>
</td>
</tr>

<tr>
<td>
Last Update:
</td>
<td>
<a href="<%= request.getContextPath() %>
/readUser?
id=${corporation.getCreated_by().getId()}&
job=details">
${corporation.getUpdated_by().getFirstname()} ${corporation.getUpdated_by().getLastname()}
</a>
<c:if test = "${corporation.getLast_update() != null}" >
<small>(${corporation.getLast_update()})</small>
</c:if>
</td>
</tr>
<c:if test = "${domainPermissions.getCustomerDomainDelete().deleteCustomer()}" >
<tr>
<td>
<button type="button" class="btn btn-sm btn-danger" onclick="document.getElementById('id01').style.display='block'">Delete This Corporation</button>
<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form class="modal-content" action="deleteCustomer" method="get">
    <div class="alert alert-danger">
      <h5>Delete Corporation</h5>
      <p>Are you sure you want to delete ${corporation.getName()}?<br>With this process all of the customers under this corporation are going to be removed!</p>
    
      <div class="clearfix">
      <input type="hidden" value="removeCorporation" name="job">
      <input type="hidden" value="${corporation.getId()}" name="id">
      
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" name="" onclick="document.getElementById('id01').style.display='none'" class="deletebtn">Delete</button>
      </div>
    </div>
  </form>
</div>
</td>
<td>
</td>
</tr>
</c:if>
</Table>

<b>Customer List:</b><br>
<Table class="table table-sm">

<c:forEach items ="${corporation.getCustomers()}" var = "e">
<tr>
<td>
<a href="<%=request.getContextPath()%>
/readCustomer?
id=${e.getCustomer_id()}&
job=getCustomer">${e.getFirstname()} ${e.getLastname()}</a>

</td>
</tr>
</c:forEach>
</Table>
</div>
</body>
</html>