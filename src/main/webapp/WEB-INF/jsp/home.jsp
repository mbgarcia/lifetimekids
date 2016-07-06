<!DOCTYPE html>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<html>
<head>
	<title>Lifetime Kids</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen"/>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="btn-group">
		<button type="button" class="btn btn-success">This is a success button</button>
		<button type="button" class="btn btn-warning">This is a warning button</button>
		<button type="button" class="btn btn-danger">This is a danger button</button>
	</div>    
</body>
</html>