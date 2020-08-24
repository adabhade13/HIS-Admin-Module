<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h2>Account Details</h2>
	<table>
		<thead>
			<tr>
				<th>Sr NO.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>

		</thead>
		<tbody>

			<c:forEach items="${accounts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.fname}</td>
					<td>${c.email}</td>
					<td><a href="editAccount?accId=${c.accId}">Edit</a> <c:if
							test="${c.isDeleted eqs N}">
							<a href="deleteAccount?accId=${c.accId}">Delete</a>
						</c:if> <c:if test="${c.isDeleted eqs Y}">
							<a href="deleteAccount?accId=${c.accId}">Activate</a>
						</c:if></td>

				</tr>

			</c:forEach>
		</tbody>

	</table>
</body>
</html>