<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");

if(session.getAttribute("user") == null) {
	response.sendRedirect("UserLogin.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<title>Create a User</title>
</head>
<body>
<% 
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show
%>
<% if(!message.isEmpty()) { 
	out.println(
			
			"<div class='alert alert-success'><strong>"
			+
			message
			+
			"</strong></div>"
			
			);
 } %>
 
 <form action="user?job=addUser" method="post" oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
 <div class="form-group">
 <div class="col-sm-10">
 <input type="text" class="form-control" placeholder="Firstname" name="firstname" required maxlength="255"><br>
 </div>
 <div class="col-sm-10">
 <input type="text" class="form-control" placeholder="Lastname"  name="lastname" required maxlength="255"><br>
 </div>
 <div class="col-sm-10">
 <input type="text" class="form-control" placeholder="Department"  name="department" required maxlength="255"><br>
 </div>
 <div class="col-sm-10">
 <input type="text" class="form-control" placeholder="Position"  name="position" required maxlength="255"><br>
 </div>
 <div class="col-sm-10">
 <p>Please select a user role:</p>
 <input type="radio" id="admin" name="role" value="Admin"> 
 <label for="male">Admin</label><br>
 <input type="radio" id="accounter" name="role" value="Accounter"> 
 <label for="male">Accounter</label><br>
 <input type="radio" id="salesPerson" name="role" value="Sales Person"> 
 <label for="male">Sales Person</label><br>
 <input type="radio" id="techPerson" name="role" value="Tech. Person"> 
 <label for="male">Tech. Person</label><br>
 </div>
 <div class="col-sm-10">
  <input type="email" class="form-control" placeholder="Email"  name="email" required maxlength="255"><br>
  </div>
  <div class="col-sm-10">
  <input type="text" class="form-control" placeholder="Tel. Number"  name="telNumber" required maxlength="255"><br>
  </div>
  <div class="col-sm-10">
  <input type="text" class="form-control" placeholder="Address"  name="address" required maxlength="255"><br>
  </div>
  <div class="col-sm-10">
  <input type="text" class="form-control" placeholder="Username"  name="username" required maxlength="255"><br>
  </div>
  <div class="col-sm-10">
  <input type=password class="form-control" placeholder="Password" id="password1" required name=up><br>
  </div>
  <div class="col-sm-10">
  <input type=password class="form-control" placeholder="Re-Enter Password" id="password2" name=up2><br>
  </div>
  <div class="col-sm-10">
		<input class="btn btn-primary" value="Submit" type="submit">
		</div>
 </div>
 </form>
 
</body>
</html>