<%@include file="taglib.jsp" %>
<script type="text/javascript">

</script>
<center>
	<form:form action="login" method="post" commandName="login">
		<table>
			<tr>
				<td colspan="2"><span style="color: red">${ERROR}</span></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="userName"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login" class="btn">
					<input type="button" value="Register" onclick="javascript:gotoRegistration();" class="btn">
				</td>
			</tr>
		</table>
	</form:form>
</center>