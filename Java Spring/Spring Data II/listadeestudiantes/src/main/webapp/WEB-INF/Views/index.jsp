<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<title>Students</title>
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
	<div class="col container d-flex flex-column">
		<div class="mt-5 text-center">
			<h1>All Students</h1>
		</div>
		<div class="mt-3 mb-3 w-75 h-75 container d-flex flex-column">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Age</th>
						<th scope="col">Address</th>
						<th scope="col">City</th>
						<th scope="col">State</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${contactInfo}" var="contact">
						<tr>
							<td><c:out value="${contact.student.firstName}${contact.student.lastName}" /></td>
							<td><c:out value="${contact.student.age}" /></td>
							<td><c:out value="${contact.address}" /></td>
							<td><c:out value="${contact.city}" /></td>
							<td><c:out value="${contact.state}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>