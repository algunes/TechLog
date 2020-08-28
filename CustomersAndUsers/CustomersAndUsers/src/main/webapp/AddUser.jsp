<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Entity.Users.Users"%>
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
<title>Create a User</title>
</head>
<body>

<c:if test = "${message != null}">
      <div class='alert alert-success'><strong>  
      <c:out value="${message}"/>
      </strong></div>
</c:if>

<c:if test = "${alert != null}">
      <div class='alert alert-danger'><strong>  
      <c:out value="${alert}"/>
      </strong></div>
</c:if>
 
 <form action="createUser" method="post" oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
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
  
  <div class="col-sm-10">
 
 <p>Customer Domain Permissions:</p>
 
 <input type="checkbox" id="customerDomainCreate" name="customerDomainCreate" value=true>
  <label for="customerDomainCreate"> Create</label><br>
  <input type="checkbox" id="customerDomainRead" name="customerDomainRead" value=true>
  <label for="customerDomainRead"> Read</label><br>
  <input type="checkbox" id="customerDomainUpdate" name="customerDomainUpdate" value=true>
  <label for="customerDomainUpdate"> Update</label><br>
  <input type="checkbox" id="customerDomainDelete" name="customerDomainDelete" value=true>
  <label for="customerDomainDelete"> Delete</label><br>
 
 </div>
 
 <div class="col-sm-10">
 <p>User Domain Permissions:</p>
 
 <input type="checkbox" id="userDomainCreate" name="userDomainCreate" value=true>
  <label for="userDomainCreate"> Create</label><br>
  <input type="checkbox" id="userDomainRead" name="userDomainRead" value=true>
  <label for="userDomainRead"> Read</label><br>
  <input type="checkbox" id="userDomainUpdate" name="userDomainUpdate" value=true>
  <label for="userDomainUpdate"> Update</label><br>
  <input type="checkbox" id="userDomainDelete" name="userDomainDelete" value=true>
  <label for="userDomainDelete"> Delete</label><br>
 
 </div>
 
<!--  <div class="col-sm-10">
 <p>Product Domain Permissions:</p>
 
 <input type="checkbox" id="productDomainCreate" name="productDomainCreate" value=true>
  <label for="productDomainCreate"> Create</label><br>
  <input type="checkbox" id="productDomainRead" name="productDomainRead" value=true>
  <label for="productDomainRead"> Read</label><br>
  <input type="checkbox" id="productDomainUpdate" name="productDomainUpdate" value=true>
  <label for="productDomainUpdate"> Update</label><br>
  <input type="checkbox" id="productDomainDelete" name="productDomainDelete" value=true>
  <label for="productDomainDelete"> Delete</label><br>
 
 </div>
 
 <div class="col-sm-10">
 <p>Stock Domain Permissions:</p>
 
 <input type="checkbox" id="stockDomainCreate" name="stockDomainCreate" value=true>
  <label for="stockDomainCreate"> Create</label><br>
  <input type="checkbox" id="stockDomainRead" name="stockDomainRead" value=true>
  <label for="stockDomainRead"> Read</label><br>
  <input type="checkbox" id="stockDomainUpdate" name="stockDomainUpdate" value=true>
  <label for="stockDomainUpdate"> Update</label><br>
  <input type="checkbox" id="stockDomainDelete" name="stockDomainDelete" value=true>
  <label for="stockDomainDelete"> Delete</label><br>
 
 </div> -->
		<input class="btn btn-primary" value="Submit" type="submit">
		</div>
 </div>
 </form>
 
</body>
</html>