<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Pizza via Code</title>
</head>

<body>
	<form:form action="pizzaViaCodeConfirmation" modelAttribute="pizza">
	Street name: <form:input path="streetName" />
		<br>
	House number: <form:input path="houseNumber" />
		<br>
	London district:
		<form:select path="cityDistrict">
			<form:options items="${pizza.cityDistrictOptions}" />
		</form:select>
		<br>
	Pizza dough:
			<form:radiobuttons path="pizzaDough"
			items="${pizza.pizzaDoughOptions}" />
		<br>
	Topings:
		<br>
		<form:checkboxes path="toppings" items="${pizza.toppingsOptions}" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>