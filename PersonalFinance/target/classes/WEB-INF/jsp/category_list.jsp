<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<body>
    <h1><spring:message code="category.list" /></h1>
    <ul>
    <c:forEach items="${categories}" var="category">
        <li>
            <c:out value="${category.getId()}" />
        </li>
    </c:forEach>
    </ul>

    <a href="<spring:url value="/category_create.html" />"><spring:message code="category.create" /></a>
</body>
</html>