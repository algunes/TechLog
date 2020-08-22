<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Entity.Customers.Customer"%>
    <%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
    <%@ page import="java.util.*"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
	<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Customer Data Confirmation</title>
</head>
<body>
<div class="container">
<c:if test = "${message != null}">
      <div class='alert alert-success'><strong>  
      <c:out value="${message}"/>
      </strong></div>
</c:if>
<c:if test = "${alert != null}">
      <div class='alert alert-warning'><strong>  
      <c:out value="${alert}"/>
      </strong></div>
</c:if>
<table>
<tr>
<td>
<form action="${formaction}" method="post">
${value}<br>
<input type="hidden" value="${value}" name="value"><br>
<input type="hidden" value="${job}" name="job"><br>
<input type="hidden" value="${id}" name="id"><br>
<a href="<%=request.getContextPath()%>/readCustomer?job=getCustomer&id=${id}" class="btn btn-primary" role="button">Back</a>
<button class="btn btn-danger" type="submit">Delete</button>
</form>
</td>
</tr>
</table>


</div>
</body>
</html>