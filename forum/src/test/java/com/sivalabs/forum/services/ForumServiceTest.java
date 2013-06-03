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
import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.entities.Forum;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class ForumServiceTest
{
	@Autowired
	private ForumService forumService;

	@Test
	public void findAll()
	{
		List<Forum> categories = forumService.findAll();
		assertNotNull(categories);
	}

	@Test
	public void findForum()
	{
		Long forumId = 1L;
		Forum forum = forumService.findForum(forumId);
		assertNotNull(forum);
	}

	@Test
	public void create()
	{
		Forum forum = new Forum(null,"Test Forum","Test Forum Description",4);
		Category category = new Category(2L);
		forum.setCategory(category);
		Forum newForum = forumService.create(forum);
		assertNotNull(newForum);
	}

	@Test
	public void update()
	{
		Forum forum = forumService.findForum(3L);
		forum.setUpdatedOn(new Date());
		forumService.update(forum);
	}

	@Test
	public void delete()
	{
		Long forumId = 4L;
		forumService.delete(forumId);
		Forum forum = forumService.findForum(4L);
		assertNull(forum);
	}
	
	
}
