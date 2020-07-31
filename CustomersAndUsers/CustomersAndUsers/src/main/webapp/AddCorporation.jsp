<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
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
<title>Add Corporation</title>
</head>
<body>

<div class="form-group, col-sm-4">
<form action="CreateCustomer" method="post">
<input type="hidden" name="job" value="addCorporation">
<input type="text" class="form-control" placeholder="Corporation Name" required name="name" maxlength="255">
<input type="text" class="form-control" placeholder="Sector" required name="sector" maxlength="255">
<input type="hidden" name="isActive" value="true">
<input class="btn btn-primary" value="Submit" type="submit">
</form>
</div>
</body>
</html>