<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Customers.Customer"%>
    <%@ page import="com.TechLog.Customers.Corporation"%>
    <%@ page import="com.TechLog.Customers.Email"%>
    <%@ page import="com.TechLog.Customers.Phone"%>
    <%@ page import="com.TechLog.Customers.Address"%>
    <%@ page import="java.util.*"%>
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
<title>Customer Update</title>
</head>
<body>

<% Customer customer = (Customer)request.getAttribute("customer"); %>
<% List<Email> emails = customer.getEmails(); %>
<% Iterator<Email> iteratorE = emails.listIterator(); %>
<% Email email = new Email(); %>

<form accept-charset="utf-8" action="addCustomer" method="post">

		<input type="text" value="<%= customer.getFirstname() %>" name="firstname"><br>
		<input type="text" value="<%= customer.getLastname() %>" name="lastname"><br>
		<% while(iteratorE.hasNext()) { 
		email = iteratorE.next() %>
		<input type="email" placeholder="Email" value="<%= customer.get %>"name="email"><br>
		<input type="tel" placeholder="Telephone Number" name="telNumber"><br>
		<input type="text" placeholder="Address" name="address"><br>
		
		<input value="Submit" type="submit">

	</form>

</body>
</html>