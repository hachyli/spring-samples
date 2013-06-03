package com.sivalabs.forum.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.forum.config.AppConfig;
import com.sivalabs.forum.entities.Post;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class PostServiceTest
{
	@Autowired
	private PostService postService;

	@Test
	public void findAll()
	{
		List<Post> categories = postService.findAll();
		assertNotNull(categories);
	}

	@Test
	public void findPost()
	{
		Long postId = 1L;
		Post post = postService.findPost(postId);
		assertNotNull(post);
	}

	@Test
	public void create()
	{
		Post post = new Post(null,1L,"Test Post","Test Post Description", 4L);
		Post newPost = postService.create(post);
		assertNotNull(newPost);
	}

	@Test
	public void update()
	{
		Post post = postService.findPost(3L);
		post.setUpdatedOn(new Date());
		postService.update(post);
	}

	@Test
	public void delete()
	{
		Long postId = 4L;
		postService.delete(postId);
		Post post = postService.findPost(4L);
		assertNull(post);
	}
	
	
}
