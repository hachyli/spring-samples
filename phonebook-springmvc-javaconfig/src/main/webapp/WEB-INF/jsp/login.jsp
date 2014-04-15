<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form method="post" action="login.htm" commandName="user">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>Login</b></legend>
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
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
			<tr>
				<td colspan="2">Not Registered yet? <a href="registration.htm">Register</a></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>