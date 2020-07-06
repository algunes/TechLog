<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="com.TechLog.Customers.Corporation"%>
<%@ page import="com.TechLog.Customers.Customer"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/default.css" />
<link rel="stylesheet" type="text/css"
	href=".<%request.getContextPath();%>/css/syntax.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>Corporation List</title>
</head>
<body>

<%  
@SuppressWarnings(value={"unchecked"})
List<Corporation> corporations = (request.getAttribute("corporations") instanceof java.util.List ? (List<Corporation>)request.getAttribute("corporations") : new ArrayList<>());
ListIterator<Corporation> iteratorC = corporations.listIterator();
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");
String hr = "<hr>";
String br = "<br>";
Corporation corporation = null; 
%>
<i>
<% if(!message.isEmpty()) { 

		out.print(message);
		out.print(br);
		out.print(hr);
	
 	} 
%>
</i>


<% while(iteratorC.hasNext()) {
	corporation = iteratorC.next(); %>
<a href="<% request.getContextPath(); %>GetCustomer?id=<%= corporation.getId() %>&job=getCorporation"><%= corporation.getName() %>
</a> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= corporation.getId() %>&job=updateCorporationName">edit</a> | <a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= corporation.getId() %>&job=removeCorporation" onclick="deleteMsg()"> remove</a></small>)<br>
<% } %>
</body>
</html>