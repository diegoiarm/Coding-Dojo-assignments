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
<title>Show</title>
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
	margin: 50px 20px;
}
</style>
</head>

<body class="center">

	<h1 class="tituloShow">
		<c:out value="${show.name}" />
	</h1>

	<hr>

	<h5>
		✏️ Created by:
		<c:out value="${show.user.name}" />
	</h5>

	<h5>
		▶️ Network:
		<c:out value="${show.network}" />
	</h5>

	<hr>



	<c:choose>
		<c:when test="${show.user.id == user.id}">
			<form action="/shows/${show.id}/edit">
				<button type="submit" class="btn btn-outline-info">Edit</button>
			</form>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
	<hr>
	<table class="w-50 table table-dark table-bordered table-hover">
		<thead class="thead-dark">
			<tr>
				<th scope="col">👤 Name</th>
				<th scope="col">⭐ Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ratings}" var="ratings">
				<tr>
					<td>${ratings.user.name}</td>
					<td>${ratings.rating}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>

	<c:choose>
		<c:when test="${show.usersJoin.contains(user)}">
			<h3>✅ Already rated.</h3>
		</c:when>
		<c:otherwise>
			<form action="/shows/${show.id}/rate" method="post">
				<label for="rating">Rating (1.0 - 5.0):</label> <input type="number"
					step="0.1" min="1" max="5" name="rating" required
					oninput="setCustomValidity('')"
					oninvalid="this.setCustomValidity('Rating should be between 1 and 5.')">
				<button class="btn btn-warning text-white" type="submit">Rate</button>
			</form>
		</c:otherwise>
	</c:choose>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>