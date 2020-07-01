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
<script>
function deleteMsg() {
  alert("Are you sure to delete this?");
}
</script>
<title>Customer Details</title>
</head>
<body>

<% Customer customer = (Customer)request.getAttribute("customer");
String message = (String)request.getAttribute("message");
List<Email> emails = customer.getEmails(); 
List<Phone> phones = customer.getPhones();
List<Address> addresses = customer.getAddresses(); 
Email email = new Email();
Phone phone = new Phone();
Address address = new Address();
int indexCounter = 0; 

ListIterator<Email> iteratorE = emails.listIterator();
ListIterator<Phone> iteratorP = phones.listIterator();
ListIterator<Address> iteratorA = addresses.listIterator(); %>

<% if(message != null) { %>
<i><%= message %></i><br>
<% } %>
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
<% indexCounter = 0; 
while (iteratorE.hasNext()) {  
email = iteratorE.next(); %>
<%= email.getEmail() %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=1&email=<%= email.getEmail() %>&emailIndex=<%= indexCounter %>"> edit</a> | <a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=7&emailIndex=<%= indexCounter %>&email=<%= email.getEmail() %>" onclick="deleteMsg()"> remove </a><br>
<% indexCounter++; 
} %>
<br><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=4"> Add an Email</a>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>
<% indexCounter = 0; 	
while (iteratorP.hasNext()) {  
phone = iteratorP.next(); %>
<%= phone.getNumber() %> <a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=2&phone=<%= phone.getNumber() %>&phoneIndex=<%= indexCounter %>"> edit</a> | <a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=8&phoneIndex=<%= indexCounter %>&phone=<%= phone.getNumber() %>" onclick="deleteMsg()"> remove </a><br>
<% indexCounter++;
} %>
<br><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=5"> Add a Phone Number </a>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>
<% 	indexCounter = 0;
while (iteratorA.hasNext()) {  
address = iteratorA.next();%>
<%= address.getAddress() %><a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=3&address=<%= address.getAddress() %>&addressIndex=<%= indexCounter %>"> edit</a> | <a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=9&addressIndex=<%= indexCounter %>&address=<%= address.getAddress() %>" onclick="deleteMsg()"> remove </a><br>
<% indexCounter++;
} %>
<br><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=6"> Add an Address</a>
</td>
</tr>

</Table>


</body>
</html>