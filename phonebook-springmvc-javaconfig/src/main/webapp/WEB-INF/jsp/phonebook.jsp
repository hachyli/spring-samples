<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">

	function newContactForm()
	{
		document.forms[0].action="newContactForm.htm";
		document.forms[0].submit();
	}

	function doDeleteContact(contactId)
	{
		var ok = confirm("Are you sure to delete?");
		if(ok)
		{
			document.forms[0].action="deleteContact.htm?contactId="+contactId;
			document.forms[0].submit();
		}
	}
</script>
<script type="text/javascript">
 $(document).ready(function(){
	 $(".stripeMe tr:odd").addClass("odd");
 });
 </script>
</head>
<body>
	<form:form method="post" action="searchContacts.htm">
		<div class="error">
			<form:errors path="*"></form:errors>
			${MSG} 
		</div>
		<p>Enter Name : <input type="text" name="searchCriteria"> 
		<input type="submit" value="Search"> 
		<input type="button" value="Add New" onclick="javascript:newContactForm();">
		</p>
	</form:form>
	<div>
		<c:if test="${SEARCH_CONTACTS_REULTS != null }">
			<table class="stripeMe">
				<thead>
					<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					</tr>
				</thead>
			<tbody>
				<c:forEach items="${SEARCH_CONTACTS_REULTS}" var="contact">
				<tr>
					<td><a href="editContact.htm?contactId=${contact.contactId}">${contact.contactId}</a></td>
					<td>${contact.firstName}, ${contact.lastName}</td>
					<td>${contact.emailId}</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</c:if>
	
	</div>
</body>
</html>