<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>TechLog Customer Management System</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

td, th {
	border: 0px solid #dddddd;
	text-align: left;
	padding: 8px;
}

td:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h2>TechLog Customer Management System</h2>

	<!-- 	<form action="searchCustomer" method="get">
		<fieldset>
			<legend>Search By Name:</legend>
			<input type="text" placeholder="Enter Name" name="ad"><br>
			<input type="text" placeholder="Enter Surname" name="soyad"><br>
			<br> <input type="submit" value="Search">
		</fieldset>
	</form> -->

	<script type="text/javascript">
		function ShowHideDiv() {
			var nameYes = document.getElementById("nameYes");
			var companyYes = document.getElementById("companyYes");

			var nameBox = document.getElementById("nameBox");
			var companyBox = document.getElementById("companyBox");

			nameBox.style.display = nameYes.checked ? "block" : "none";
			companyBox.style.display = companyYes.checked ? "block" : "none";
		}
		
		function validateForm() {
			  var x = document.forms["nameSurname"]["ad"].value;   
			  var y = document.forms["nameSurname"]["soyad"].value;
			  var z = document.forms["company"]["company"].value;
			  if (document.getElementById('nameYes').checked && (y == "" || x == "")) {
			    alert("Name and Surname Must be Filled Out! "+document.getElementById('nameYes').checked);
			    // document.getElementById("nameYes").checked = false;
			    return false;
			  }
			  else if (document.getElementById('companyYes').checked && z == "") {
				 alert("Company Must be Filled out! "+document.getElementById('companyYes').checked);
				 return false;
			  }
			}
		
	</script>
	
	<table>

		<tr>
			<th><label for="nameYes"> <input type="radio"
					id="nameYes" name="searchType" value="true" onclick="ShowHideDiv()" />
					Search by Customer Name
			</label></th>
		</tr>
		<tr>

			<th><label for="companyYes"> <input type="radio"
					id="companyYes" name="searchType" value="true" onclick="ShowHideDiv()" />
					Search by Company Name
			</label></th>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<div id="nameBox" style="display: none">
					<form action="searchCustomer" name="nameSurname" method="get" onsubmit="return validateForm()">
						<fieldset>
							<legend>Search by Customer Name</legend>
							<input type="text" placeholder="Name" name="ad"><br>
							<input type="text" placeholder="Surname" name="soyad"><br>
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>

				<div id="companyBox" style="display: none">
					<form action="searchCustomer" name="company" method="get" onsubmit="return validateForm()">
						<fieldset>
							<legend>Search by Company Name</legend>
							<input type="text" placeholder="Company Name" name="company"><br>
							<input type="submit" value="Search">
						</fieldset>
					</form>
				</div>
			</td>
		</tr>

	</table>




</body>
</html>
