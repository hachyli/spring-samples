<%@include file="taglib.jsp"%>

<script type="text/javascript">
$(function() {
	$( "#datepicker" ).datepicker({
		changeMonth: true,
		changeYear: true
	});
});
</script>
<center>
	<table style="border-collapse: collapse; border="1" bordercolor="#006699" height="500">
		<tbody>
			<tr>
				<td align="center"><h3>User Registration Form</h3></td>
			</tr>
			<tr valign="top" align="center">
				<td align="center">
				<form:form action="createUser" commandName="newUser" method="post">
					<table style="border-collapse: collapse; width: 500px;" border="0"
						bordercolor="#006699" cellpadding="2" cellspacing="2">
						<tbody>							
							<tr>
								<td width="100" align="right">UserName </td>
								<td><form:input path="userName"></form:input>
								<form:errors cssStyle="color:red" path="userName"/></td>
							</tr>
							<tr>
								<td width="100" align="right">Password </td>
								<td><form:password path="password"></form:password>
								<form:errors cssStyle="color:red" path="password"/></td>
							</tr>							
							<tr>
								<td width="100" align="right">FirstName </td>
								<td width="150"><form:input path="firstName"></form:input>
								<form:errors cssStyle="color:red" path="firstName"/></td>
							</tr>
							<tr>
								<td width="100" align="right">LastName </td>
								<td width="150"><form:input path="lastName"></form:input>
								<form:errors cssStyle="color:red" path="lastName"/></td>
							</tr>
							<tr>
								<td width="100" align="right">Email </td>
								<td><form:input path="emailId"></form:input>
								<form:errors cssStyle="color:red" path="emailId"/></td>
							</tr>						
							<tr>
								<td width="100" align="right">DOB </td>
								<td><input type="text" id="datepicker" name="dob">
								<form:errors cssStyle="color:red" path="dob"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
								<input name="" value="Register" type="submit" class="btn"> 									
									<input onclick="javascript:go('login');" 
									value="Cancel" type="button" class="btn">
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
				</td>
			</tr>
		</tbody>
	</table>
</center>