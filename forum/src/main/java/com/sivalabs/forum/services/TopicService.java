package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.Topic;
import com.sivalabs.forum.repositories.TopicRepository;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Service
@Transactional
public class TopicService
{

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> findAll()
	{
		return topicRepository.findAll();
	}
	public Topic findTopic(Long catId)
	{
		return topicRepository.findOne(catId);
	}
	
	public Topic create(Topic topic)
	{
		topic.setId(null);
		return topicRepository.save(topic);
	}
	
	public Topic update(Topic topic)
	{
		if(findTopic(topic.getId()) == null)
		{
			throw new RuntimeException("Topic with id :["+topic.getId()+"] doesn't exist.");
		}
		return topicRepository.save(topic);
	}
	
	public void delete(Long topicId)
	{
		if(findTopic(topicId) == null)
		{
			throw new RuntimeException("Topic with id :["+topicId+"] doesn't exist.");
		}
		topicRepository.delete(topicId);
	}

}
