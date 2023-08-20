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
<title>All Shows</title>
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

.formbox {
	margin: 30px;
	padding: 20px 40px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
</head>

<body>
	<div class="center">
		<div>
			<h1 class="center mt-5 mb-5">Welcome, ${user.name}! 😀</h1>
		</div>
		<h5 class="mb-5">List of all TV Shows:</h5>
		<table class="w-50 table table-dark table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">📺 TV Show</th>
					<th scope="col">▶️ Network</th>
					<th scope="col">⭐ Rating average</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shows}" var="show">
					<tr>
						<td><a href="/shows/${show.id}"><c:out
									value="${show.name}" /></a></td>
						<td><c:out value="${show.network}" /></td>
						<td>${String.format("%.1f", show.avg())}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<form action="/shows/new" method="GET">
			<input class="btn btn-primary text-white" type="submit" value="+ Add">
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>