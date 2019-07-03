<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>052. Spring security</title>
</head>

<body>
	<h2>Spring Security - Tester Page</h2>
	<hr>
	Welcome on this website
	<hr>
	<p>
		Tester:
		<security:authentication property="principal.username" />
		<br> Role(s):
		<security:authentication property="principal.authorities" />
		<br>
	</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/user">User Panel</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/admin/adminPanel">Admin Panel</a>
	</p>
	<hr>
	<p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</p>
</body>
</html>