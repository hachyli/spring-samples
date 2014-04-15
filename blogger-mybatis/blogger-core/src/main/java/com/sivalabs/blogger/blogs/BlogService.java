/**
 * 
 */
package com.sivalabs.blogger.blogs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogger.domain.Blog;
import com.sivalabs.blogger.domain.Comment;
import com.sivalabs.blogger.domain.Post;

/**
 * @author Siva
 * 
 */
@Service
@Transactional
public class BlogService
{

	@Autowired
	private BlogMapper blogMapper;

	public List<Blog> selectBlogs()
	{
		return blogMapper.selectBlogs();
	}

	public Blog selectBlogById(int blogId)
	{
		return blogMapper.selectBlogById(blogId);
	}

	public List<Post> selectBlogPosts(int blogId)
	{
		return blogMapper.selectBlogPosts(blogId);
	}

	public List<Comment> selectPostComments(int postId)
	{
		return blogMapper.selectPostComments(postId);
	}

	public void createBlog(Blog blog)
	{
		blogMapper.createBlog(blog);
	}

}
