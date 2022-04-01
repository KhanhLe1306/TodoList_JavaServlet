<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="container">
	<div class="add__form-container">
		<h1 class="add__form-title">Update Todo here:</h1>
		<form  class="add__form" action="UpdateTodo" method="post">
			<!-- this does not work with post => create a param named "method" -->
			<input type="hidden" name="todoId" value="${todo.id}"> 
			<input
				type="hidden" name="method" value="post">
				<input
				type="text" class="add__input" autofocus name="title" value="${todo.title}" required />

			<button class="link add__button" type="submit">Update</button>
		</form>
	</div>
	</div>

</body>

</html>