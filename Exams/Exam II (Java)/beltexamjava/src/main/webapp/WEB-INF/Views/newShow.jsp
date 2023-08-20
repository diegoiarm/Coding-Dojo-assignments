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
<title>Add a new show</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
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

.formbox {
	height: 100%;
	width: 100%;
	max-height: 500px;
	max-width: 700px;
	padding: 20px 35px 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
</head>
<body class="mt-5 container formbox">
	<div class="center">
		<h1 class="center">Add a new show 📽️</h1>
		<form:form accept-charset="UTF-8" action="/shows/new" method="post"
			modelAttribute="show">

			<h5 class="center">
				<form:label path="name">Title:</form:label>
				<form:input path="name" />
				<form:errors path="name" />
				<c:if test="${not empty showExistsError}">
					<p>${showExistsError}</p>
				</c:if>
			</h5>
			<h5 class="center">
				<form:label path="network">Network:</form:label>
				<form:input path="network" />
				<form:errors path="network" />
			</h5>
			<input type="hidden" id="user" name="user" value="${userId}" />
			<div class="text-center">
				<input type="submit" class="btn btn-primary text-white"
					value="Create" />
			</div>
		</form:form>
		<form action="/shows" method="GET">
			<input type="submit"
				class="btn btn-secondary text-white mt-3 ml-5 text-center"
				value="Cancel">
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

</body>
</html>