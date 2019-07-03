<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Pizza via Annotations</title>
</head>

<body>
	<form:form action="pizzaViaAnnotationsConfirmation"
		modelAttribute="pizza">
	Street name: <form:input path="streetName" />
		<br>
	House number: <form:input path="houseNumber" />
		<br>
	London district:
		<form:select path="cityDistrict">
			<form:option value="Westminster" />
			<form:option value="Bromley" />
			<form:option value="Newham" />
			<form:option value="Barking and Dagenham" />
			<form:option value="Sutton" />
			<form:option value="Ealing" />
		</form:select>
		<br>
	Pizza dough:
		<br>
		Thin <form:radiobutton path="pizzaDough" value="Thin crust" />
		Medium <form:radiobutton path="pizzaDough" value="Medium crust" />
		Thick <form:radiobutton path="pizzaDough" value="Thick crust" />
		<br>
	Topings:
		<br>	
		Cheese <form:checkbox path="toppings" value="Cheese" />
		Ham <form:checkbox path="toppings" value="Ham" />
		Pepperoni <form:checkbox path="toppings" value="Pepperoni" />
		Paprika <form:checkbox path="toppings" value="Paprika" />
		Tomato <form:checkbox path="toppings" value="Tomato" />
		Pineapple <form:checkbox path="toppings" value="Pineapple" />
		Corn <form:checkbox path="toppings" value="Corn" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>