<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<title>New License</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="css/styleindex.css">
<!-- Bootstrap import  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>

<body>
	<div class="mt-3 mb-5 w-100 h-100 container d-flex flex-column">
		<h1 class="mb-3">New License</h1>
		<form:form accept-charset="UTF-8" action="/licenses/new" method="post"
			modelAttribute="license">
			<p>
				<form:label path="person">Person: &nbsp;</form:label>
				<form:select path="person.id" items="${allPersons}"
					itemLabel="fullName" itemValue="id" />
			</p>

			<p>
				<form:label path="state">State: &nbsp</form:label>
				<form:errors path="state" />
				<form:input path="state" />
			</p>
			<p>
				<form:label path="expirationDate">Expiration Date: &nbsp</form:label>
				<form:errors path="expirationDate" />
				<form:input path="expirationDate" type="date" />
			</p>
			<input class="mt-3 btn btn-dark" type="submit" value="Submit" />
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>



