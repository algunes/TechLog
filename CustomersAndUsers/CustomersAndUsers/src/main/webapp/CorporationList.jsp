<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html"%>
<%@ page import="com.TechLog.Customers.Corporation"%>
<%@ page import="com.TechLog.Customers.Customer"%>
<%@ page import="java.util.*"%>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
    if(session.getAttribute("user") == null)
    	response.sendRedirect("UserLogin.jsp");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Corporation List</title>
</head>
<body>

	<%
		@SuppressWarnings(value = { "unchecked" })
	List<Corporation> corporations = (request.getAttribute("corporations") instanceof java.util.List
			? (List<Corporation>) request.getAttribute("corporations")
			: null);
	ListIterator<Corporation> iteratorC = corporations.listIterator();
	String message = (request.getAttribute("message") != null ? (String) request.getAttribute("message") : "");
	Corporation corporation = null;
	%>

	<%
		if (!message.isEmpty()) {
		out.println("<i>" + message + "</i>" + "<br>" + "<hr>");
	}
	%>


	<%
		while (iteratorC.hasNext()) {
		corporation = iteratorC.next();
	%>
	<details>
		<summary>
			<a
				href="<%request.getContextPath();%>GetCustomer?id=<%=corporation.getId()%>&job=getCorporation"><%=corporation.getName()%></a>
		</summary>
		<table>
			<tr>
				<td><small>(<a
						href="<%=request.getContextPath()%>/CustomerUpdate?id=<%=corporation.getId()%>&job=updateCorporationName">edit</a>
						| <a
						href="<%=request.getContextPath()%>/DeleteCustomer?id=<%=corporation.getId()%>&job=removeCorporation"
						onclick="deleteMsg()"> remove</a></small>)<br></td>
			</tr>
		</table>
	</details>
	<% } %>
</body>
</html>