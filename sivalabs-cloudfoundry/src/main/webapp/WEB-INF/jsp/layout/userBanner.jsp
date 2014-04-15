<%@page import="com.sivalabs.common.model.User"%>
<%@page import="com.sivalabs.common.model.UserContext"%>
<%@page import="com.sivalabs.common.web.util.UserContextUtil"%>
<span class="textLabel">
 <%
 	User user = UserContextUtil.getLoggedinUser(session);
 	if(user != null)
 	{  		
 	%>
 		Welcome <%=user.getFirstname()%> <%=user.getLastname()%> &nbsp; | <a class="link" href="logout.htm">Logout</a>
 	<%}
 	else
 	{ %> 	
 	
	<a class="link" href="login.htm">Login</a> | 
	<a class="link" href='register.htm'>Register</a>
	 
 	<%}
 %>
 </span>

