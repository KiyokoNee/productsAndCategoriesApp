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
		<title>Category Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css" />
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1><c:out value="${category.name}"></c:out></h1>
		<a href="/">Home</a>
		<hr>
		<h2>Products</h2>
		<ul>
			<c:forEach var="product" items="${categoryproducts}">
				<li><c:out value="${product.name}"></c:out></li>
			</c:forEach>
		</ul>
		<hr>
		<form:form action="/categories/${category.id}/add" method="put">
			<label>
				Categories
				<select id="productId" name="productId">
					<c:forEach var="product" items="${otherproducts}">
						<option value="${product.id}"><c:out value="${product.name}"></c:out></option>
					</c:forEach>
				</select>
			</label>
			<button type="submit">Add</button>
		</form:form>
	</body>
</html>