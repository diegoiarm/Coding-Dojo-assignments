<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <title>Contador de visitas</title>
        <link rel="stylesheet" type="text/css" href="css/indexstyle.css">
</head>
<body>
	<p> Has visitado <a href="/">http://localhost:8080/</a> 
	<c:choose>
        <c:when test="${count == null}">0 veces.</c:when>
        <c:when test="${count == 1}"><c:out value="${count}" /> vez.</c:when>
        <c:otherwise><c:out value="${count}" /> veces.</c:otherwise>
    </c:choose></p>
    
	<a href="/">¿Probamos con otra visita?</a><br><br>
	<a href="/doublevisit">¿Que tal una visita doble?</a>
	
    <form id="resetForm" action="/reset" method="post">
        <input type="hidden" name="_method" value="POST">
    </form>
    <p> O, <a href="javascript:void(0);" onclick="resetCounter();">resetea el contador.</a> </p>

    <script>
        function resetCounter() {
            document.getElementById("resetForm").submit();
        }
    </script>
</body>
</html>