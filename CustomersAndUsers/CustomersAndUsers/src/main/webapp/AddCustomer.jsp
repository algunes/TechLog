<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.TechLog.Customers.Corporation"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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
	<div class="form-group">
<div class="col-sm-10">
		<input type="text" class="form-control" placeholder="Firstname" name="firstname"
			maxlength="255">
			</div>
			<div class="col-sm-10">
		<input type="text" class="form-control" placeholder="Lastname"  name="lastname" maxlength="255">
		</div>
		<div class="col-sm-10">
		<select class="custom-select mt-3" name="corporation">

			<% if(scorporation != null) {
		
			out.println("<option value=" + Long.toString(scorporation.getId()) + ">" + scorporation.getName() + "</option>");
			
			} 
		
		else {
			
			out.println("<option selected> Select a Corporation </option>");

		 	while (iteratorC.hasNext()) {
			
			corporation = iteratorC.next(); 
			out.println("<option value='" + Long.toString(corporation.getId()) + "'>" + corporation.getName() + "</option>");
			} 
			
		}
			%>


		</select> 
		</div>
		<div class="col-sm-10">
		<input type="text" class="form-control" placeholder="Department"
			name="department" maxlength="255"> 
			</div>
			<div class="col-sm-10">
			<input
			type="text" class="form-control" placeholder="Position" name="position" maxlength="255">
			</div>
			<div class="col-sm-10">
		<input type="email" class="form-control" placeholder="Email" name="email" maxlength="255">
		</div>
		<div class="col-sm-10">
		<input type="tel" class="form-control" placeholder="Telephone Number" name="telNum"
			maxlength="255">
			</div>
			<div class="col-sm-10">
			<input type="text" class="form-control"
			placeholder="Address" name="address" maxlength="255">
			</div>
		<input type="hidden" name="job" value="addCustomer">

		<div class="col-sm-10">
		<input class="btn btn-primary" value="Submit" type="submit">
		</div>
		</div>

	</form>

</body>
</html>