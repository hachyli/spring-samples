<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	
	<script>
	$(function() {

		
		
		$("#saveBtn").click(function() {
			var form = $('#createUserForm');
			if($.trim($('#userName').val())==''){
				alert('Please enter UserName');
				return false;
			}
			if($.trim($('#password').val())==''){
				alert('Please enter Password');
				return false;
			}
			if($.trim($('#firstName').val())==''){
				alert('Please enter FirstName');
				return false;
			}
			form.submit();
			
	    });

		$(".delUserBtn").click(function() {
			var r=confirm("Are you sure to delete?");
			if (r==false)
			{
			  return;
			}
			
			var userId = $(this).attr('id').replace('user_','');
            //var data = {"userId":userId};
            //alert(userId);

            $.ajax({
                type: "DELETE",
                url: "deleteUser.htm?userId="+userId,
                //data: {"userId":userId},// "userId="+userId,
                success: function(msg){
                    //alert("Data Deleted: " + msg);
                    if(msg == 'success'){
						alert("User Deleted Successfully");
						window.location.replace("userhome.htm");
                    }else{
                    	alert("Unable to delete User");
                    }
                }
            });
            
		});
	    
	});

	
	</script>
</head>

<body>
	
	
	<c:if test="${not empty msg }">
			<div id="msg" class="alert alert-error">
				${msg}
			</div>
		</c:if>
	<form class="form-search" action="userhome.htm">
	  <strong>Search Users :</strong> <input type="text" name="query" class="search-query">
	  <button type="submit" class="btn btn-primary" id="searchBtn">Search</button>
	  <a href="createUser.htm" class="btn btn-info">Create New User</a>
	</form>
	<div>
		
		<table class="table table-hover  table-bordered">
			
				<tr class="success">
					<td>UserId</td>
					<td>UserName</td>
					<td>FirstName</td>
					<td>LastName</td>
					<td>EmailId</td>
					<td>Disabled</td>	
					<td>Edit / Delete</td>				
				</tr>
			
			<tbody>
				<c:if test="${empty  USERS}">
					<tr>
						<td colspan="7">
							<p>No Users Found</p>
						</td>
					</tr>
				</c:if>
				<c:if test="${USERS != null }">
					<c:forEach items="${USERS}" var="user">

						<tr>
							<td>
								<a href="updateUser.htm?userId=${user.userId}">${user.userId}</a>
							</td>
							<td>
								${user.userName}
							</td>
							<td>
								${user.firstName}
							</td>
							<td>
								${user.lastName}
							</td>
							<td>
								${user.emailId}
							</td>
							<td>
								${user.disabled}
							</td>
							<td>
								<a href="updateUser.htm?userId=${user.userId}" class="btn btn-primary">Edit</a>
								<button class="btn btn-danger delUserBtn" id="user_${user.userId}">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		
		
	</div>
</body>

</html>