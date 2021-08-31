<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook-WebApplication</title>
</head>
<body>
	<h2 style="text-align: center;">PhoneBook Web Application</h2>
	<div align="center">
		<font color="green">${success}</font>
		<font color="red">${failure}</font>
		<form:form action="savecontact?contactId=${contact.contactId}" modelAttribute="contact" method="POST">
			<table>
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><form:input path="contactName"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><form:input path="contactEmail"/></td>
				</tr>
				<tr>
					<td>Number</td>
					<td>:</td>
					<td><form:input path="contactNumber"/></td>
				</tr>
			</table><br>
			<input type="submit" value="SaveContact">
		</form:form>
		<br> <a href="viewcontacts">View All Contacts</a>
	</div>
</body>
</html>