<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<title>Edit a show</title>
<style>
.center {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 20px;
}

.center2 {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.center3 {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: -45px;
}

.formbox {
	height: 100%;
	width: 100%;
	max-height: 500px;
	max-width: 700px;
	padding: 20px 30px 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
</head>
<body class="mt-5 container formbox">
	<div class="center">
		<h1 class="center">
			<c:out value="📺 ${show.name}" />
		</h1>
		<form:form method="POST" action="/shows/${show.id}/edit"
			modelAttribute="show">
			<h5 class="center">
				<form:label path="name">Title:</form:label>
				<form:input type="name" path="name" />
				<form:errors path="name" />
			</h5>
			<h5 class="mb-5 center">
				<form:label path="network">Network:</form:label>
				<form:input type="network" path="network" />
				<form:errors path="network" />
			</h5>
			<div class="center">
				<input class="btn btn-info text-white" type="submit" value="Update" />
			</div>
			<div class="center">
				<a class="btn btn-secondary text-white text-center" href="/shows">
					Back </a>
			</div>
			<br>
			<br>
		</form:form>
		<div class="center3">
			<form:form method="POST" action="/shows/${show.id}/delete">

				<input class="btn btn-danger text-white" type="submit"
					value="Delete" />

			</form:form>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>