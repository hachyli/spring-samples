<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form method="post" action="registration.htm" commandName="user">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>Registration</b></legend>
		<table>
			<tr>
				<td>UserName</td>
				<td><form:input path="userName"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td>FirstName</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td><form:input path="emailId"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
			<tr>
				<td colspan="2">Already Registered? <a href="login.htm">Login</a></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>