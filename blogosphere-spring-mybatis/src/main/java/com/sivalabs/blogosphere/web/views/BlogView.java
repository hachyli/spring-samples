/**
 * 
 */
package com.sivalabs.blogosphere.web.views;

import com.sivalabs.blogosphere.domain.Blog;

/**
 * @author Siva
 *
 */
public class BlogView 
{
	private Blog blog;
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Blog getBlog() {
		return blog;
	}
}
