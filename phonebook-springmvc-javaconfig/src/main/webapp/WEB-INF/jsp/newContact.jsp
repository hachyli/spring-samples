<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Contact</title>
<script type="text/javascript">

	
</script>
</head>
<body>
	<form:form method="post" action="saveContact.htm" commandName="Contact">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>New Contact</b></legend>
		<form:hidden path="contactId"/>
		<table>
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
				<td>Phone</td>
				<td><form:input path="phone"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save">
					<a href="searchContacts.htm">Back</a>
				</td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>