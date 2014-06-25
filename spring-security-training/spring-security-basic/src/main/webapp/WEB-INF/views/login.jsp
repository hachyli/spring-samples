<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="rootURL" value="/" />

<!DOCTYPE html>
<html>
<head>
<base href="${rootURL}">
<title>Default Login</title>
</head>
<body>

	<h2>Spring Security Login with default configuration</h2>
	<c:if test="${param.error != null}">
		<div style="color: red"><b> 
			Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
			</b> 
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div style="color: green"><b>You have been logged out.</b></div>
	</c:if>

	<form action="j_spring_security_check" method="post">
		<p>
			UserName: <input name="j_username">
		</p>
		<p>
			Password: <input type="password" name="j_password">
		</p>
		<p>
			<input type="submit" value="Login">
		</p>
	</form>

</body>
</html>