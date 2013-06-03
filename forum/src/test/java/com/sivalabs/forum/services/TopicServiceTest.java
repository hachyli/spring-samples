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
import com.sivalabs.forum.entities.Topic;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class TopicServiceTest
{
	@Autowired
	private TopicService topicService;

	@Test
	public void findAll()
	{
		List<Topic> categories = topicService.findAll();
		assertNotNull(categories);
	}

	@Test
	public void findTopic()
	{
		Long topicId = 1L;
		Topic topic = topicService.findTopic(topicId);
		assertNotNull(topic);
	}

	@Test
	public void create()
	{
		Topic topic = new Topic(null,2L,"Test Topic",3L);
		Topic newTopic = topicService.create(topic);
		assertNotNull(newTopic);
	}

	@Test
	public void update()
	{
		Topic topic = topicService.findTopic(3L);
		topic.setUpdatedOn(new Date());
		topicService.update(topic);
	}

	@Test
	public void delete()
	{
		Long topicId = 4L;
		topicService.delete(topicId);
		Topic topic = topicService.findTopic(4L);
		assertNull(topic);
	}
	
	
}
