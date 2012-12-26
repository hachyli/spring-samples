package com.sivalabs.blogosphere.repositories;

import java.util.List;

import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;

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
	
	void createBlogPost(Post post);
	Post getPostById(Integer postId);
	void createPostComment(Comment comment);
	List<Blog> getUserBlogs(Integer userId);
}
