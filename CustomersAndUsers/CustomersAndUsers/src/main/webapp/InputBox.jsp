<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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
<div class="form-group">
<input type="hidden" value="<%= index %>" name="index"><br>
<input type="hidden" value="<%= job %>" name="job"><br>
<input type="hidden" value="<%= id %>" name="id"><br>
<textarea form="input" class="form-control" maxlength="255" placeholder="<%= placeholder %>" name="output" rows="6" cols="50"><%= defaultValue %></textarea><br>
<%-- <input type="text" value="<%= defaultValue %>" placeholder="<%= placeholder %>" name="output" maxlength="255"><br>
 --%>
 <input class="btn btn-primary" value="Submit" type="submit">
 </div>
</form>

</body>
</html>