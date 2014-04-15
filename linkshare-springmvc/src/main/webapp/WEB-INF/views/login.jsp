<%@include file="taglib.jsp"%>
<html>
<head>
	<style>
		
		label, input { display:block; }
		
	</style>
	<script>
	$(function() {
		$( "input:submit" ).button();
		
		$("#loginForm").submit(function(e){
			  var username = $.trim($("#username").val());
			  var pwd = $.trim($("#password").val());
			 if(username=="" || pwd=="")
			 {
				e.preventDefault();
				$('<div />').html('Please enter UserName and Password').dialog({
					//autoOpen: false,
					modal: true,
					title: "Error",
					height: 180,
					width: 300,
					resizable : false,
					buttons: {
						Ok: function() {
							$( this ).dialog( "close" );
						}
					}
				});
			 }
		});
		
	});
	</script>
</head>
<body>
	<div style="width:300px; margin-right:auto; margin-left:auto; border:1px solid #000; border-radius: 5px;">
	
	<form:form action="login.htm" commandName="userLogon" method="post" id="loginForm">
		
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">UserName </td>
					<td><form:input path="username" title="UserName"/>
					</td>
				</tr>
				
				<tr>
					<td width="100" align="right">Password </td>
					<td><form:password path="password"/></td>
				</tr>				
				<tr>
					<td>&nbsp;</td>
					<td  width="100" align="right">
						<input name="" value="Login" type="submit">						
					</td>					
				</tr>
				<tr>
					<td colspan="2">
					<form:errors cssStyle="color:red" />					
					</td>
				</tr>				
			</tbody>
		</table>
	</form:form>
	</div>
	
</body>
</html>
