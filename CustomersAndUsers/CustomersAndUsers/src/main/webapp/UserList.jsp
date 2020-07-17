<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<script>
function deleteMsg() {
  alert("Are you sure to delete this?");
}
</script>
<title>User List</title>
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
<br>
<div class="container">
 
<Table class="table table-sm">

<tr>
<td>
<c:forEach items ="${users}" var = "e">
${e.getFirstname()} ${e.getLastname()} (${e.getRole()})<small>(<a href="<%= request.getContextPath() %>
	/UserController?job=details&id=${e.getId()}"> details</a>)</small><br>
	</c:forEach>
	</td>
	</tr>
	</Table>
	</div>
</body>
</html>