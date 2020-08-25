<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
        src="webjars/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript" src="js/ajax.js"></script>

</head>

<body>
	<h2>View Account Details</h2>
	<div>
		Select Role : <select name="role">
			<c:forEach items="${roles}" var="name">
				<option value="${name}">${name}</option>
			</c:forEach>
		</select>
	</div><br><br>

	<table border="1">
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
					<td>${c.fname}${c.lname}</td>
					<td>${c.email}</td>
					<td><a href="editAccount?accId=${c.accId}">Edit</a> <c:if
							test="${c.isDeleted eq 'Y'}">
							<a href="deleteAccount?accId=${c.accId}">Delete</a>
						</c:if> <c:if test="${c.isDeleted eq 'N'}">
							<a href="deleteAccount?accId=${c.accId}&update=true">Activate</a>
						</c:if></td>

				</tr>

			</c:forEach>
		</tbody>

	</table>
</body>
</html>