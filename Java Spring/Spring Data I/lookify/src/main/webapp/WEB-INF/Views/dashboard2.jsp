<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
</head>

<body>
	   
	<div class="mt-5 container">
		<div class="row">
			<div
				class="col-12 d-flex justify-content-between align-items-center mb-5">
				<div>
					<h4>Song by artist: ${name}</h4>
				</div>
				<form action="/songs/searchbytitle" method="POST"
					class="d-flex align-items-center">
					<div>
						<input type="text" class="form-control" name="artist">
					</div>
					<button type="submit" class="btn btn-primary">Search
						artist</button>
				</form>
				<a class="btn btn-primary" href="/dashboard">Dashboard</a>
			</div>
			<div class="col-6">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Title</th>
							<th scope="col">Rating</th>
							<th scope="col">Artist</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${artistObject}">
							<tr>
								<td><c:out value="${song.title}" /></td>
								<td><c:out value="${song.rating}" /></td>
								<td>
									<form action="/songs/delete" method="POST">
										<input type="hidden" name="id" value="${song.id}" />
										<button class="btn btn-primary" type="submit">Delete</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>

</html>