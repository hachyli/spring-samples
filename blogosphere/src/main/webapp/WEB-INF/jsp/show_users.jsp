<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	
    <script type="text/javascript">

    $(document).ready(function() {
    	//$('#loadUsersBtn').click(function () 
    	//{
	    	$.getJSON('http://localhost:8080/phonebook-rest-services/services/users/', function (data){
	    	var usersTblHtml="<table class='table table-condensed table-hover table-bordered'><tr><td>UserId</td><td>UserName</td></tr>";
	    	$.each(data, function(i,rec){
	    		usersTblHtml+="<tr><td><a href='showUser?userId="+rec["userId"]+"'>"+rec["userId"]+"</a></td>"+
	    		"<td>"+rec["userName"]+"</td></tr>";
	    	});
	    	usersTblHtml+="</table>";
	    	$('#usersDiv').html(usersTblHtml);
	    	});
	    	return false;
	    	//});
    	});
	</script>
</head>
<body>
 	
	<h1>ShowUsers!!</h1> 
	<div id="usersDiv">
	</div>

</body>
</html>