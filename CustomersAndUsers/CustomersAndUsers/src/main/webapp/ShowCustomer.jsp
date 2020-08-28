<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Entity.Customers.Customer"%>
    <%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Customer Details</title>
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
 
<b>Customer Details:</b> <br>
<Table class="table table-sm">

<tr>
<td>
Firstname: 
</td>
<td>
${customer.getFirstname()} 
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerFirstname">edit</a>)</small><br>
</c:if>
</td>
</tr>
<tr>
<td>
Lastname:
</td>
<td>
${customer.getLastname()} 
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerLastname">edit</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
Corporation:  
</td>
<% %>
<td>
<a href="<%= request.getContextPath()%>
/readCustomer?
id=${customer.getCorporation().getId()}&
job=getCorporation">${customer.getCorporation().getName()}</a><br>
</td>
</tr>

<tr>
<td>
Department:  
</td>
<% %>
<td>
${customer.getDepartment()} 
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerDepartment">edit</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
Position:  
</td>
<% %>
<td>
${customer.getPosition()} 
<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerPosition">edit</a>)</small><br>
</c:if>
</td>
</tr>


<tr>
<td>
Email:  
</td>
<td>

<c:forEach items ="${customer.getEmails()}" var = "e">
${e} 

<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerEmail&
index=${customer.getEmails().indexOf(e)}">edit</a>) </small>
</c:if>

<c:if test = "${domainPermissions.getCustomerDomainDelete().deleteCustomer()}" >
 <small>(<a href="<%= request.getContextPath() %>
/deleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerEmail&
index=${customer.getEmails().indexOf(e)}">remove</a>)</small><br>
</c:if>
</c:forEach>

<c:if test = "${domainPermissions.getCustomerDomainCreate().createCustomer()}" >
<small><a href="<%= request.getContextPath() %>
/createCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerEmail"> Add</a></small>
</c:if>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>

<c:forEach items = "${customer.getTelNums()}" var = "e">
${e} 

<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath()%>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerTelNum&
index=${customer.getTelNums().indexOf(e)}">edit</a>) </small>
</c:if>

<c:if test = "${domainPermissions.getCustomerDomainDelete().deleteCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/deleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerTelNum&
index=${customer.getTelNums().indexOf(e)}">remove</a>)</small><br>
</c:if>
</c:forEach>

<c:if test = "${domainPermissions.getCustomerDomainCreate().createCustomer()}" >
<small><a href="<%= request.getContextPath() %>
/createCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerTelNum"> Add</a></small>
</c:if>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>

<c:forEach items = "${customer.getAddresses()}" var = "e">
${e} 

<c:if test = "${domainPermissions.getCustomerDomainUpdate().updateCustomer()}" >
<small>(<a href="<%= request.getContextPath()%>
/customerUpdate?
id=${customer.getCustomer_id()}&
job=updateCustomerAddress&
index=${customer.getAddresses().indexOf(e)}">edit</a>) </small>
</c:if>

<c:if test = "${domainPermissions.getCustomerDomainDelete().deleteCustomer()}" >
<small>(<a href="<%= request.getContextPath() %>
/deleteCustomer?
id=${customer.getCustomer_id()}&
job=removeCustomerAddress&
index=${customer.getAddresses().indexOf(e)}">remove</a>)</small><br>
</c:if>
</c:forEach>

<c:if test = "${domainPermissions.getCustomerDomainCreate().createCustomer()}" >
<small><a href="<%= request.getContextPath() %>
/createCustomer?
id=${customer.getCustomer_id()}&
job=addCustomerAddress"> Add</a></small><br>
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
id=${customer.getCreated_by().getId()}&
job=details">
${customer.getCreated_by().getFirstname()} ${customer.getCreated_by().getLastname()}
</a><small> (${customer.getCreation_date()})</small>
</td>
</tr>

<tr>
<td>
Last Update:  
</td>
<td>
<a href="<%= request.getContextPath() %>
/readUser?
id=${customer.getUpdated_by().getId()}&
job=details">
${customer.getUpdated_by().getFirstname()} ${customer.getUpdated_by().getLastname()}
</a>
<c:if test = "${customer.getLast_update() != null}" >
<small> (${customer.getLast_update()})</small>
</c:if>
</td>
</tr>

</Table>

<c:if test = "${domainPermissions.getCustomerDomainDelete().deleteCustomer()}" >
<button type="button" class="btn btn-sm btn-danger" onclick="document.getElementById('id01').style.display='block'">Delete This</button>
<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form class="modal-content" action="deleteCustomer" method="get">
    <div class="alert alert-danger">
      <h5>Delete Customer</h5>
      <p>Are you sure you want to delete ${customer.getFirstname()} ${customer.getLastname()}?</p>
    
      <div class="clearfix">
      <input type="hidden" value="removeCustomer" name="job">
      <input type="hidden" value="${customer.getCustomer_id()}" name="id">
      
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" name="" onclick="document.getElementById('id01').style.display='none'" class="deletebtn">Delete</button>
      </div>
    </div>
  </form>
</div>
</c:if>

</div>
</body>
</html>