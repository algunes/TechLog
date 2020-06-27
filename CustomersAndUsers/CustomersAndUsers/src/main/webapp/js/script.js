function ShowHideDiv() {
	var nameYes = document.getElementById("nameYes");
	var companyYes = document.getElementById("companyYes");
	var telYes = document.getElementById("telYes");
	var emailYes = document.getElementById("emailYes");
	var addressYes = document.getElementById("addressYes");

	var nameDiv = document.getElementById("nameDiv");
	var companyDiv = document.getElementById("companyDiv");
	var telDiv = document.getElementById("telDiv");
	var emailDiv = document.getElementById("emailDiv");
	var addressDiv = document.getElementById("addressDiv");
	
	nameDiv.style.display = nameYes.checked ? "block" : "none";
	companyDiv.style.display = companyYes.checked ? "block" : "none";
	telDiv.style.display = telYes.checked ? "block" : "none";
	emailDiv.style.display = emailYes.checked ? "block" : "none";
	addressDiv.style.display = addressYes.checked ? "block" : "none";
}

function validateForm() {
	var x = document.forms["nameSurname"]["ad"].value;
	var y = document.forms["nameSurname"]["soyad"].value;
	var z = document.forms["company"]["company"].value;
	var i = document.forms["telNum"]["tel"].value;
	var j = document.forms["email"]["email"].value;
	var k = document.forms["address"]["address"].value;
	
	if (document.getElementById('nameYes').checked && (y == "" || x == "")) {
		alert("Name and Surname Must be Filled Out!");
		return false;
	}
	if (document.getElementById('companyYes').checked && z == "") {
		alert("Company Must be Filled out!");
		return false;
	}
	if (document.getElementById('telYes').checked && i == "") {
		alert("Telephone Must be Filled out! ");
		return false;
	}
	if (document.getElementById('emailYes').checked && j == "") {
		alert("Email Must be Filled out! ");
		return false;
	}
	if (document.getElementById('addressYes').checked && k == "") {
		alert("Address Must be Filled out! ");
		return false;
	}
}