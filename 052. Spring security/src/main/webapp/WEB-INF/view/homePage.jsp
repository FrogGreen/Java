<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>052. Spring security</title>
</head>

<body>
	<h2>Spring Security - Home Page</h2>
	<hr>
	Welcome on this website
	<hr>
	<security:authorize access="hasRole('none')">
		<p>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
			</form:form>
		</p>
	</security:authorize>
	<security:authorize access="!hasRole('none')">
		<p>
			<a href="${pageContext.request.contextPath}/login">Login Panel</a>
		</p>
	</security:authorize>
</body>
</html>