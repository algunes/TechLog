<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html"%>
<%@ page import="com.TechLog.Entity.Corporations.Corporation"%>
<%@ page import="com.TechLog.Entity.Customers.Customer"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Corporation List</title>
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
<c:if test = "${caption != null}">
      <div class='alert alert-dark'><strong>  
      <c:out value="${caption}"/>
      </strong></div>
</c:if>
 
<b>Corporations: </b><br>
<Table class="table table-sm">

<c:forEach items ="${corporations}" var = "e">
<tr>
<td>
<a href="<%=request.getContextPath()%>

/readCustomer?
id=${e.getId()}&
job=getCorporation">${e.getName()}</a>

</td>
</tr>
</c:forEach>
</Table>
	
</div>
</body>
</html>