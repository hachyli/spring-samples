package com.sivalabs.buzz;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.buzz.entities.Post;
import com.sivalabs.buzz.entities.User;
import com.sivalabs.buzz.services.BuzzService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class BuzzServiceTest
{
	@Autowired
	private BuzzService buzzService;

	@Test
	public void createUser() {
		User user = new User(1,"siva");
		buzzService.createUser(user);
	}
	
	@Test
	public void findUserById() {
		Integer userId =1;
		 buzzService.findUserById(userId);
	}

	@Test
	public void findAllUsers() {
		List<User> users = buzzService.findAllUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void createPost() {
		Post post = new Post(0, "Sample Post", 1, new Date());
		buzzService.createPost(post);
	}

	@Test
	public void findAllPosts() {
		List<Post> posts = buzzService.findAllPosts();
		for (Post post : posts) {
			System.out.println(post);
		}
	}

	@Test
	public void  findUserPosts() {
		int userId = 1;
		List<Post> posts = buzzService.findUserPosts(userId);
		for (Post post : posts) {
			System.out.println(post);
		}
	}
	
	
}
