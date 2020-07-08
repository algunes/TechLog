<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Customers.Customer"%>
    <%@ page import="com.TechLog.Customers.Corporation"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script>
function deleteMsg() {
  alert("Are you sure to delete this?");
}
</script>
<title>Customer Details</title>
</head>
<body>

<% 
Customer customer = (Customer)request.getAttribute("customer");
String message = (request.getAttribute("message") != null ? (String)request.getAttribute("message") : "");// a text message if want to show

String email = null;
String telNum = null;
String address = null;
List<String> emails = customer.getEmails(); 
List<String> telNums= customer.getTelNums();
List<String> addresses = customer.getAddresses(); 

int index = 0; 

ListIterator<String> iteratorE = emails.listIterator();
ListIterator<String> iteratorP = telNums.listIterator();
ListIterator<String> iteratorA = addresses.listIterator();
%>

<% if(!message.isEmpty()) { 
	out.println("<i>" + message + "</i>" + "<br>" + "<hr>");
 } %>
 
 <div class="container">
 
<Table class="table table-striped">

<tr>
<td>
Firstname: 
</td>
<td>
<%= customer.getFirstname() %> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerFirstname">edit</a>)</small><br>
</td>
</tr>
<tr>
<td>
Lastname:
</td>
<td>
<%= customer.getLastname() %> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerLastname">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Corporation:  
</td>
<% %>
<td>
<a href="<%request.getContextPath();%>GetCustomer?id=<%= customer.getCorporation().getId() %>&job=getCorporation"><%= customer.getCorporation().getName() %></a><br>
</td>
</tr>

<tr>
<td>
Department:  
</td>
<% %>
<td>
<%= customer.getDepartment() %> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerDepartment">edit</a>)</small><br>
</td>
</tr>

<tr>
<td>
Position:  
</td>
<% %>
<td>
<%= customer.getPosition() %> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerPosition">edit</a>)</small><br>
</td>
</tr>


<tr>
<td>
Email:  
</td>
<td>
<% while (iteratorE.hasNext()) {  
email = iteratorE.next(); %>
<%= email %> <small>(<a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerEmail&index=<%= emails.indexOf(email) %>">edit</a> | <a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=removeCustomerEmail&index=<%= emails.indexOf(email) %>" onclick="deleteMsg()">remove</a>)</small><br>
<% } %>
<small><a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=addCustomerEmail"> Add</a></small>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>
<% while (iteratorP.hasNext()) {  
telNum = iteratorP.next(); %>
<%= telNum %> <small>(<a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerTelNum&index=<%= telNums.indexOf(telNum) %>">edit</a> | <a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=removeCustomerTelNum&index=<%= telNums.indexOf(telNum) %>" onclick="deleteMsg()">remove</a>)</small><br>
<% } %>
<small><a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=addCustomerTelNum"> Add</a></small>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>
<% while (iteratorA.hasNext()) {  
address = iteratorA.next();%>
<%= address %> <small>(<a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=updateCustomerAddress&index=<%= addresses.indexOf(address) %>">edit</a> | <a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=removeCustomerAddress&index=<%= address.indexOf(address) %>" onclick="deleteMsg()">remove</a>)</small><br>
<% } %>
<small><a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=addCustomerAddress"> Add</a></small><br>
</td>
</tr>
</Table>
<a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=removeCustomer" onclick="deleteMsg()" style="float:center"> Delete This</a>
</div>
</body>
</html>