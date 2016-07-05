<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<title>LifeTimeKids</title>
</head>
<body>
	<h1>Welcome to LifeTimeKids</h1>
	
	<h3>Crianças cadastradas</h3>
	<c:forEach items="${children}" var="child">
		<li>
			<div>
				<a href="/child/show/${child.id}">${child.name}</a>
				<span>${child.birthday}</span>
			</div>
		</li>
	</c:forEach>
</body>
</html>
