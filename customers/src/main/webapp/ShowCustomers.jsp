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
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
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
	<p> - by Refsnes Data. All Rights Reserved.</p>
	</details>
      <%}%>

 

<%-- 
<table>
<caption>Müşteri</caption>
  <tr>
    <td>Kişi No:</td>
    <td><%= m.getKisiNo()%></td>
  </tr>
  <tr>
    <td>Adı: </td>
    <td><%= m.getAd()%></td>
  </tr>
  <tr>
    <td>Soyadı: </td>
    <td><%= m.getSoyad()%></td>
    </tr>
  <tr>
    <td>Kurum: </td>
    <td><%= m.getKurum()%></td>
  </tr>
  <tr>
    <td>Departman: </td>
    <td><%= m.getDepartman()%></td>
  </tr>
  <tr>
    <td>Pozisyon/Ünvan: </td>
    <td><%= m.getPozisyon()%></td>
  </tr>
  <tr>
    <td>Email: </td>
    <td><%= m.getEmail() %></td>
  </tr>
  <tr>
    <td>Telefon: </td>
    <td><%= m.getTelefon() %></td>
  </tr>
  <tr>
    <td>Adres: </td>
    <td><%= m.getAdres() %></td>
  </tr>
  <tr>
    <td>Ekleyen: </td>
    <td><%= m.getEkleyen()%></td>
  </tr>
  <tr>
    <td>Son Değişiklik: </td>
    <td><%= m.getTarih()%></td>
  </tr>
</table> --%>

</body>
</html>