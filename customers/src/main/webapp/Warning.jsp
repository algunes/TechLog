<%@ page language="java" contentType="text/html; charset=UTF-8"
	 errorPage = "Error.jsp" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Warning</title>
</head>
<body>
<%

// String warning1 = request.getAttribute("nullSearchParameter").toString();
// out.println(warning1);
 

%>

<%-- ${nullSearchParameter} --%>

<c:out value = "${warning}" />

</body>
</html>