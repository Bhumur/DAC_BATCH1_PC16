<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="login" modelAttribute="objUser" method="POST">
		<spring:message code="login.username"/> : <form:input path="username"/><br/>
		<form:errors path="username" cssStyle="color:red"></form:errors>
		<spring:message code="login.password"/> : <form:password path="password"/><br/>
		<form:errors path="password" cssStyle="color:red"></form:errors>
		<form:button ><spring:message code="login.login"/></form:button>
	</form:form>
</body>
</html>