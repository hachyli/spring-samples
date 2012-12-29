/**
 * 
 */
package com.sivalabs.blogosphere.web.views;

import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;

/**
 * @author Siva
 *
 */
public class PostView {
	private Post post;
	private Comment newComment = new Comment();
	private String errorMsg;
	public void setPost(Post post) {
		this.post = post;
	}
	public Post getPost() {
		return post;
	}
	public void setNewComment(Comment newComment) {
		this.newComment = newComment;
	}
	public Comment getNewComment() {
		return newComment;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
