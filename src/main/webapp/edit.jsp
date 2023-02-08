<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="/script/script.js" defer></script>
<title>Burger Tiem</title>
</head>

<body>
	<div class="container bg-light rounded p-5">
		<h1 class="display-5">Edit ${burger.name}</h1>
		<form:form action="/burgers/edit/${burger.id}" method="POST" modelAttribute="burger">
			<input type="hidden" name="_method" value="PUT">
			<div class="form-group">
				<form:label path="name">Burger Name</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input class="form-control" path="name" type="text" />
			</div>
			<div class="form-group">
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:errors path="restaurant" class="text-danger" />
				<form:input class="form-control" path="restaurant" type="text" />
			</div>
			<div class="form-group">
				<form:label path="rating">Restaurant Name</form:label>
				<form:errors path="rating" class="text-danger" />
				<form:input class="form-control" path="rating" type="number" />
			</div>
			<button type="submit" class="btn btn-primary btn-block my-2">Submit</button>
		</form:form>
	</div>
</body>
</html>