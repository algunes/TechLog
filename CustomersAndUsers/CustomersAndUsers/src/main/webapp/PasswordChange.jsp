<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
<title>Password Change</title>
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
</div>
<div class="container">
<form action="updateUser" method="post" oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
<input type="hidden" name="job" value="updatePassword" >
<div class="form-group">
<div class="col-sm-10">
<input type="hidden" name ="id" value="${id}" >
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="Current Password" id="password" required name=oldPassword><br>
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="New Password" id="password1" required name=up><br>
</div>
<div class="col-sm-10">
<input type=password class="form-control" placeholder="Re-Enter New Password" id="password2" name=up2><br>
</div>
<div class="col-sm-10">
<input class="btn btn-primary" value="Submit" type="submit">
</div>
</div>
</form>
</div>

</body>
</html>