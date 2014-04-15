/**
 * 
 */
package com.sivalabs.blogosphere.web.views;

/**
 * @author Siva
 *
 */
public class NewBlogForm 
{
	private String blogName;
	private String errorMsg;
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
