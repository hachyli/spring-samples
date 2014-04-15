<%@include file="../taglib.jsp"%>

<p> 
	<a href="${contextRoot}forums">Forums Home</a> >> ${forum.forumName}
</p>
<p> 
	<a href="${contextRoot}forums/${forum.forumId}/topics?newTopic">New Topic</a>
</p>

<table class="bodyText"  width="100%">  
	<thead bgcolor="#B0C4DE">
		<th class="bigText">Topic</th>
		<th class="bigText">Topic Starter</th>
		<th class="bigText">Replies</th>
		<th class="bigText">Last Post</th>		
	</thead>
	<c:forEach var="topic" items="${forum.topics}">
	 <tr>
	    <td> <a href="${contextRoot}forums/${forum.forumId}/topics/${topic.topicId}">${topic.title}</a></td>
	    <td>${topic.startedBy.firstName}</td>
	    <td>${topic.repliesCount}</td>
	    <td>${topic.lastPostDescription}</td>
	  </tr>
	</c:forEach>
</table>