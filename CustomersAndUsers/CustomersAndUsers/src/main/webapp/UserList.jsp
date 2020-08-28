<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ page import="com.TechLog.Services.DomainViewService.DomainViewService" %>
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
<title>User List</title>

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

<p><b>Current Users</b></p> 
<Table class="table table-sm">

<c:forEach items ="${users}" var = "e">
<tr>
<td>
${e.getFirstname()} ${e.getLastname()} <small>(<a href="<%= request.getContextPath() %>
	/readUser?job=details&id=${e.getId()}">details</a>)</small><br>
	</td>
	</tr>
	</c:forEach>
	
	<c:if test = "${domainPermissions.getUserDomainCreate().createUser()}" >
	
	<tr>
	<td>
	<a href="<%= request.getContextPath() %>
	/createUser?
	job=addUser" class="btn btn-primary btn-sm active" 
	role="button" aria-pressed="true">Create an User</a>
	</td>
	</tr>
	</c:if>
	
	</Table>
	</div>
	<div>
	
	</div>
</body>
</html>