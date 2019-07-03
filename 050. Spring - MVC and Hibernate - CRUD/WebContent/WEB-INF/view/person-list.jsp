<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>List Person</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/content/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Person List Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempPerson" items="${persons}">
					<c:url var="updateLink" value="/character/showFormForUpdate">
						<c:param name="personId" value="${tempPerson.id}" />
					</c:url>
					<c:url var="deleteLink" value="/character/delete">
						<c:param name="personId" value="${tempPerson.id}" />
					</c:url>
					<tr>
						<td>${tempPerson.firstName}</td>
						<td>${tempPerson.lastName}</td>
						<td>${tempPerson.email}</td>
						<td><a href="${updateLink}">Update</a>| <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you shure you want to delete this person?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
			
			<div align="right">
				<input type="button" value="Add Person"
					onclick="window.location.href='showFormForAdd';return false;"
					class="add-button" />
			</div>
			</p>
		</div>
	</div>
</body>
</html>