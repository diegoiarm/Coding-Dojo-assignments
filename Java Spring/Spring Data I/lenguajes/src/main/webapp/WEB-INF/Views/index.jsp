<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<title>The Languages Site</title>
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
			<h1>All Languages</h1>
		</div>
		<div class="mt-3 mb-3 w-75 h-75 container d-flex flex-column">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Creator</th>
						<th scope="col">Version</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${languageList}" var="languages">
						<tr>
							<td><c:out value="${languages.name}" /></td>
							<td><c:out value="${languages.creator}" /></td>
							<td><c:out value="${languages.version}" /></td>
							<td><div class="d-flex justify-content-start">
									<form:form action="/languages/delete/${languages.id}"
										method="post">
										<input type="hidden" name="_method" value="delete">
										<input type="submit" value="Delete" class="btn btn-danger">
									</form:form>
									&nbsp<a href="/languages/edit/${languages.id}"
										class="btn btn-dark">Edit</a>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="w-25 h-25 container d-flex flex-column">

			<div class="mt-3 mb-5 w-100 h-100 container d-flex flex-column">
				<h1 class="mb-3">New Language</h1>
				<form:form accept-charset="UTF-8" action="/languages" method="post"
					modelAttribute="languages">
					<p>
						<form:label path="name">Name: &nbsp</form:label>
						<form:errors path="name" />
						<form:input path="name" />
					</p>
					<p>
						<form:label path="creator">Creator: &nbsp</form:label>
						<form:errors path="creator" />
						<form:input path="creator" />
					</p>
					<p>
						<form:label path="version">Version: &nbsp</form:label>
						<form:errors path="version" />
						<form:input path="version" />
					</p>
					<input class="mt-3 btn btn-dark" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>