package com.sivalabs.blogosphere.repositories;

import java.util.List;

import com.sivalabs.blogosphere.domain.Blog;

/**
 * @author Siva
 *
 */
public interface BlogRepository
{
	void createBlog(Blog blog);
	boolean blogNameExists(String blogName);
	Blog getBlogById(Integer blogId);
	List<Blog> getAllBlogs();
	List<Blog> getUserBlogs(Integer userId);
	
}
