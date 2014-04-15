<%@include file="taglib.jsp" %>
<head>
	<script type="text/javascript">
	
	var deleteUser = function(userId)
	{
		var ok = confirm('Are you sure?');
		if(ok)
		{
				$.post("deleteUser", {userId : userId}, function(result){
				  if(result.success)
				  {
					alert("Deleted Successfully");
					window.location.replace("page?view=showUsers");
				  }
				  else
				  {
					  alert("Some error occured while deleting user.");
				  }
			    
			  });
			  
		}
		return false;	
	};
	
		$(document).ready(function(){
			
			
			var loadUsersData = function(usersJsonArray)
			{
				var usersTable = $("#usersTbl tbody");
				$(usersJsonArray).each(function(index, record){
					//alert(record.userId+":"+record.firstname);
					usersTable.append($('<tr>').append($('<td>').html(record.userId))
											   .append($('<td>').html(record.firstname))
											   .append($('<td>').html(record.email))
											   .append($('<td>').html('<a href="page?view=editUser&userId='+record.userId+'">Edit</a> &nbsp;&nbsp;' 
											   +'<a href="#" onclick="javascript:deleteUser('+record.userId+');">Delete</a>'))
							
					);
					
				});
			};
			
			$("#searchBtn").click(function(){
					
				$('#usersTbl tbody').children( 'tr').remove();
				  $.get("searchUsers",{searchName : $('#searchName').val() }, function(result){
					  if(result.success)
					  {
						var usersJson = result.data;
						loadUsersData(usersJson);
					  }
					  else
					  {
						  alert("Some error occured while searching for users.");
					  }
				    
				  });
				  return false;
			});
			
			$("#newUserBtn").click(function(){
				window.location.replace("page?view=newUser");
			});
			
			$('#usersTbl tbody').children( 'tr').remove();
			$.get("getAllUsers", function(result){
				  if(result.success)
				  {
					var usersJson = result.data;
					loadUsersData(usersJson);
				  }
				  else
				  {
					  alert("Some error occured while searching for users.");
				  }
			    
			  });
		});
	</script>
</head>
	<form action="searchUsers" method="get">		
			<table>
			<tr>
				<td>Enter User Name</td> 
				<td><input type="text" name="searchName" id="searchName"/>
					&nbsp;&nbsp;<input type="button" id="searchBtn" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New User" id="newUserBtn"/>
			</td></tr>
		</table>
	</form>
	
	<table id="usersTbl" style="width: 800; border-collapse: collapse;" border="1">
		<thead>
		<tr bgcolor="#BBD1E6">
			<th width="75">Id</th>
			<th width="200">Name</th>			
			<th  width="200">Email</th>	
			<th  width="100">Edit / Delete</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>	
