<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/default.css" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/syntax.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Add Corporation</title>
</head>
<body>
<form action="addCorporation" method="post">

		<input type="text" placeholder="Corporation Name" name="name" maxlength="255"><br>
		<input type="text" placeholder="Sector" name="sector" maxlength="255"><br>
		<input type="checkbox" name="isActive"><br>

		<input value="Submit" type="submit">

	</form>
</body>
</html>