<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<title>LifeTimeKids</title>
</head>
<body>
	<h1>Welcome to LifeTimeKids</h1>
	
	<h3>Criança cadastrada</h3>
	<div>
		<span>${child.name}</span>
		<span>${child.birthday}</span>
	</div>
</body>

</html>
