<%@include file="../taglib.jsp"%>

<p> 
	<a href="${contextRoot}forums">Forums Home</a> >>
	<%-- <a href="forum.do?forumId=${sessionScope.currentForum.forumId}">${sessionScope.currentForum.forumName}</a> --%>
	<a href="${contextRoot}forums/${sessionScope.currentForum.forumId}/">${sessionScope.currentForum.forumName}</a>
	
</p>

<div>

<form:form action="reply" method="post" commandName="post">
<form:hidden path="topic.topicId"/>
<table>
  <tr>
    <td>Title</td>
    <td><form:input path="title" size="50"/> </td>
  </tr>
  <tr>
    <td>Message</td>
    <td><form:textarea path="message" cols="50" rows="15" /> </td>
  </tr>
  <tr>
    <td colspan="2">
    	<input type="submit" value="Submit">
    </td>
  </tr>
  
</table>
</form:form>
<hr color="blue" width="100%"/>
<table width="100%">
	<c:forEach var="post" items="${topic.posts}">
	 <tr>
	    <td> 
	    	<p>Title: ${post.title}</p>	
	    	<p>Message: ${post.message}</p>	     	
	    	<p>Posted By : ${post.postedBy.firstName}</p>
	    	<p>Posted On : ${post.postedOn}</p>
	    </td>
	  </tr>
	  <tr>
	  <td>
	  <hr color="blue" width="100%"/>
	  </td>
	  </tr>
	</c:forEach>
</table>
</div>