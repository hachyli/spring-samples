package com.sivalabs.blogosphere.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.BlogosphereException;
import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;
import com.sivalabs.blogosphere.repositories.BlogRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BlogService
{
	@Autowired
	private SqlSession sqlSession;
	
	private BlogRepository getBlogPostingMapper()
	{
		return sqlSession.getMapper(BlogRepository.class);
	}
	
	
	public Blog createBlog(Blog blog)
	{
		BlogRepository bpm = getBlogPostingMapper();
		if(bpm.blogNameExists(blog.getBlogName()))
		{
			throw new BlogosphereException("Blog Name ["+blog.getBlogName()+"] is already in use.");
		}
		bpm.createBlog(blog);
		return blog;
	}

	
	public Blog getBlogById(Integer blogId)
	{
		BlogRepository bpm = getBlogPostingMapper();
		return bpm.getBlogById(blogId);
	}

	
	public List<Blog> getAllBlogs()
	{
		BlogRepository bpm = getBlogPostingMapper();
		return bpm.getAllBlogs();
	}

	
	public Post createBlogPost(Post post)
	{
		BlogRepository bpm = getBlogPostingMapper();
		bpm.createBlogPost(post);
		return post;
	}

	
	public Post getPostById(Integer postId)
	{
		BlogRepository bpm = getBlogPostingMapper();
		return bpm.getPostById(postId);		
	}

	
	public Comment createPostComment(Comment comment)
	{
		BlogRepository bpm = getBlogPostingMapper();
		bpm.createPostComment(comment);
		return comment;
	}


	public List<Blog> getUserBlogs(Integer userId)
	{
		BlogRepository bpm = getBlogPostingMapper();
		return bpm.getUserBlogs(userId);
	}

}
