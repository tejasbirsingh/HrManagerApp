<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:if test="${!empty failureMessage}">
	<div class="alert alert-danger" role="alert">${failureMessage}</div>
</c:if>
<c:if test="${!empty successMessage}">
	<div class="alert alert-primary" role="alert">${successMessage}</div>
</c:if>
