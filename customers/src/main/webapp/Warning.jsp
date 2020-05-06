<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Warning</title>
</head>
<body>
<%

String warning = request.getAttribute("warning").toString();
out.println(warning);

${warning}


%>
</body>
</html>