<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/default.css" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/syntax.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Input</title>
</head>
<body>
<% 
Long id = (Long)request.getAttribute("id"); // Customer id

String formAction = (request.getAttribute("formAction") != null ? (String)request.getAttribute("formAction"): "") ;	// variable formAction attribute

String defaultValue = (request.getAttribute("value") != null ? (String)request.getAttribute("value") : "");	// text which want to modify

int index = (request.getAttribute("index") != null ? (int)request.getAttribute("index") : 0);	// collection object index (email, phone number, address etc.)

String job = (request.getAttribute("job") != null ? (String)request.getAttribute("job") : "");	// job

String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show

String placeholder = (request.getAttribute("placeholder") != null ? (String) request.getAttribute("placeholder") : "");	// placeholder for textarea

 %>

<% if(!message.isEmpty()) { 
		out.println("<i>" + message + "</i>" + "<br>" + "<hr>");
 	} 
%>



<form action="<%= formAction %>" id="input" method="post">
<input type="hidden" value="<%= index %>" name="index"><br>
<input type="hidden" value="<%= job %>" name="job"><br>
<input type="hidden" value="<%= id %>" name="id"><br>
<textarea form="input" maxlength="255" placeholder="<%= placeholder %>" name="output" rows="6" cols="50"><%= defaultValue %></textarea><br>
<%-- <input type="text" value="<%= defaultValue %>" placeholder="<%= placeholder %>" name="output" maxlength="255"><br>
 --%>
 <input value="Submit" type="submit">
</form>

</body>
</html>