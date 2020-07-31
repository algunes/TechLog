<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<% response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null)
    response.sendRedirect("UserLogin.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Add Customer</title>
</head>

<body>

<div class="form-group, col-sm-4">

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

<form action="createCustomer" method="post">

<input type="text" class="form-control" placeholder="Firstname" required name="firstname" maxlength="255">

<input type="text" class="form-control" placeholder="Lastname" required name="lastname" maxlength="255">

<select class="custom-select mt-3" required name="corporation">

<c:if test = "${corporation != null}">
<option value="${corporation.getId()}">${corporation.getName()}</option>
</c:if>

<c:if test = "${corporations != null}">		} 
<c:forEach items ="${corporations}" var = "c">
<option value="${c.getId()}">${c.getName()}</option>
</c:forEach>
</c:if>

</select> 

<input type="text" class="form-control" placeholder="Department" required name="department" maxlength="255"> 

<input type="text" class="form-control" placeholder="Position" required name="position" maxlength="255">

<input type="email" class="form-control" placeholder="Email" required name="email" maxlength="255">

<input type="tel" class="form-control" placeholder="Telephone Number" required name="telNum" maxlength="255">
			
<input type="text" class="form-control" placeholder="Address" required name="address" maxlength="255">

<input type="hidden" name="job" value="addCustomer">

<input class="btn btn-primary" value="Submit" type="submit">

</form>

</div>

</body>
</html>