<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
	<h1>${question.question}</h1>
	<h2>Select Tags:</h2>
	<ul>
		<c:forEach var="tag" items="${question.tags}">
			<li>${tag.subject}</li>
		</c:forEach>
	</ul>

	<c:if test="${not empty answers}">
		<table class="table">
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${answers}" var="answer">
					<tr>
						<td>${answer.answerText}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<h2>Add your answer</h2>
	<form:form action="/questions/${question.id}/post" method="post"
		modelAttribute="answer">
		<div>
			<label for="answerText">Your Answer:</label>
			<form:input type="text" path="answerText" required="true" />
		</div>
		<div>
			<input type="submit" value="Answer It">
		</div>
	</form:form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
