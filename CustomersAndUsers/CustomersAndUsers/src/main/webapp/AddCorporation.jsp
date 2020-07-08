<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Add Corporation</title>
</head>
<body>
<form action="addCustomer" method="post">
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