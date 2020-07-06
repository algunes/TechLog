<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Customers.Corporation"%>
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
<title>Add Customer</title>

</head>
<body>
	<%  
@SuppressWarnings(value={"unchecked"})
List<Corporation> corporations = (request.getAttribute("corporations") instanceof java.util.List ? (List<Corporation>)request.getAttribute("corporations") : new ArrayList<>());
Corporation scorporation = (request.getAttribute("corporation") != null ? (Corporation)request.getAttribute("corporation") : null);
ListIterator<Corporation> iteratorC = corporations.listIterator();
Corporation corporation = null; 
%>

	<form action="addCustomer" method="post">

		<input type="text" placeholder="Firstname" name="firstname"
			maxlength="255"><br> <input type="text"
			placeholder="Lastname" name="lastname" maxlength="255"><br>

		<select name="corporation">

			<% if(scorporation != null) {
		
			out.println("<option value=" + Long.toString(scorporation.getId()) + ">" + scorporation.getName() + "</option>");
			
			while (iteratorC.hasNext()) {	
				corporation = iteratorC.next();  
			
			out.print("<option value=" + Long.toString(corporation.getId()) + ">" + corporation.getName() + "</option>");

			 } 
			} 
		
		else {
			
			out.println("<option value=''> Select a Corporation </option>");

		 	while (iteratorC.hasNext()) {
			
			corporation = iteratorC.next(); 
			out.println("<option value='" + Long.toString(corporation.getId()) + "'>" + corporation.getName() + "</option>");
			} 
			
		}
			%>


		</select><br> <input type="text" placeholder="Department"
			name="department" maxlength="255"><br> <input
			type="text" placeholder="Position" name="position" maxlength="255"><br>
		<input type="email" placeholder="Email" name="email" maxlength="255"><br>
		<input type="tel" placeholder="Telephone Number" name="telNum"
			maxlength="255"><br> <input type="text"
			placeholder="Address" name="address" maxlength="255"><br>
		<input type="hidden" name="job" value="addCustomer"><br>

		<input value="Submit" type="submit">

	</form>

</body>
</html>