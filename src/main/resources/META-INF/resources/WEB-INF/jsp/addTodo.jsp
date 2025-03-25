<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>
			New Todo Page
		</title>
	</head>
	<body>
	<div class="container">
	<h1>Enter Task Details </h1>
	<form:form method="post" modelAttribute="todo">
		Description :<form:input type="text" path="description" required="required"/>
		<form:errors  path="description" cssClass="text-warning"/>
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<input type="submit" class="btn btn-success"/>
	</form:form>
	</div>
	</body>
</html>