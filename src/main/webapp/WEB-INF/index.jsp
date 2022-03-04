<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		
		<div class="container">

		<h1>Save Travels</h1>
	
		<table class="table">
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions<th>
			</tr>
			
			<c:forEach var="expense" items="${expenses}">
			
				<tr>
					<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>$<c:out value="${expense.amount}"/></td>
					<td><a href="/edit/<c:out value="${expense.id}"/>">edit</a> 
					<form action="/expenses/${expense.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn-danger">
					</form>
					</td>
				</tr>
			
			</c:forEach>
		
		</table>
		
		<h2>Add an Expense:</h2>
		
		<form:form action="/create" method="post" modelAttribute="expense">		
			<div class="row mb-3">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control"/> 
			</div>
			
			<div class="row mb-3">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor"/>
				<form:input path="vendor" class="form-control"/> 
			</div>
			
			<div class="row mb-3">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount"/>
				<form:input type="number" path="amount" step="0.01" class="form-control"/>
			</div>
			
			<div class="row mb-3">
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:textarea path="description" class="form-control" id="floatingTextarea"/>
			</div>
			
			<input type="submit" value="Submit" class="btn-primary"/>	
		</form:form>		
	</div>
		
	</body>
</html>