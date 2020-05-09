<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/script.js"></script>
<title>TechLog Customer Search</title>
<style>
table, td, th {
  border: 0px solid black;
}

table {
  border-collapse: collapse;
  width: 200px;
}

fieldset {
    width:200px;
}

td {
  height: 1px;
}
</style>
</head>
<body>
	<h2>TechLog Customer Search</h2>
	<fieldset>
		<legend>Search by: </legend>
		<table style="float:left">

			<tr style="text-align:left">
				<th><label for="nameYes"><input type="radio"
						id="nameYes" name="searchType" value="1" onclick="ShowHideDiv()" />Customer
						Name </label></th>
			</tr>
			<tr style="text-align:left">

				<th><label for="companyYes"><input type="radio"
						id="companyYes" name="searchType" value="2"
						onclick="ShowHideDiv()" />Company Name </label></th>
			</tr>
			<tr style="text-align:left">

				<th><label for="telYes"><input type="radio" 
						id="telYes"	name="searchType" value="3" 
						onclick="ShowHideDiv()" />Telephone	Number </label></th>
			</tr>
			<tr style="text-align:left">

				<th><label for="emailYes"><input type="radio" 
						id="emailYes" name="searchType" value="4" 
						onclick="ShowHideDiv()" />Email </label></th>
			</tr>
			<tr style="text-align:left">

				<th><label for="addressYes"><input type="radio" 
						id="addressYes"	name="searchType" value="5" 
						onclick="ShowHideDiv()" />Address </label></th>
			</tr>
		</table>
	</fieldset>
	<table style="float:left">
		<tr>
			<td>
				<div id="nameDiv" style="display: none">
					<form action="searchCustomer" name="nameSurname" id="nameBox"
						method="get" onsubmit="return validateForm()">
						<fieldset>
							<input type="text" placeholder="Name" name="ad"><br>
							<input type="text" placeholder="Surname" name="soyad"><br>
							<input type="hidden" id="searchId" name="searchType" value="1">
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>

				<div id="companyDiv" style="display: none">
					<form action="searchCustomer" name="company" id="companyBox"
						method="get" onsubmit="return validateForm()">
						<fieldset>
							<input type="text" placeholder="Company Name" name="company"><br>
							<input type="hidden" id="searchId" name="searchType" value="2">
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>

				<div id="telDiv" style="display: none">
					<form action="searchCustomer" name="telNum" id="telBox"
						method="get" onsubmit="return validateForm()">
						<fieldset>
							<input type="text" placeholder="Tel. Number" name="tel"><br>
							<input type="hidden" id="searchId" name="searchType" value="3">
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>
				
				<div id="emailDiv" style="display: none">
					<form action="searchCustomer" name="email" id="emailBox"
						method="get" onsubmit="return validateForm()">
						<fieldset>
							<input type="email" placeholder="Email" name="email"><br>
							<input type="hidden" id="searchId" name="searchType" value="4">
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>
				
				<div id="addressDiv" style="display: none">
					<form action="searchCustomer" name="address" id="addressBox"
						method="get" onsubmit="return validateForm()">
						<fieldset>
							<input type="text" placeholder="Address" name="address"><br>
							<input type="hidden" id="searchId" name="searchType" value="5">
							<br> <input type="submit" value="Search">
						</fieldset>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
