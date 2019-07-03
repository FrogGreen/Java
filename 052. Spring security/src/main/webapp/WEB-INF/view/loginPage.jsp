<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>052. Spring security</title>
</head>

<body>
	<h2>Spring Security - Login Page</h2>
	<hr>
	<form:form action="${pageContext.request.contextPath}/authenticate"
		method="POST">
		<c:if test="${param.error != null}">
			<i class="failed">Wrong username or password.</i>
		</c:if>
		<p>
			User: <input type="text" name="username" />
		</p>
		<p>
			Pass: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>