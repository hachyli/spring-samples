<%@include file="taglib.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs:Registration</title>
</head>
<body>
	
	<form:form action="register.htm" method="post" commandName="registration">
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
		    <td>FirstName*</td>
		    <td><form:input path="firstname"/> </td>
		    <td><form:errors path="firstname" cssClass="error"/> </td>
		  </tr>
		  <tr>
		    <td>LastName</td>
		    <td><form:input path="lastname"/> </td>
		  </tr>
		  <tr>
		  	<td colspan="2">
		  		<input type="submit" value="Register">
		  	</td>
		  </tr>
		</table>

	</form:form>
	
</body>
</html>