<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
    <%
    response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Error</title>
</head>
<body>

<div class="container">
<c:if test = "${alert != null}">
      <div class='alert alert-danger'><strong>  
      <c:out value="${alert}"/>
      </strong></div>
</c:if>

<c:if test = "${message != null}">
	<div class='alert alert-info'><strong>
	<c:out value ="${message}" />
	</strong></div>
</c:if>

<c:if test = "${pageContext.errorData.statusCode != 0}" >
<div class='alert alert-danger'><strong>
<c:out value ="Something went wrong!" /><br>
</strong>
<c:out value = "Status code: ${pageContext.errorData.statusCode}" />
</div>
</c:if>

</div>
</body>
</html>