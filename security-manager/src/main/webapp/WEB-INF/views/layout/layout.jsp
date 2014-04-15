<%@include file="../taglib.jsp" %>
<html>
<head>
<title><spring:message code="Application.Title"/></title>
	<link type="text/css" href="resources/css/styles.css" rel="stylesheet" />	
	<link type="text/css" href="resources/jquery/css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
	<script type="text/javascript" src="resources/jquery/js/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="resources/jquery/js/jquery-ui-1.8.16.custom.min.js"></script>
	<decorator:head/>
</head>
<body>
<div align="center">

<table class="layoutTbl" border='1'>
		<tbody>		  
		 <tr>
		 	<td colspan="2" height="70" class="header">
		 		<h2>User Management Tool</h2>
		 	</td>
		 </tr><%-- 	
		 <tr>
		 	<td colspan="2" height="20"  class="userBanner">
		 		<%@include file="userBanner.jsp" %>
		 	</td>
		 </tr> --%>			 
		 <tr>
		 	<td width="15%" valign="top">
		 		<p><a href="page?view=showUsers">Show All Users</a>
					<!-- <p><a href="page?view=newUser">Create User</a> -->
		 	</td>
		    <td width="85%" valign="top">
		    	<decorator:body/>
		    </td>
		 </tr>
		 <tr class="footer" height="25">
	    	<td colspan="2">
	    		<span>SivaLabs @ 2012. All rights reserved.</span>
	   		 </td>
		 </tr>
		</tbody>
	</table>
	</div>
</body>
</html>