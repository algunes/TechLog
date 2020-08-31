<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Customers.Customer"%>
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
<title>Customer List</title>
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
<b>Customers: </b><br>
<Table class="table table-sm">

<c:forEach items ="${customers}" var = "e">
<tr>
<td>

<a href="<%=request.getContextPath()%>
/readCustomer?
id=${e.getCustomer_id()}&
job=getCustomer">
${e.getFirstname()} ${e.getLastname()}</a>
</td>
</tr>
</c:forEach>

<c:if test="${pagination.getNumberOfObjects() == 0}" >
<c:out value="no entries found!">ho ho</c:out>
</c:if>

<tr>
<td>

<form action="searchCustomer" method="post" >

<button type="submit" class="btn btn-secondary btn-sm" 
name="first" value="${pagination.getPrevLink()}" 
<c:if test = "${pagination.getPrevIsNotActive()}" >
disabled
</c:if>
>Prev</button>

<button type="submit" class="btn btn-secondary btn-sm" 
name="first" value="${pagination.getNextLink()}" 
<c:if test = "${pagination.getNextIsNotActive()}" >
disabled
</c:if>
>Next</button>
<input type="hidden" name="keyword" value="${keyword}" />
</form>
</td>
</tr>
<tr>
<td>
<small>pages: (${pagination.getCurrentPage()} / ${pagination.getTotalPage()})</small> | <small>total results: ${pagination.getNumberOfObjects()}</small>
</td>
</tr>

</Table>

</div>
</body>
</html>