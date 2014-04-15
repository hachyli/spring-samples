<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>

	<form:form method="post" action="changePwd.htm" commandName="changePwd">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>Change Password</b></legend>
		<table>
			<tr>
				<td>Current Password</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="password" name="newPwd"></td>
			</tr>
			<tr>
				<td>Retype Password</td>
				<td><input type="password" name="retypePwd"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>