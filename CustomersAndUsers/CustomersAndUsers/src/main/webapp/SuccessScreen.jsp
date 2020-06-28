<%@ page language="java" contentType="text/html; charset = UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp" %>
    <%@page import="java.util.*"%>
    <%@page import="com.TechLog.Customers.Customer" %>
    <%@page import="com.TechLog.Customers.Corporation" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
<title>Success Screen</title>
</head>
<body>

<% Corporation corporation = (Corporation) request.getAttribute("corporation"); %>
 <% Customer customer = (Customer)request.getAttribute("customer"); %>
 <%! String str = null; %>
 
 <p><% if (customer != null){
	 str = customer.getFirstname() +" "+customer.getLastname()+" from "+customer.getCorporation().getName();
 }
 else if (corporation != null) {
	 str = corporation.getName();
 } %>

 <p> <%= str %> added succesfully!</p>

</body>
</html>