<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>052. Spring security</title>
</head>

<body>
	<h2>Spring Security - Admin Page</h2>
	<hr>
	Welcome on this website
	<hr>
	<p>
		Admin:
		<security:authentication property="principal.username" /><br>
		Role(s):
		<security:authentication property="principal.authorities" /><br>
	</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/user">User Panel</a>
	</p>
	<hr>
	<security:authorize access="!hasRole('tester')">
		<p>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
			</form:form>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('tester')">
		<p>
			<a href="${pageContext.request.contextPath}/tester/testerPanel">Back to Tester Page</a>
		</p>
	</security:authorize>
</body>
</html>