<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="m-5">
		<h1>
			<c:out value="${categories.name}" />
			<!-- Cambiado de "product.name" a "categories.name" -->
		</h1>
		<h2>Products:</h2>
		<ul>
			<c:forEach items="${categories.products}" var="product">
				<!-- Iterar sobre la lista "categories" -->
				<li><c:out value="${product.name}" /></li>
				<!-- Mostrar el nombre de la categoría -->
			</c:forEach>
		</ul>
		<form:form accept-charset="UTF-8"
			action="/categories/${categories.id}" method="post"
			modelAttribute="category_product">
			<p>
				Add product: <select name="product.id" id="category">
					<!-- Cambiado a "product.id" -->
					<c:forEach items="${products}" var="product">
						<!-- Iterar sobre la lista "products" -->
						<option value="${product.id}">${product.name}</option>
						<!-- Mostrar el nombre del producto y su ID como valor -->
					</c:forEach>
				</select>
			</p>
			<form:input type="hidden" path="category.id" value="${categories.id}" />
			<!-- Cambiado a "category.id" -->
			<input id="create2" type="submit" value="Add" />
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>