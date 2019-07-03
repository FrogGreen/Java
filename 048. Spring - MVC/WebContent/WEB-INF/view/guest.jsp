<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Form validation</title>
<style>
.error {color: red}
</style>
</head>

<body>
	<h2>Form validation in Spring!</h2>
	<hr>
	<form:form action="guestConfirmation" modelAttribute="guest">
		First name: <form:input path="firstName" />
		<br>
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		Age (*): <form:input path="age" />
		<form:errors path="age" cssClass="error" />
		<br>
		Postal code (*): <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br>
		Validation code (*): <form:input path="validationCode" />
		<form:errors path="validationCode" cssClass="error" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>