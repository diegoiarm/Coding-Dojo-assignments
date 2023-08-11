<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="m-5">
		<h1>New product</h1>

		<form:form accept-charset="UTF-8" action="/products/new" method="post"
			modelAttribute="product">

			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input id="input1" path="name" />
			</p>

			<p>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:textarea id="input2" path="description" />
			</p>
			<p>
				<form:label path="price">Price:</form:label>
				<form:errors path="price" />
				<form:input id="input3" path="price" />
			</p>
			<input id="create" type="submit" value="Create" />
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>