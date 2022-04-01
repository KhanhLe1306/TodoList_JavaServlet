<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<link type="text/css" rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="container">
		<header>
			<h1>Welcome to my TodoList application</h1>
		</header>
		<div class="app__container">
			<div class="button__container">
				<a href="/ServletDemo/addTodo.jsp"><button class="button">Add
						Todo</button></a>
			</div>
			<!-- Note: you can not pass an Object up from JSP to Servlet. We can only pass Object from Servlet to JSP to output -->
			<div class="app__content">
				<ul>
					<c:forEach var="todo" items="${todos}">

						<c:url var="updateLink" value="UpdateTodo">
							<!-- value here is the Servlet name -->
							<c:param name="todoId" value="${todo.id}" />
						</c:url>

						<c:url var="deleteLink" value="DeleteTodo">
							<!-- value here is the Servlet name -->
							<c:param name="todoId" value="${todo.id}" />
						</c:url>

						<li>
							<%-- 				<input type="hidden" name="title" required value="${todo}" />  --%>

							<span class="todo__title">${todo.title}</span> 
							<div class="links">
							<a class="link" href="${updateLink}">Update</a> 
							<a
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false;"
							href="${deleteLink}" class="link">Delete</a>
						</div>
						</li>

					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

	<%-- ${todo.title} : ${todo.done} --%>
</body>

</html>