<%@ page language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
    <%@ page import="com.TechLog.Customers.Customer"%>
    <%@ page import="com.TechLog.Customers.Corporation"%>
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
String message = "";
if((String)request.getAttribute("message")!=null) {
	message = (String)request.getAttribute("message");
}
String hr = "<hr>";
String br = "<br>";
String email = "";
String telNum = "";
String address = "";
List<String> emails = customer.getEmails(); 
List<String> telNums= customer.getTelNums();
List<String> addresses = customer.getAddresses(); 

int index = 0; 

ListIterator<String> iteratorE = emails.listIterator();
ListIterator<String> iteratorP = telNums.listIterator();
ListIterator<String> iteratorA = addresses.listIterator();%>

<i><% if(!message.isEmpty()) { 
	out.print(message);
	out.print(br);
	out.print(hr);
 } %>
 </i>
 
<Table>

<tr>
<td>
Firstname: 
</td>
<td>
<%= customer.getFirstname() %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=1"> edit</a><br>
</td>
</tr>
<tr>
<td>
Lastname:
</td>
<td>
<%= customer.getLastname() %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=2"> edit</a><br>
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
Department:  
</td>
<% %>
<td>
<%= customer.getDepartment() %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=2"> edit</a><br>
</td>
</tr>

<tr>
<td>
Position:  
</td>
<% %>
<td>
<%= customer.getLastname() %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=2"> edit</a><br>
</td>
</tr>


<tr>
<td>
Email:  
</td>
<td>
<% while (iteratorE.hasNext()) {  
email = iteratorE.next(); %>
<%= email %><a href="<%= request.getContextPath() %>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=5&index=<%= emails.indexOf(email) %>"> edit</a> | <a href="<%= request.getContextPath() %>/CustomerDelete?id=<%= customer.getCustomer_id() %>&job=2&index=<%= emails.indexOf(email) %>" onclick="deleteMsg()"> remove </a><br>
<% } %>
<a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=2"> Add</a>
</td>
</tr>

<tr>
<td>
Tel:  
</td>
<td>
<% while (iteratorP.hasNext()) {  
telNum = iteratorP.next(); %>
<%= telNum %> <a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=6&index=<%= telNums.indexOf(telNum) %>"> edit</a> | <a href="<%= request.getContextPath() %>/CustomerDelete?id=<%= customer.getCustomer_id() %>&job=3&index=<%= telNums.indexOf(telNum) %>" onclick="deleteMsg()"> remove </a><br>
<% } %>
<a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=3"> Add</a>
</td>
</tr>

<tr>
<td>
Address:  
</td>
<td>
<% while (iteratorA.hasNext()) {  
address = iteratorA.next();%>
<%= address %><a href="<%= request.getContextPath()%>/CustomerUpdate?id=<%= customer.getCustomer_id() %>&job=7&index=<%= addresses.indexOf(address) %>"> edit</a> | <a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=4&index=<%= address.indexOf(address) %>" onclick="deleteMsg()"> remove </a><br>
<% } %>
<a href="<%= request.getContextPath() %>/AddCustomer?id=<%= customer.getCustomer_id() %>&job=4"> Add</a><br>
</td>
</tr>
</Table>
<a href="<%= request.getContextPath() %>/DeleteCustomer?id=<%= customer.getCustomer_id() %>&job=1" onclick="deleteMsg()" style="float:center"> Delete This</a>

</body>
</html>