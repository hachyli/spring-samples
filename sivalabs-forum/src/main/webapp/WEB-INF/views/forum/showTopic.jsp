<%@include file="../taglib.jsp"%>
<p> 
	<a href="${contextRoot}forums/">Forums Home</a> >>
	<a href="${contextRoot}forums/${sessionScope.currentForum.forumId}/">${sessionScope.currentForum.forumName}</a>
</p>
<a href="${contextRoot}forums/${topic.forum.forumId}/topics/?newTopic">New Topic</a>
<p>Topic Tile: ${topic.title}</p>
<a href="${topic.topicId}/reply">Reply</a><br/>
<hr color="blue" width="100%"/>

<table  width="100%">
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