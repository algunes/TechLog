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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Customer Cards Home</title>
</head>

<body class="text-center">

    <form action="login" method="post" class="form-signin" target = _parent>
    <h1 class="h2 mb-2 font-weight-bold">Techlog Customer Cards</h1>
      <h2 class="h3 mb-3 font-weight-normal">Please sign in</h2>
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
      <label class="sr-only">Username</label>
      <input type="text" class="form-control" placeholder="Username" name ="username" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</body>
  
</html>