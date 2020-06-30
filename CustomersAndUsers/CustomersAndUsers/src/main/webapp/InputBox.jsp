<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/default.css" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/syntax.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Input</title>
</head>
<body>
<% Long id = (Long)request.getAttribute("id");
String defaultValue = (String)request.getAttribute("value");
int index = (int)request.getAttribute("index");
int job = (int) request.getAttribute("job"); %>

<form action="customerUpdate" method="post">
<input type="hidden" value="<%= index %>" name="index"><br>
<input type="hidden" value="<%= job %>" name="job"><br>
<input type="hidden" value="<%= id %>" name="id"><br>
<input type="text" value="<%= defaultValue %>" name="output"><br>
<input value="Submit" type="submit">
</form>

</body>
</html>