<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Category</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css" />
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>New Category</h1>
		<a href="/">Home</a>
		<hr>
		<form:form modelAttribute="category" method="post" action="/categories/create">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><form:label path="name">Name:</form:label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</body>
</html>