package com.sivalabs.blogosphere.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

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
		
		blog.setOwnerId(2 );
		
		Blog createdBlog = bps.createBlog(blog);
		assertNotNull(createdBlog);
		System.out.println(createdBlog.getBlogId());
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
				System.err.println(post.getContent()+" posted by "+blog.getOwnerId());
			}
		}
		System.err.println("=============testGetUserBlogs END================");
	}
	
	@Test
	public void testGetBlogById()
	{
		System.err.println("=============testGetBlogById================");
		Blog blog = bps.getBlogById(1);
		assertNotNull(blog);
		System.err.println(blog.getBlogName());
		System.err.println(blog.getOwnerId());
		List<Post> posts = blog.getPosts();
		System.err.println("No of posts: "+posts.size());
		for (Post post : posts)
		{
			System.err.println(post.getContent()+" posted by "+blog.getOwnerId());
		}
	}
	
	@Test
	public void testCreateBlogPost()
	{
		System.err.println("=============testCreateBlogPost================");
		Post post = new Post();
		post.setBlogId(1);
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
		System.err.println("=============testCreatePostComment================");
		Comment comment = new Comment();
		comment.setPostId(1);
		comment.setTitle("RE: My Second Post");
		comment.setContent("Keep going...");
		comment.setCreatedOn(new Date());
		comment.setCreatedBy(1);
		Comment createdPostComment = bps.createPostComment(comment);
		System.err.println(createdPostComment.getCommentId());
		
	}
	
	@Test
	public void testGetPostById()
	{
		System.err.println("=============testGetPostById================");
		Post post = bps.getPostById(1);
		System.err.println(post.getBlogId());
		System.err.println(post.getContent());
		List<Comment> comments = post.getComments();
		for (Comment comment : comments)
		{
			System.err.println(comment.getCommentId()+":"+comment.getContent());
		}
	}
}
