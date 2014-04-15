<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<body>
	<form:form method="post" action="updateUser.htm" commandName="user">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>My Profile</b></legend>
		<form:hidden path="userId"/>
		<form:hidden path="password"/>
		<table>
			<tr>
				<td>UserName</td>
				<td><form:input path="userName" readonly="true"/></td>
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
				<td colspan="2">
					<input type="submit" value="Save">
				</td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>