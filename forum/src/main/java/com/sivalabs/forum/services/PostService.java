package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.Post;
import com.sivalabs.forum.repositories.PostRepository;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Service
@Transactional
public class PostService
{
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll()
	{
		return postRepository.findAll();
	}
	public Post findPost(Long catId)
	{
		return postRepository.findOne(catId);
	}
	
	public Post create(Post post)
	{
		post.setId(null);
		return postRepository.save(post);
	}
	
	public Post update(Post post)
	{
		if(findPost(post.getId()) == null)
		{
			throw new RuntimeException("Post with id :["+post.getId()+"] doesn't exist.");
		}
		return postRepository.save(post);
	}
	
	public void delete(Long postId)
	{
		if(findPost(postId) == null)
		{
			throw new RuntimeException("Post with id :["+postId+"] doesn't exist.");
		}
		postRepository.delete(postId);
	}


}
