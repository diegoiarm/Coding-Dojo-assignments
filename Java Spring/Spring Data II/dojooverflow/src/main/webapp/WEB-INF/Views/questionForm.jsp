<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
	<h1>What is your question?</h1>
	<form:form accept-charset="UTF-8" action="/questions/new" method="post"
		modelAttribute="question">
		<div>
			<label for="question">Question:</label>
			<form:textarea path="question" rows="3" cols="40" required="true" />
		</div>
		<div>
			<label for="tagsInput">Tags (comma separated and lowercase,
				max 3):</label>
			<form:input type="text" path="tagsInput" required="true" />
		</div>
		<div>
			<input type="submit" value="Create Question" />
		</div>
	</form:form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>
</html>