<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%
    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
An Error Occured!<br>
<p></p>
<%= exception.getMessage() %>
</body>
</html>