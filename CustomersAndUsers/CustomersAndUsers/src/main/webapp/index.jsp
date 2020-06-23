<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
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
		<a href=".<%request.getContextPath();%>/addCustomer" target="iframe_a">Add Customer</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/addCorporation" target="iframe_a">Add Company</a>
		</td>
		
		<td>
		<a href=".<%request.getContextPath();%>/searchCustomer.jsp" target="iframe_a">Search Customer</a>
		</td>
		
		</table>
		
		<iframe src=".<%request.getContextPath();%>/home.jsp" width="100%" height="500" name="iframe_a" style="border:none;"></iframe>
	</div>
</body>
</html>
