<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Unlock Account Form</h3>

<p >
<font style="color: red">${errMsg}</font>
</p>

<p >
<font style="color: green">${succMsg}</font>
</p>

<form:form action="/updateUnlockAcc" modelAttribute="unlockAcc" method="POST">

<table>
   <tr>
   <td> Your Email ::</td>
   <td>${email}</td>
   </tr>
   
    <tr>
   <td>Enter Temporary Password ::</td>
   <td><form:password path="tempPwd"/></td>
   </tr>

   <tr>
   <td>Enter New Password ::</td>
   <td><form:password path="newPwd"/></td>
   </tr>

   <tr>
   <td>Comfirm new Password ::</td>
   <td><form:password path="confirmPwd"/></td>
   </tr>
   
    <tr>
   <td><input type="submit" value="Unlock"></td>
   </tr>


</table>

</form:form>
</body>
</html>