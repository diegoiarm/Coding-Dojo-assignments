<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="w-25 h-25 mb-5 container d-flex flex-column">
			<a href="/languages"
				class="mt-5 w-50 h-50 container d-flex flex-column btn btn-primary">Dashboard</a>
	</div>
	<div class="mt-5 d-flex flex-column text-center">
		<div class="col container d-flex flex-column">
			<h1 class="">
				<c:out value="${language.name}" />
			</h1>
			<p>
				Creator:
				<c:out value="${language.creator}" />
			</p>
			<p>
				Version:
				<c:out value="${language.version}" />
			</p>
		</div>
		<div class="w-25 h-25 container d-flex flex-column">
			<a href="/languages/edit/${language.id}"
				class="w-50 h-50 container d-flex flex-column btn btn-dark">Edit
				Language</a>
		</div>
		<div class="w-25 h-25 container d-flex flex-column">
			<form action="/languages/delete/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="mt-3 btn btn-danger">
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>