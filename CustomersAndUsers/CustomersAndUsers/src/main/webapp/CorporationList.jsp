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

<% List<Corporation> corporations = (List<Corporation>)request.getAttribute("corporations"); %>
<% ListIterator<Corporation> iteratorC = corporations.listIterator(); %>
<% Corporation corporation = new Corporation(); %>


<% while(iteratorC.hasNext()) {
	corporation = iteratorC.next(); %>
<%= corporation.getName() %>
<a class="external" href="<%request.getContextPath();%>GetCorporation?id=<%= corporation.getId() %>"> </a><br>
<% } %>
</body>
</html>