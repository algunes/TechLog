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
Long id = (Long)request.getAttribute("id"); 					// Customer id
String formAction = "";											// variable formAction attribute
if(request.getAttribute("formAction") != null)
formAction = (String)request.getAttribute("formAction");
String defaultValue = "";										// text which want to modify
if(request.getAttribute("value") != null) {
defaultValue = (String)request.getAttribute("value");
}
int index = 0;													// object index (email, phone number, address etc.)
if(request.getAttribute("index") != null) {
index = (int)request.getAttribute("index");
}
int job = 0;													// job number
if(request.getAttribute("job") != null) {
job = (int) request.getAttribute("job");
}
String message = "";											// a text if want to show
if(request.getAttribute("message") != null) {
message = (String) request.getAttribute("message"); 
}
String placeholder = "";										// placeholder for textarea
if(request.getAttribute("placeholder") != null) {
placeholder = (String) request.getAttribute("placeholder");
}
%>

<%= message %>


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