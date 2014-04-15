<%@include file="taglib.jsp" %>

<head>
	<script type="text/javascript">
		$(document).ready(function(){
			
			
			$("#saveBtn").click(function(){
					var userJson = {
						firstname : $('#firstname').val(),
						lastname : $('#lastname').val(),
						email : $('#email').val()
					};
				  $.post("createUser", userJson, function(result){
					  if(result.success)
					  {
						alert("Created Successfully");
						window.location.replace("page?view=showUsers");
					  }
					  else
					  {
						  alert("Some error occured while creating user.");
					  }
				    
				  });
				  return false;
			});
			
			$("#cancelBtn").click(function(){
				window.location.replace("page?view=showUsers");
			});
		});
	</script>
</head>

<form action="createUser" method="post">
		<table>					
			<tr>
				<td width="100" align="right">FirstName</td>
				<td><input type="text" name="firstname" id="firstname"></td>
			</tr>
			
			<tr>
				<td width="100" align="right">LastName</td>
				<td><input type="text" name="lastname" id="lastname"></td>
			</tr>
			<tr>
				<td width="100" align="right">Email</td>
				<td><input type="text" name="email" id="email"></td>						
			</tr>
			
			<tr valign="bottom">
				<td colspan="3" align="center">
				<input type="button" id="saveBtn" name="saveBtn" value="Save">						
				&nbsp;&nbsp;
				<input type="button" id="cancelBtn" value="Cancel">
				</td>
			</tr>
			
		</table>				
</form>
