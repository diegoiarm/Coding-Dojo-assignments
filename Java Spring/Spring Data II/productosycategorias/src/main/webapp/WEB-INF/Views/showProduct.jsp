<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="m-5">
		<h1>
			<c:out value="${product.name}" />
			<!-- Mostrar el nombre del producto -->
		</h1>
		<h2>Categories:</h2>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<!-- Iterar sobre la lista "categories" -->
				<li><c:out value="${category.name}" /></li>
				<!-- Mostrar el nombre de la categoría -->
			</c:forEach>
		</ul>
		<form:form accept-charset="UTF-8" action="/products/${product.id}"
			method="post" modelAttribute="category_product">
			<!-- Corregido el atributo "modelAttribute" a "category_product" -->
			<p>
				Add category: <select name="category.id" id="category">
					<!-- Cambiado a "category.id" -->
					<c:forEach items="${categories}" var="category">
						<!-- Iterar sobre la lista "categories" -->
						<option value="${category.id}">${category.name}</option>
						<!-- Mostrar el nombre de la categoría y su ID como valor -->
					</c:forEach>
				</select>
			</p>
			<input type="hidden" name="product.id" value="${product.id}" />
			<!-- Agregar un campo oculto para el ID del producto -->
			<input id="create2" type="submit" value="Add" />
		</form:form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>