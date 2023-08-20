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
<title>Belt Exam - Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<style>

.title-center {
margin-left: 350px;
margin-right: 20px;
}

.center {
display: flex; 
flex-direction: column;
align-items: flex-start;

}
.registerForm {
	width: 100%;
	max-width: 275px;
	margin: 20px;
	padding: 30px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.loginForm {
	width: 100%;
	max-width: 300px;
	margin: 50px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

@media ( min-width : 768px) {
	body {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
	}
	.registerForm, .loginForm {
		margin: 0;
		padding: 40px;
	}
}
</style>
</head>
<body>
	<div class="title-center">
	<h1 class="display-2">Welcome to TV Shows Web! 📽️</h1>
	</div>
	<div class="container d-flex justify-content-center">

	<div class="row">
	<div class="col registerForm">
		<h2>Register</h2>
		<form:form accept-charset="UTF-8" action="/registration" method="post"
			modelAttribute="user">

			<p class="center">
				<form:label path="name">Name: </form:label>
				<form:input path="name" />
				<form:errors class="text-warning" path="name" />
			</p>
			<p class="center">
				<form:label path="email">Email: </form:label>
				<form:input path="email" />
				<form:errors class="text-warning" path="email" />
			</p>
			<p class="center">
				<form:label path="password">Password: </form:label>
				<form:input type="password" path="password" />
				<form:errors class="text-warning" path="password" />
			</p>
			<p class="center">
				<form:label path="passwordConfirmation">Password confirmation: </form:label>
				<form:input type="password" path="passwordConfirmation" />
				<form:errors class="text-warning" path="passwordConfirmation" />
			</p>
			<input type="submit" class="btn btn-primary" value="Register" />
			<p class="text-success">
				<c:out value="${success}" />
			</p>
		</form:form>
	</div>

	<div class="m-5 loginForm">
		<h3>Login</h3>
		<form method="post" action="/login">
			<p>
				<label for="email">Email: </label> <input type="text" id="email"
					name="email" />
			</p>
			<p>
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" />
			</p>
			<input type="submit" class="btn btn-primary" value="Login" />
		</form>
		<p class="text-warning">
			<c:out value="${error}" />
		</p>
	</div>
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>