<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h2>Edit an Expense:</h2>
		
		<form:form action="/expenses/${expense.id}" method="put" modelAttribute="expense" class="form">
			<div class="row mb-3">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" class="error"/>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			
			<div class="row mb-3">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="error"/>
				<form:input path="vendor" type="text" class="form-control"/>
			</div>
			
			<div class="row mb-3">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="error"/>
				<form:input path="amount" type="number" step="0.01" class="form-control"/>
			</div>
			
			<div class="row mb-3">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="error"/>
				<form:input path="description" type="text" class="form-control"/>
			</div>
			
			<input type="submit" value="Update" class="btn-primary"/>
			
		</form:form>
	</body>
</html>