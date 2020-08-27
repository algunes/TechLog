<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
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
<title>Add Corporation</title>
</head>
<body>

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

<div class="form-group, col-sm-4">
<form action="createCustomer" method="post">
<input type="hidden" name="job" value="addCorporation">
<input type="text" class="form-control" placeholder="Corporation Name" required name="name" maxlength="255">
<input type="text" class="form-control" placeholder="Sector" required name="sector" maxlength="255">
<input type="hidden" name="isActive" value="true">
<input class="btn btn-primary" value="Submit" type="submit">
</form>
</div>
</body>
</html>