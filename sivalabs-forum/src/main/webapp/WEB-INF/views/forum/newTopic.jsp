<%@include file="../taglib.jsp"%>

<p> 

	
	<a href="${contextRoot}forums">Forums Home</a> >>
	<%-- <a href="forum.do?forumId=${sessionScope.currentForum.forumId}">${sessionScope.currentForum.forumName}</a> --%>
	<a href="${contextRoot}forums/${sessionScope.currentForum.forumId}/">${sessionScope.currentForum.forumName}</a>
	
</p>

<div>

<form:form action="" method="post" commandName="topic">
<form:hidden path="forum.forumId"/>
<table>
  <tr>
    <td>Title</td>
    <td><form:input path="title" size="50"/> </td>
  </tr>
  <tr>
    <td>Message</td>
    <td><form:textarea path="message" cols="50" rows="15"/> </td>
  </tr>
  <tr>
    <td colspan="2">
    	<input type="submit" value="Submit">
    </td>
  </tr>
  
</table>


</form:form>

</div>