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
	<h1>New Event</h1>
	<sf:form method="POST" action="/child/{id}/events/save" commandName="event">
		<sf:errors path="*" element="div" cssClass="error"/>
		<div>
			<sf:label path="message" cssErrorClass="error">Message</sf:label> 
			<sf:input path="message" cssErrorClass="error"/>
		</div>
		
		<div>
			<sf:label path="date" cssErrorClass="error">Data</sf:label> 
			<sf:input path="date" cssErrorClass="error"/>
		</div>
		
		<input type="submit" value="Post">
	</sf:form>
</body>

</html>
