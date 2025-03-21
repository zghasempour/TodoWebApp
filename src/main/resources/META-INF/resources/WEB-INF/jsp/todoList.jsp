 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>
			Todo List Page
		</title>
	</head>
	<body>
	<div class="container">
	<h1>Your Todo List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>Target date</th>
					<th>Complete</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach items="${todoList}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
				<a href="add-todo" class="btn btn-success">Add todo task</a>
		</div>
		<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>