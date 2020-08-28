<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Entity.Customers.Customer"%>
    <%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
    <%@ page import="com.TechLog.Entity.Users.Users"%>
    <%@ page import="com.TechLog.Services.Users.UserService"%>
    <%@ page import="com.TechLog.Services.DomainViewService.DomainViewService" %>
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
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<%
Users masterUser = (Users)request.getSession(false).getAttribute("user");
Users targetUser = (Users)request.getAttribute("user");

pageContext.setAttribute("dvs", new DomainViewService(masterUser, targetUser));
%>

</head>
<body>

<div class="container">
 
<b>User Details:</b> <br>
<Table class="table table-sm">

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
 
<tr>
<td>
Username:
</td>
<td>
${username}
<c:if test = "${dvs.getUserDomainUpdate().updateUsername()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateUsername">edit</a>)</small>
</c:if>
<br>
</td>
</tr>

<c:if test = "${dvs.getUserDomainUpdate().updatePassword()}" >
<tr>
<td>
<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updatePassword">Change Password </a><br>
</td>
<td>
</td>
</tr>
</c:if>


<tr>
<td>
Firstname: 
</td>
<td>
${user.getFirstname()} 
<c:if test = "${dvs.getUserDomainUpdate().updateFirstname()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateFirstname">edit</a>)</small>
</c:if>
<br>
</td>
</tr>

<tr>
<td>
Lastname:
</td>
<td>
${user.getLastname()} 
<c:if test = "${dvs.getUserDomainUpdate().updateLastname()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateLastname">edit</a>)</small>
</c:if>
<br>
</td>
</tr>

<tr>
<td>
Department:  
</td>
<td>
${user.getDepartment()} 
<c:if test = "${dvs.getUserDomainUpdate().updateDepartment()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateDepartment">edit</a>)</small>
</c:if>
<br>
</td>
</tr>

<tr>
<td>
Position: 
</td>
<td>
${user.getPosition()} 
<c:if test = "${dvs.getUserDomainUpdate().updatePosition()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updatePosition">edit</a>)</small>
</c:if>
<br>
</td>
</tr>

<c:if test = "${dvs.getUserDomainUpdate().updatePermissions()}" >
<tr>
<td>
<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateUserPermissions">Permissions</a>   
</td>
<td>
</td>
</tr>
</c:if>

<tr>
<td>
Email:   
</td>
<td>
${user.getEmail()} 
<c:if test = "${dvs.getUserDomainUpdate().updateEmail()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateEmail">edit</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
Tel. Number:   
</td>
<td>
${user.getTelNumber()} 
<c:if test = "${dvs.getUserDomainUpdate().updateTelNumber()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateTelNumber">edit</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
Address:   
</td>
<td>
${user.getAddress()} 
<c:if test = "${dvs.getUserDomainUpdate().updateAddress()}" >
<small>(<a href="<%= request.getContextPath() %>
/updateUser?
id=${user.getId()}&
job=updateAddress">edit</a>)</small><br>
</c:if>
</td>
</tr>

<tr>
<td>
<a href="<%= request.getContextPath() %>
/readUser?
id=${user.getId()}&
job=getCreatedCorporations">Created Corporations </a><br>
</td>
<td>
</td>
</tr>

<tr>
<td>
<a href="<%= request.getContextPath() %>
/readUser?
id=${user.getId()}&
job=getCreatedCustomers">Created Customers </a><br>
</td>
<td>
</td>
</tr>

<tr>
<td>
Last Login:   
</td>
<td>
${user.getLastLogin()}<br>
</td>
</tr>

<tr>
<td>
Start Date:   
</td>
<td>
${user.getStartDate()}<br>
</td>
</tr>

<tr>
<td>
Sum of Sales:   
</td>
<td>
${user.getTotalSales()}<br>
</td>
</tr>

</Table>

<c:if test = "${dvs.getUserDomainDelete().deleteUser()}" >
<button type="button" class="btn btn-sm btn-danger" onclick="document.getElementById('id01').style.display='block'">Delete This</button>

<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form class="modal-content" action="deleteUser" method="get">
    <div class="alert alert-danger">
      <h5>Delete User</h5>
      <p>Are you sure you want to delete ${user.getFirstname()} ${user.getLastname()} ?</p>
    
      <div class="clearfix">
      <input type="hidden" value="${user.getId()}" name="id">
      
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