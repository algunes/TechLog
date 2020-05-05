<%@page import="com.techlog.web.model.musteri"%>
<%@ page language="java" contentType="text/html; charset = UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<h3>Müşteriler:</h3>
<body>
<p>
<%
	musteri m = (musteri)request.getAttribute("musteri");
	out.println(m);
%>
</p>
</body>
</html>