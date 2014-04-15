<%@include file="taglib.jsp"%>
<html>
<head>
</head>
<body>
	
	<form:form action="postLink.htm" commandName="newLink" method="post">
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">Title* </td>
					<td><form:input path="title"></form:input>
					<form:errors cssStyle="color:red" path="title"/></td>
				</tr>
				<tr>
					<td width="100" align="right">URL* </td>
					<td><form:input path="url"></form:input>
					<form:errors cssStyle="color:red" path="url"/></td>
				</tr>
				<tr>
					<td colspan="2" align="left">
						<input name="" value="Submit" type="submit">						
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
				
</body>
</html>
