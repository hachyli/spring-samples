<%@include file="taglib.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs:Login</title>

</head>
<body>

	<form:form action="login.htm" method="post" commandName="login">
		<c:if test="${errorMsg != null }">
		<span style="color: red">${errorMsg}</span>
		</c:if>
		
		<table style="border: 1; border-collapse: collapse;">
		  <tr>
		    <td>UserName*</td>
		    <td><form:input path="username"/> </td>
		    <td><form:errors path="username" cssClass="error"/> </td>
		  </tr>
		  <tr>
		    <td>Password*</td>
		    <td><form:password path="password"/> </td>
		    <td><form:errors path="password" cssClass="error"/> </td>
		  </tr>
		  <tr>
		  	<td colspan="2">
		  		<input type="submit" value="Login">
		  		New User? <a href="register.htm">Register</a>
		  	</td>
		  </tr>
		</table>

	</form:form>

</body>
</html>