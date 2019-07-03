<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Form validation - Confirmation</title>
</head>

<body>
	Dear guest welcome!
	<br> Your name is: ${guest.firstName } ${guest.lastName }
	<br> You are ${guest.age } years old
	<br> You are from: ${guest.postalCode }
	<br> Your validation code is: ${guest.validationCode }
	<br>
	<br>
	<a href="/Spring_-_MVC/">Back to home page</a>
</body>
</html>