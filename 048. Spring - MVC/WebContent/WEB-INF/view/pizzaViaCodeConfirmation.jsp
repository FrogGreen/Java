<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Pizza via Code - Confirmation</title>
</head>

<body>
	Pizza will be delivered to: ${pizza.streetName} ${pizza.houseNumber},
	${pizza.cityDistrict}
	<br> It will be served on: ${pizza.pizzaDough}
	<br> With chosen toppings:
	<ul>
		<c:forEach var="temp" items="${pizza.toppings}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
	<br>
	<br>
	<a href="/Spring_-_MVC/">Back to home page</a>
</body>
</html>