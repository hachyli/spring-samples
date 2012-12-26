package com.sivalabs.blogosphere.service;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;
import com.sivalabs.blogosphere.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class BlogServiceTest
{
	@Autowired
	private BlogService bps;
	
	@Test
	public void testDummy()
	{
		assertTrue(true);
	}
	
	@Test
	public void testCreateBlog()
	{
		Blog blog = new Blog();
		blog.setBlogName("sivalabs"+System.currentTimeMillis());
		blog.setCreatedOn(new Date());
		User owner = new User();
		owner.setUserId(2);
		blog.setOwner(owner );
		
		Blog createdBlog = bps.createBlog(blog);
		assertNotNull(createdBlog);
		System.out.println(createdBlog.getBlogId());
	}
	
	@Test
	public void testGetAllBlogs()
	{
		List<Blog> allBlogs = bps.getAllBlogs();
		for (Blog blog : allBlogs)
		{
			System.out.println(blog.getBlogName());
			List<Post> posts = blog.getPosts();
			
			System.err.println("No of posts: "+posts.size());
			for (Post post : posts)
			{
				System.err.println(post.getContent()+" posted by "+blog.getOwner().getEmailId());
			}
		}
	}
	
	@Test
	public void testGetUserBlogs()
	{
		System.err.println("=============testGetUserBlogs BEGIN================");
		List<Blog> allBlogs = bps.getUserBlogs(2);
		for (Blog blog : allBlogs)
		{
			System.out.println(blog.getBlogName());
			List<Post> posts = blog.getPosts();
			
			System.err.println("No of posts: "+posts.size());
			for (Post post : posts)
			{
				System.err.println(post.getContent()+" posted by "+blog.getOwner().getEmailId());
			}
		}
		System.err.println("=============testGetUserBlogs END================");
	}
	
	@Test
	public void testGetBlogById()
	{
		Blog blog = bps.getBlogById(1);
		assertNotNull(blog);
		System.err.println(blog.getBlogName());
		System.err.println(blog.getOwner().getEmailId());
		List<Post> posts = blog.getPosts();
		System.err.println("No of posts: "+posts.size());
		for (Post post : posts)
		{
			System.err.println(post.getContent()+" posted by "+blog.getOwner().getEmailId());
		}
	}
	
	@Test
	public void testCreateBlogPost()
	{
		Blog blog=new Blog();
		blog.setBlogId(1);
		Post post = new Post();
		post.setBlog(blog);
		post.setTitle("My Second Post");
		post.setContent("This my Second post");
		post.setCreatedOn(new Date());
		
		Post createdBlogPost = bps.createBlogPost(post);
		
		assertNotNull(createdBlogPost);
		System.err.println(createdBlogPost.getPostId());
	}
	
	@Test
	public void testCreatePostComment()
	{
		Post post = new Post();
		post.setPostId(1);
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setTitle("RE: My Second Post");
		comment.setContent("Keep going...");
		comment.setCreatedOn(new Date());
		User user = new User();
		user.setUserId(1);
		comment.setCreatedBy(user);
		Comment createdPostComment = bps.createPostComment(comment);
		System.err.println(createdPostComment.getCommentId());
		
	}
	
	@Test
	public void testGetPostById()
	{
		Post post = bps.getPostById(1);
		System.err.println(post.getBlog().getOwner().getEmailId());
		System.err.println(post.getContent());
		List<Comment> comments = post.getComments();
		for (Comment comment : comments)
		{
			System.err.println(comment.getCommentId()+":"+comment.getContent());
		}
	}
}
