<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<html lang="en">
<head>
<title>LifeTimeKids</title>
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Events from child</h1>

	<c:forEach items="${events}" var="event">
		<li>
			<div>
				<a href="/child/${child.id}/event/show/${event.id}">${event.message}</a>
				<span>${event.date}</span>
			</div>
		</li>
	</c:forEach>
</body>
</html>
