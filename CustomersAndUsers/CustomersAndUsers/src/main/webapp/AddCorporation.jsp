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
<form action="AddCustomer" method="post">
<div class="form-group">

		<input type="hidden" name="job" value="addCorporation">
		<input type="text" class="form-control" placeholder="Corporation Name" name="name" maxlength="255"><br>
		<input type="text" class="form-control" placeholder="Sector" name="sector" maxlength="255"><br>
		<input type="hidden" name="isActive" value="true"><br>

		<input class="btn btn-primary" value="Submit" type="submit">
</div>
	</form>
</body>
</html>