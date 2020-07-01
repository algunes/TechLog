<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Customers.Customer"%>
    <%@ page import="com.TechLog.Customers.Corporation"%>
    <%@ page import="com.TechLog.Customers.Email"%>
    <%@ page import="com.TechLog.Customers.Phone"%>
    <%@ page import="com.TechLog.Customers.Address"%>
    <%@ page import="java.util.*"%>
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
<title>Message</title>
</head>
<body>

<% 
String message = "";
if(request.getAttribute("message") != null) {
message = (String) request.getAttribute("message"); 
}
%>

<%= message %>


</body>
</html>