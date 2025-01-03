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
		<title>Home Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css" />
    	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1 class="text-center" >Home Page</h1>
		<div class="d-flex flex-column">
			<a href="/products/new">New Product</a>
			<a href="/categories/new">New Category</a>
		</div>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul>
							<c:forEach var="product" items="${products}">
								<li><a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
							<c:forEach var="category" items="${categories}">
								<li><a href="/categories/${category.id}"><c:out value="${category.name}"></c:out></a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>