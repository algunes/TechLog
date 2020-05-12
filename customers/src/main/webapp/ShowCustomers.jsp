<%@page import="com.techlog.web.model.Musteri"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset = UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TechLog Customer Management System</title>
<style>
table, td, th {
  border: 1px solid black;
}

table {
  border-collapse: collapse;
}

td {
  height: 0px;
}
</style>

</head>
<body>

<h2>TechLog Customer Management System</h2>
<h3>Search Results:</h3>

<%

@SuppressWarnings("unchecked")
List<Musteri> musteriListesi = (ArrayList<Musteri>) request.getAttribute("musteriListesi");

Iterator<Musteri> imusteri = musteriListesi.iterator();
Musteri musteri;
%>

<% while ( imusteri.hasNext()){ 
	musteri = imusteri.next();%>
	<details>
	<summary> <%= musteri.getAd() %> <%= musteri.getSoyad() %> </summary>
	<table>
	
	<tr>
	<td><%= musteri.getKurum() %></td>
	<td><%= musteri.getDepartman() %></td>
	<td><%= musteri.getPozisyon() %></td>
	<td><% 	Iterator<String> itel = musteri.getTel().iterator();
	while (itel.hasNext()) {%>
		<p><%= itel.next() %></p><%}%></td>
	<td><%
	Iterator<String> iemail = musteri.getEmail().iterator();
	while (iemail.hasNext()) {%>
		<p><%= iemail.next() %></p><%}%></td>
		
	<td><%
	Iterator<String> iadres = musteri.getAdres().iterator();
	while (iadres.hasNext()) {%>
		<p><%= iadres.next() %></p><%}%></td>
	
	<td><%= musteri.getEkleyen() %></td>
	<td><%= musteri.getTarih() %></td>
	
	</table>
	</details>
      <%}%>

</body>
</html>