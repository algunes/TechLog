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
<meta charset="UTF-8">
<title>Success Screen</title>
</head>
<body>


<% Corporation corporation = (Corporation) request.getAttribute("corporation"); %>
 <% Customer customer = (Customer)request.getAttribute("customer"); %>
 <p><%= customer.getFirstname() %> <%= customer.getLastname() %> from <%= customer.getCorporation().getName() %></p>
 <p>added succesfully!</p>

</body>
</html>