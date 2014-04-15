<%@include file="taglib.jsp" %>

<head>
	<script type="text/javascript">
		$(document).ready(function(){
			var userId=$('#userId').val();
			$.get("getUserById?userId="+userId, function(result){
				if(result.success)
				  {
					var userJson = result.data;
					$('#userId').val(userJson.userId);
					$('#firstname').val(userJson.firstname);
					$('#lastname').val(userJson.lastname);
					$('#email').val(userJson.email);
				  }
				  else
				  {
					  alert("Some error occured while loading user details.");
				  }
			});
			
			$("#saveBtn").click(function(){
					var userJson = {
						userId : $('#userId').val(),
						firstname : $('#firstname').val(),
						lastname : $('#lastname').val(),
						email : $('#email').val()
					};
				  $.post("updateUser", userJson, function(result){
					  if(result.success)
					  {
						alert("Updated Successfully");
						window.location.replace("page?view=showUsers");
					  }
					  else
					  {
						  alert("Some error occured while updating user.");
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

<form action="updateUser" method="post">
		<table>					
			<tr>
				<td width="100" align="right">Id</td>
				<td width="150"><input type="text" name="userId" id="userId" value="${param.userId}" readonly="readonly"></td>
				
			</tr>
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
				<td colspan="2" align="center">
				<input type="button" id="saveBtn" name="saveBtn" value="Save">						
				&nbsp;&nbsp;
				<input type="button" id="cancelBtn" value="Cancel">
				</td>
			</tr>
			
		</table>				
</form>
