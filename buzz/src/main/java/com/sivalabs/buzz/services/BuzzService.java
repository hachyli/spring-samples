/**
 * 
 */
package com.sivalabs.buzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.buzz.entities.Post;
import com.sivalabs.buzz.entities.User;
import com.sivalabs.buzz.repositories.PostRepository;
import com.sivalabs.buzz.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BuzzService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private PostRepository postRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public void createPost(Post post) {
		postRepository.save(post);
	}

	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}

	public List<Post> findUserPosts(int userId) {
		return postRepository.findByCreatedById(userId);
	}

	
}
