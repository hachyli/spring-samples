<%@include file="../taglib.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs:Show Contacts</title>
</head>
<body>
	<div align="center">
	<table class="dataTable">
		<tbody>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
			<c:if test="${CONTACTS_KEY != null}">
				<%
					String rowClass = "even";
				%>
				<c:forEach var="contact" items="${CONTACTS_KEY}">
				
					<%
						if(rowClass.equalsIgnoreCase("even")){
							rowClass = "odd";
						} else{
							rowClass ="even";
						}
					%>
					<tr class="<%=rowClass%>">
						<td>${contact.id}${rowClass}</td>
						<td>${contact.firstname} ${contact.lastname}</td>
						<td>${contact.emailId}</td>
						<td>${contact.phone}</td>
					</tr>
					<c:if test="${rowClass eq 'odd' }">
						<c:set var="rowClass" value="even"></c:set>
					</c:if>	
				</c:forEach>
			</c:if>			
		</tbody>
	</table>
	
	</div>
</body>
</html>