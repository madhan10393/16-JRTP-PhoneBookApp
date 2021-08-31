<%@page import="com.ashokit.entity.ContactInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook-WebApplication</title>

<script type="text/javascript">
	function deleteContact() {
		alert("are you sure conform to delet?, if yes click ok.");
	}
</script>
</head>
<body>
	<div align="center">
		<a href="contact">AddContacts</a>
		<table border="1" style="align-content: center;">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Number</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody style="text-align: center;">
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.contactName}</td>
						<td>${contact.contactEmail}</td>
						<td>${contact.contactNumber}</td>
						<td><a href="edit?cid=${contact.contactId}">edit</a>&nbsp;&nbsp;&nbsp;
						    <a href="delete?cid=${contact.contactId}" onclick="return deleteContact()">delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>