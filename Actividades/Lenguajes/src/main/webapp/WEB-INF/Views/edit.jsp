<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<title>Edit Language</title>
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
	<div class="form-group mt-4 container d-flex flex-column text-justify">
		<div class="form-group mt-3 mb-3d-flex flex-column">
			<div class="w-25 h-25 mb-5 container d-flex flex-column">
				<div class="mb-5 w-50 align-self-center">
					<a href="/languages" class="btn btn-primary">Dashboard</a>
				</div>
				<h1 class="mb-3">Edit Language</h1>
				<form:form action="/languages/edit/${language.id}" method="post"
					modelAttribute="language">
					<input type="hidden" name="_method" value="PUT">
					<p>
						<form:label path="name">Name: </form:label>
						<form:errors path="name" />
						<form:input path="name" />
					</p>
					<p>
						<form:label path="creator">Creator: </form:label>
						<form:errors path="creator" />
						<form:input path="creator" />
					</p>
					<p>
						<form:label path="version">Version: </form:label>
						<form:errors path="version" />
						<form:input path="version" />
					</p>
					<div class="row">
						<div class="mt-3 ml-4 w-50">
							<input class="btn btn-dark" type="submit" value="Submit" />
						</div>
						<div class="mt-3 mr-5 w-50">
							<form:form action="/languages/delete/${language.id}"
								method="post" class="">
								<input type="hidden" name="_method" value="DELETE">
								<button type="button" class="btn btn-danger"
									data-bs-toggle="modal" data-bs-target="#confirmDeleteModal">Delete</button>
							</form:form>
						</div>
					</div>
				</form:form>

				<!-- Modal de confirmación de eliminación -->
				<div class="modal fade" id="confirmDeleteModal" tabindex="-1"
					aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="confirmDeleteModalLabel">Confirm
									Delete</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">Are you sure you want to delete
								this language?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Cancel</button>
								<form:form action="/languages/delete/${language.id}"
									method="post" class="">
									<input type="hidden" name="_method" value="DELETE">
									<input type="submit" value="Delete" class="btn btn-danger">
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
</body>

</html>