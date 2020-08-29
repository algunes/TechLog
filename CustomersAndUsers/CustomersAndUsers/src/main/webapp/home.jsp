<%@ page language="java" errorPage="Error.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html" %>
<%@ page import="java.util.*"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.TechLog.Entity.Customers.Customer" %>
<%@ page import="com.TechLog.Entity.Corporations.Corporation" %>
<%@ page import="com.TechLog.Services.Customer.CustomerPostService" %>
<%@ page import="com.TechLog.Services.Corporation.CorporationPostService" %>
<%@ page import="com.TechLog.Services.Users.UserService" %>
<%@ page import="com.TechLog.Entity.Users.Users"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false" %>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<title>Customer Cards Home</title>

<%
if(session.getAttribute("user") != null) {
	List<Customer> lastAddedCustomers = new CustomerPostService().getLastAddedCustomers();
	List<Customer> lastUpdatedCustomers = new CustomerPostService().getLastUpdatedCustomers();
	List<Corporation> lastAddedCorporations = new CorporationPostService().getLastAddedCorporations();
	List<Users> lastLoginUsers = new UserService().getLastLoginUsers();
	
	pageContext.setAttribute("lastAddedCorporations", lastAddedCorporations);
	pageContext.setAttribute("lastAddedCustomers", lastAddedCustomers);
	pageContext.setAttribute("lastUpdatedCustomers", lastUpdatedCustomers);
	pageContext.setAttribute("lastLoginUsers", lastLoginUsers);
}
%>

</head>
 <c:if test = "${message != null}" >
 <c:out value = "${message}" />
 </c:if>
<body>

<c:if test="${user == null}" >
 <h4>Hi! Welcome to Customer Cards Demo.</h4><br>
 <h5>With this you can store your business contact cards.</h5>
</c:if>
 
 <c:if test="${user != null}" >
 <div class="container">

      <div class="card-body row no-gutters align-items-center">
        <form class="card-body row no-gutters align-items-center" action="searchCustomer" method="post">
        <div class="col">
              <input class="form-control form-control-lg form-control-borderless" type="search" name="keyword" placeholder="Search customers or corporations">
        </div>
        <!--end of col-->
        <div class="col-auto">
              <button class="btn btn-lg btn-success bg-dark" type="submit">Search</button>
        </div>
        </form>
        <!--end of col-->
    </div>
    </div>
    <hr/>
    
     <div class="container">
     <div class="row">
    <div class="col">
          <h6>Last Added Customers:</h6>
      <table class="table table-sm">
      <c:forEach items="${lastAddedCustomers}" var="c"> 
		<tr>
		<td>
      <a href="<%=request.getContextPath()%>
		/readCustomer?
		id=${c.getCustomer_id()}&
		job=getCustomer">
		${c.getFirstname()} ${c.getLastname()}</a>
		<br><small>
		(${c.getCreation_date().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))})
		</small>
		</td>
		</tr>
      </c:forEach>
      </table>
    </div>
    <div class="col">
    <h6>Last Added Corporations:</h6>
    <table class="table table-sm">
      <c:forEach items="${lastAddedCorporations}" var="c"> 
		<tr>
		<td>
      <a href="<%=request.getContextPath()%>
		/readCustomer?
		id=${c.getId()}&
		job=getCorporation">
		${c.getName()}</a>
		<br><small>
		(${c.getCreation_date().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))})
		</small>
		</td>
		</tr>
      </c:forEach>
      </table>
  </div>
    <div class="col">
     <h6>Last Updated Customers:</h6>
     <table class="table table-sm">
      <c:forEach items="${lastUpdatedCustomers}" var="c"> 
		<tr>
		<td>
      <a href="<%=request.getContextPath()%>
		/readCustomer?
		id=${c.getCustomer_id()}&
		job=getCustomer">
		${c.getFirstname()} ${c.getLastname()}</a>
		<br><small>
		(${c.getLast_update().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))})
		</small>
		</td>
		</tr>
      </c:forEach>
      </table>
    </div>
    <div class="col">
    <h6>Last Signed in users:</h6>
    <table class="table table-sm">
      <c:forEach items="${lastLoginUsers}" var="us"> 
		<tr>
		<td>
      <a href="<%=request.getContextPath()%>
		/readUser?
		id=${us.getId()}&
		job=details">
		${us.getFirstname()} ${us.getLastname()}</a>
		<br><small>
		(${us.getLastLogin().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))})
		</small>
		</td>
		</tr>
      </c:forEach>
      </table>
  </div>
  </div>
  </div>
 </c:if>
     
</body>
  
</html>