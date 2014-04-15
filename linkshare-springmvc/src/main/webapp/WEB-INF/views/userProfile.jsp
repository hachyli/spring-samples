<%@include file="taglib.jsp"%>
<html>
<head>
</head>
<body>
	 
	<form:form action="#" commandName="userProfile" method="post">
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">UserName* </td>
					<td><form:input path="userLogon.username"></form:input>
					<form:errors cssStyle="color:red" path="userLogon.username"/></td>
				</tr>
				<tr>
					<td width="100" align="right">Password* </td>
					<td><form:password path="userLogon.password"></form:password>
					<form:errors cssStyle="color:red" path="userLogon.password"/></td>
				</tr>
				<tr>
					<td width="100" align="right">FirstName </td>
					<td><form:input path="firstname"></form:input>
					<form:errors cssStyle="color:red" path="firstname"/></td>
				</tr>
				<tr>
					<td width="100" align="right">LastName</td>
					<td><form:input path="lastname"></form:input>
					<form:errors cssStyle="color:red" path="lastname"/></td>
				</tr>
				<tr>
					<td width="100" align="right">Email </td>
					<td><form:input path="email"></form:input>
					<form:errors cssStyle="color:red" path="email"/></td>
				</tr>						
				<tr>
					<td width="100" align="right">DOB(dd/MM/yyyy) </td>
					<td><input type="text" id="dob" name="dob">
					<form:errors cssStyle="color:red" path="dob"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	
	
	<h3>User Links</h3>
	<table style="border-collapse: collapse;" border="1">
		<tr bgcolor="lightblue" style="border: 1; border-collapse: collapse;">
			<th>Title</th>
			<th>URL</th>			
			<th>PostedBy</th>	
			<th>PostedOn</th>
			
		</tr>
		<c:if test="${empty USER_LINKS}">
		<tr>
			<td colspan="4">No Links found</td>
		</tr>
		</c:if>
		<c:if test="${! empty USER_LINKS}">
			<c:forEach var="link" items="${USER_LINKS}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td><c:out value="${link.title}"></c:out></td>
				<td><c:out value="${link.url}"></c:out></td>
				<td><c:out value="${link.postedBy.firstname}"></c:out> </td>
				<td><fmt:formatDate value="${link.postedOn}" pattern="dd/MM/yyyy hh:mm:ss"/></td>				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
	
</body>
</html>
