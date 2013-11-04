/**
 * 
 */
package com.sivalabs.blogosphere.web.views;

import java.util.List;

import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.User;

/**
 * @author Siva
 *
 */
public class UserAccountView 
{
	private User user;
	private List<Blog> allBlogs;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setAllBlogs(List<Blog> allBlogs) {
		this.allBlogs = allBlogs;
	}
	public List<Blog> getAllBlogs() {
		return allBlogs;
	}
}
