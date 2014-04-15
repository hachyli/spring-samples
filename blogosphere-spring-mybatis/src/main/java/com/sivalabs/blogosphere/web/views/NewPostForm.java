/**
 * 
 */
package com.sivalabs.blogosphere.web.views;

import com.sivalabs.blogosphere.domain.Post;

/**
 * @author Siva
 *
 */
public class NewPostForm {

	private Post post = new Post();
	private String tags;
	private String errorMsg;
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}
