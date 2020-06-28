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
<title>Customer Details</title>
</head>
<body>

<% Customer customer = (Customer)request.getAttribute("customer");
List<Email> emails = customer.getEmails(); 
List<Phone> phones = customer.getPhones();
List<Address> addresses = customer.getAddresses(); 

ListIterator<Email> iteratorE = emails.listIterator();
ListIterator<Phone> iteratorP = phones.listIterator();
ListIterator<Address> iteratorA = addresses.listIterator(); %>


<Table>

<tr>
<td>
Name: 
</td>
<td>
<%= customer.getFirstname() %> <%= customer.getLastname() %> 
</td>
</tr>

<tr>
<td>
Corporation:  
</td>
<% %>
<td>
<%= customer.getCorporation().getName() %> <a class="external" href="<%request.getContextPath();%>GetCorporation?id=<%= customer.getCorporation().getId() %>"> </a>
</td>
</tr>


<tr>
<td>
Email:  
</td>
<td>
<% 	while (iteratorE.hasNext()) {  %>
<%= iteratorE.next().getEmail() %><br>
<% } %>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>
<% 	while (iteratorP.hasNext()) {  %>
<%= iteratorP.next().getNumber() %><br>
<% } %>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>
<% 	while (iteratorA.hasNext()) {  %>
<%= iteratorA.next().getAddress() %><br>
<% } %>
</td>
</tr>

</Table>


</body>
</html>