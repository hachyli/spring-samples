/**
 * 
 */
package com.sivalabs.blogosphere.domain;

import java.util.Date;

/**
 * @author skatam
 *
 */
public class Comment 
{
	private Integer commentId;
	private String title;
	private String content;
	private Date createdOn;
	//private User createdBy;
	//private Post post;
	private Integer createdBy;
	private Integer postId;
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/*public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}*/
	public Integer getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy)
	{
		this.createdBy = createdBy;
	}
	public Integer getPostId()
	{
		return postId;
	}
	public void setPostId(Integer postId)
	{
		this.postId = postId;
	}
	
	
}
