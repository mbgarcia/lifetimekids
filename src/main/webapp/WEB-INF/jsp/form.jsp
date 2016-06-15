<!DOCTYPE html>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<html lang="en">
<head>
	<title>LifeTimeKids</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>New Child</h1>
	<sf:form method="POST" action="/save" commandName="child">
		<sf:errors path="*" element="div" cssClass="error"/>
		<div>
			<sf:label path="name" cssErrorClass="error">Nome</sf:label> 
			<sf:input path="name" cssErrorClass="error"/>
		</div>
		
		<div>
			<sf:label path="birthday" cssErrorClass="error">Data de nascimento</sf:label> 
			<sf:input path="birthday" cssErrorClass="error"/>
		</div>
		
		<input type="submit" value="Post">
	</sf:form>
</body>

</html>
