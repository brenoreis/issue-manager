<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>
		<spring:message code="category.create" />
	</h1>
	<a href="<spring:url value="/category_list.html" />"><spring:message
			code="category.list" /></a>
	<form:form method="POST" action="/category_create.html"
		modelAttribute="form">
		<form:errors path="" element="div" />
		<div>
			<form:label path="name">
				<spring:message code="category.name" />
			</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="description">
				<spring:message code="category.description" />
			</form:label>
			<form:password path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<input type="submit" />
		</div>
	</form:form>
</body>
</html>