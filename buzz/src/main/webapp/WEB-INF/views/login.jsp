<?xml version="1.0" ?>
<%@ include file="taglib.jsp"%>

<c:set var="pageTitle" value="Please Login" scope="request" />
<c:url value="/j_spring_security_check" var="loginUrl" />

<form:form action="${loginUrl}" method="post" modelAttribute="user">

	<c:if test="${param.error != null}">
		<div class="alert alert-error">
			Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
		</div>
	</c:if>
	
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">You have been logged out.</div>
	</c:if>
	
	<label for="username">UserName</label> 
	<form:input path="userName" id="username" />
	<label for="password">Password</label> 
	<form:password path="password" id="password"/>
	<div class="form-actions">
		<input id="submit" class="btn" name="submit" type="submit"
			value="Login" />
	</div>
	
</form:form>
