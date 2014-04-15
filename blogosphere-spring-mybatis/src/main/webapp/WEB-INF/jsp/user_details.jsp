<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	
    <script type="text/javascript">
    
    function getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
    }
    
    $(document).ready(function() {
    	
    	var userId = getURLParameter('userId');
    	if(userId ==null || userId == undefined || userId == '') {
			alert('No User Details found!!');
        } else {
	    	$.getJSON('http://localhost:8080/phonebook-rest-services/services/users/'+userId, function (rec){
	    	$('#inputUserId').val(rec["userId"]);
	    	$('#inputUserName').val(rec["userName"]);
	    		
	    	});
	
	    	$.getJSON('http://localhost:8080/phonebook-rest-services/services/users/'+userId+'/contacts', function (data){
	    	var contactsTblHtml="<table class='table table-condensed table-hover table-bordered'>"+
		    					"<tr><td>ContactId</td><td>Name</td>"+
		    					"<td>Mobile</td><td>Email</td></tr>";
		    					
	    	$.each(data, function(i,rec){
	    		contactsTblHtml+="<tr><td>"+rec["contactId"]+"</td><td>"+rec["name"]+"</td>";
	    		contactsTblHtml+="<td>"+rec["mobile"]+"</td><td>"+rec["email"]+"</td></tr>";
	    	});
	    	contactsTblHtml+="</table>";
	    	$('#userContactsDiv').html(contactsTblHtml);
	    	});
        }

    	$('#updateUserBtn').click(function(e) {

    		var form = $('#userForm');
    		var formData = form.serialize();
    		
    		alert(formData);
   		    $.ajax( {
   		      type: "PUT",
   		      url: 'http://localhost:8080/phonebook-rest-services/services/users/',
   		      data: formData,
   		      success: function( response ) {
   		       // console.log( response );
      		       alert(response);
   		      }
   		    } );

    		e.preventDefault();
    	});
    	

    	
    	return false;
    	});
    
	</script>
</head>
<body>

	<h1>Show User Details!!</h1>
	
	<div id="userDiv">
		<form id="userForm" class="form-horizontal" action="#">
			
			<div class="control-group">
				<label class="control-label" for="inputUserId">UserId</label>
				<div class="controls">
					<input type="text" id="inputUserId" name="userId" placeholder="UserId" readonly="readonly">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputUserName">UserName</label>
				<div class="controls">
					<input type="text" id="inputUserName" name="userName" placeholder="UserName">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn" id="updateUserBtn">Save</button>
				</div>
			</div>
		</form>
	</div>
	
	<div id="userContactsDiv">
	
	</div>

</body>
</html>