<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin-Module</title>
</head>
<body>
 <h1> Account Details </h1>   
 
	<form:form action="saveAccount" modelAttribute="account"
		method="POST">
		<table border="1">
			<tr>
				<td>First Name :</td>
				<td><form:input path="fname" /></td>

			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lname" /></td>
			</tr>

			<tr>
				<td> Email :</td>
				<td><form:input path="email"/></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td>Male : <form:radiobutton path="gender" value="M" id="gender" />
				   Female : <form:radiobutton path="gender" value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<td>Role :</td>
				<td><form:select path="role">
						<form:option value="">--select--</form:option>
						<form:options items="${roles}"/>
				</form:select></td>

			</tr>
			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="Create"></td>
			</tr>
</table>
</form:form>
</body>
</html>