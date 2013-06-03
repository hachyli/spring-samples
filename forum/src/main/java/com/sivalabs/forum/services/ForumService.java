package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.Forum;
import com.sivalabs.forum.repositories.ForumRepository;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Service
@Transactional
public class ForumService
{
	@Autowired
	private ForumRepository forumRepository;
	
	public List<Forum> findAll()
	{
		return forumRepository.findAll();
	}
	public Forum findForum(Long catId)
	{
		return forumRepository.findOne(catId);
	}
	
	public Forum create(Forum forum)
	{
		Forum frm  = forumRepository.findByName(forum.getName());
		if(frm != null){
			throw new RuntimeException("Forum with Name :["+forum.getName()+"] already exist.");
		}
		forum.setId(null);
		return forumRepository.save(forum);
	}
	
	public Forum update(Forum forum)
	{
		if(findForum(forum.getId()) == null)
		{
			throw new RuntimeException("Forum with id :["+forum.getId()+"] doesn't exist.");
		}
		return forumRepository.save(forum);
	}
	
	public void delete(Long forumId)
	{
		if(findForum(forumId) == null)
		{
			throw new RuntimeException("Forum with id :["+forumId+"] doesn't exist.");
		}
		forumRepository.delete(forumId);
	}
}
