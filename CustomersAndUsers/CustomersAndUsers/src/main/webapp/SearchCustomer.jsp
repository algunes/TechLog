<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Search Customer</title>
</head>
<body>

	<form action="searchCustomer" method="post">
	<div class="form-group">
		<input class="form-control" type="text" placeholder="Enter a Customer Data" name="keyword" maxlength="255"><br>
		<input class="btn btn-primary" type="submit" value="Search">
	</div>
	</form>
</body>
</html>