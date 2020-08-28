<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script><title>Input</title>
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

<Table class="table table-sm">
<tr>
<td>
<form action="${formaction}" id="input" method="post">
<input type="hidden" value="${value}" name="oldValue"><br>
<input type="hidden" value="${job}" name="job"><br>
<input type="hidden" value="${id}" name="id"><br>
<textarea form="input" class="form-control" maxlength="255" 
placeholder="${placeholder}" name="output" rows="6" cols="50">${value}</textarea><br>
<input class="btn btn-primary" value="Submit" type="submit">
</form>
</td>
</tr>
</Table>
</div>

</body>
</html>