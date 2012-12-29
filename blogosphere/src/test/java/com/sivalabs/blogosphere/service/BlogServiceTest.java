package com.sivalabs.blogosphere.service;

import static org.junit.Assert.*;

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
import com.sivalabs.blogosphere.domain.Post;
import com.sivalabs.blogosphere.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class BlogServiceTest
{
	@Autowired private BlogService bs;
	
	@Test
	public void testDummy()
	{
		assertTrue(true);
	}
	
	//************** Blog Methods ************//
	
	@Test
	public void testCreateBlog()
	{
		Blog blog = new Blog();
		blog.setBlogName("sivalabs"+System.currentTimeMillis());
		blog.setCreatedOn(new Date());
		User owner = new User();
		owner.setUserId(2);
		blog.setOwner(owner);
		
		Blog createdBlog = bs.createBlog(blog);
		assertNotNull(createdBlog);
		System.out.println(createdBlog.getBlogId());
	}
	
	@Test
	public final void testGetAllBlogs()
	{
		System.err.println("=============testGetAllBlogs BEGIN================");
		List<Blog> allBlogs = bs.getAllBlogs();
		for (Blog blog : allBlogs)
		{
			System.out.println(blog.getBlogName());
			List<Post> posts = blog.getPosts();
			
			System.err.println("No of posts: "+posts.size());
			for (Post post : posts)
			{
				System.err.println(post.getContent()+" posted by "+blog.getOwner().getUserName());
			}
		}
		System.err.println("=============testGetAllBlogs END================");
	}
	
	@Test
	public void testGetUserBlogs()
	{
		System.err.println("=============testGetUserBlogs BEGIN================");
		List<Blog> allBlogs = bs.getUserBlogs(2);
		for (Blog blog : allBlogs)
		{
			System.out.println(blog.getBlogName());
			List<Post> posts = blog.getPosts();
			
			System.err.println("No of posts: "+posts.size());
			for (Post post : posts)
			{
				System.err.println(post.getContent()+" posted by "+blog.getOwner().getUserName());
			}
		}
		System.err.println("=============testGetUserBlogs END================");
	}
	
	
	@Test
	public void testGetBlogById()
	{
		System.err.println("=============testGetBlogById================");
		Blog blog = bs.getBlogById(1);
		assertNotNull(blog);
		System.err.println(blog.getBlogName());
		System.err.println(blog.getOwner().getUserName());
		List<Post> posts = blog.getPosts();
		System.err.println("No of posts: "+posts.size());
		for (Post post : posts)
		{
			System.err.println(post.getContent()+" posted by "+blog.getOwner().getUserName());
		}
	}
	
	

}
