<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<title>New Student</title>
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
		<h1 class="mb-3">New Student</h1>
		<form:form accept-charset="UTF-8" action="/students/new" method="post"
			modelAttribute="student">
			<p>
				<form:label path="firstName">First Name: &nbsp</form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name: &nbsp</form:label>
				<form:errors path="lastName" />
				<form:input path="lastName" />
			</p>
			<p>
				<form:label path="age">Age: </form:label>
				<form:errors path="age" />
				<form:input type="number" path="age" />
			</p>
			<input class="mt-3 btn btn-dark" type="submit" value="Create" />
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>



