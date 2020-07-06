<%@ page language="java" errorPage="Error.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page isELIgnored="false"%>
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
<title>Customer Cards</title>
</head>
<body>
	<div class="container">
		<h1 id="hi">Customer Cards</h1>
		
		<table>
		
		<tr>
		<td>
		<a href=".<%request.getContextPath();%>/addCustomer?job=addCustomer" target="iframe_a">Add Customer</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/addCustomer?job=addCorporation" target="iframe_a">Add Corporation</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/getCustomer?job=getCorporationList" target="iframe_a">Show Customers</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/searchCustomer" target="iframe_a">Search Customer</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/users" target="iframe_a">Users</a>
		</td>
		
		</table>
		
		<iframe src=".<%request.getContextPath();%>/home.jsp" width="100%" height="500" name="iframe_a" style="border:none;"></iframe>
	</div>
</body>
</html>
