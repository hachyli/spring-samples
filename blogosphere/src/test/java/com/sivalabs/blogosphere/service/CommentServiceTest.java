package com.sivalabs.blogosphere.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
import com.sivalabs.blogosphere.domain.Tag;
import com.sivalabs.blogosphere.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class CommentServiceTest
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
	
	
	//************** Post Methods ************//
	@Test
	public void testCreatePost()
	{
		System.err.println("=============testCreateBlogPost================");
		Post post = new Post();
		Blog blog = new Blog();
		blog.setBlogId(1);
		post.setBlog(blog);
		post.setTitle("My Second Post");
		post.setContent("This my Second post");
		post.setCreatedOn(new Date());
		
		List<Tag> tags = new ArrayList<Tag>();
		Tag tag1 = new Tag(1);
		Tag tag2 = new Tag(2);
		tags.add(tag1);
		tags.add(tag2);
		
		post.setTags(tags);
		Post createdBlogPost = bs.createPost(post);
		
		assertNotNull(createdBlogPost);
		System.err.println(createdBlogPost.getPostId());
		
	}
	
	@Test
	public void testGetPostById()
	{
		System.err.println("=============testGetPostById================");
		Post post = bs.getPostById(1);
		System.err.println(post.getBlog().getBlogId());
		System.err.println(post.getContent());
		List<Comment> comments = post.getComments();
		for (Comment comment : comments)
		{
			System.err.println(comment.getCommentId()+":"+comment.getContent());
		}
		
		List<Tag> tags = post.getTags();
		for (Tag tag : tags) {
			System.err.println("->"+tag.getTagName());
		}
	}

	@Test
	public final void testGetPostsByBlogId()
	{
		List<Post> posts = bs.getPostsByBlogId(1);
		assertNotNull(posts);
		for (Post post : posts)
		{
			System.out.println(post);
		}
	}

	@Test
	public final void testUpdatePost()
	{
		Post post = bs.getPostById(1);
		String updatedContent = post.getContent()+":"+new Date();
		post.setContent(updatedContent);
		Post updatesPost = bs.updatePost(post);
		assertEquals(updatedContent, updatesPost.getContent());
	}

	@Test
	public final void testDeletePost()
	{
		Post post = bs.getPostById(1);
		assertNotNull(post);
		bs.deletePost(post.getPostId());
		post = bs.getPostById(post.getPostId());
		assertNull(post);
		
	}

	
	//************** Comment Methods ************//
	
	@Test
	public void testCreateComment()
	{
		System.err.println("=============testCreatePostComment================");
		Comment comment = new Comment();
		Post post = new Post();
		post.setPostId(1);
		comment.setPost(post);
		comment.setTitle("RE: My Second Post");
		comment.setContent("Keep going...");
		comment.setCreatedOn(new Date());
		User user = new User();
		user.setUserId(1);
		comment.setCreatedBy(user);
		Comment createdPostComment = bs.createComment(comment);
		System.err.println(createdPostComment.getCommentId());
		
	}
	
	@Test
	public final void testGetCommentsByPostId()
	{
		List<Comment> comments = bs.getCommentsByPostId(1);
		assertNotNull(comments);
		for (Comment comment : comments)
		{
			System.out.println(comment);
		}
	}

	@Test
	public final void testGetCommentById()
	{
		Comment comment = bs.getCommentById(1);
		assertNotNull(comment);
	}

	@Test
	public final void testUpdateComment()
	{
		Comment comment = bs.getCommentById(1);
		assertNotNull(comment);
		String updatedContent = comment.getContent()+new Date();
		comment.setContent(updatedContent);
		Comment updatedComment = bs.updateComment(comment);
		assertEquals(updatedContent, updatedComment.getContent());
	}

	@Test
	public final void testDeleteComment()
	{
		Comment comment = bs.getCommentById(1);
		assertNotNull(comment);
		bs.deleteComment(comment.getCommentId());
		comment = bs.getCommentById(comment.getCommentId());
		assertNull(comment);
	}

	@Test
	public final void testDeleteCommentsByPostId()
	{
		Post post = bs.getPostById(1);
		assertTrue(post.getComments().size()>0);
		bs.deleteCommentsByPostId(post.getPostId());
		post = bs.getPostById(post.getPostId());
		assertTrue(post.getComments().size()==0);
	}

}
