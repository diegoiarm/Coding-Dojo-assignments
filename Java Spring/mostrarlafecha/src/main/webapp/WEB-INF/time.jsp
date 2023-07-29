<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
        <title>Tiempo - Mostrar la fecha</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styletime.css">
        <script type="text/javascript" src="js/app-time.js"></script>
</head>
<body>
	<c:out value="${horaFormateada}"/>
</body>
</html>