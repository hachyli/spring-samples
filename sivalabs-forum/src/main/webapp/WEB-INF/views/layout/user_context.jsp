 <table width="100%" bgcolor="#4682B4" height="20" style="color: #ffffff" border="0">
 <tr>
 <td align="right">
 <%
 	if(session.getAttribute("LOGGEDIN_USER") != null)
 	{ %>
 		<span class="menu_link"><a href="logout.do">Logout</a></span>
 	<%}
 	else
 	{ %> 	
 	
	<a class="bgVisibleLink" href="login.do">Login</a> | 
	<a class="bgVisibleLink" href='createUser.do'>Register</a>
	
	
	<!--  <form action="login.do" method="post">
		UserName <input type="text" name="userName">
		Password <input type="password" name="password">
		<input type="submit" value="Login" class="btn">
		<input type="button" value="Register" onclick="javascript:go('createUser.do');" class="btn">
	</form>
	 -->
	 
 	<%}
 %>
 </td>
 </tr>
 </table>
