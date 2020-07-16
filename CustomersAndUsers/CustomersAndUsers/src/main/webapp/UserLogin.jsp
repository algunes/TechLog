<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<% 
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
%>



    <form action="userLogin" method="post" class="form-signin">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <% if(!message.isEmpty()) { 
	out.println(
			
			"<div class='alert alert-danger'><strong>"
			+
			message
			+
			"</strong></div>"
			
			);
 } %>
      <label class="sr-only">Username</label>
      <input type="text" class="form-control" placeholder="Username" name ="username" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
  </body>
  
</html>