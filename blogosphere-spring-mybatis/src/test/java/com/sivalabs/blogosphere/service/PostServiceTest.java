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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class PostServiceTest
{
	@Autowired private BlogService bs;
	
	@Test
	public void testDummy()
	{
		assertTrue(true);
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


}
