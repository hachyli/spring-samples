/**
 * 
 */
package com.sivalabs.buzz.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.buzz.entities.Post;
import com.sivalabs.buzz.entities.User;
import com.sivalabs.buzz.services.BuzzService;
import com.sivalabs.buzz.web.model.JsonResponse;
import com.sivalabs.buzz.web.model.PostsResponse;

/**
 * @author Siva
 *
 */
@Controller
public class BuzzController 
{
	private static Logger logger = LoggerFactory.getLogger(BuzzController.class);
	
	@Autowired
	private BuzzService buzzService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome() {
		logger.debug("Home...Sweet home  :-)");
		return "welcome";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	@ResponseBody
	public PostsResponse listPosts() 
	{
		logger.debug("Listing Posts...");
		List<Post> posts = buzzService.findAllPosts();
		logger.info("Found {} posts", posts.size());
		PostsResponse postsResponse = new PostsResponse();
		postsResponse.setPosts(posts);
		return postsResponse;
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse createPost(Post post) 
	{
		logger.debug("Creating a Post...");
		try {
			buzzService.createPost(post);
			logger.debug("Creating Post Success.");
			return new JsonResponse("success");// "{status:success}";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Creating Post Failed.");
			return new JsonResponse("failure");//"{status:failure}";
		}
		
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse createUser(User user) 
	{
		logger.debug("Creating a User...");
		try {
			buzzService.createUser(user);
			logger.debug("Creating User Success.");
			return new JsonResponse("success");// "{status:success}";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Creating User Success.");
			return new JsonResponse("failure");//"{status:failure}";
		}
		
	}
	
	@RequestMapping(value="/users/{userId}/posts", method=RequestMethod.GET)
	@ResponseBody
	public PostsResponse listUserPosts(@PathVariable("userId") Integer userId) 
	{
		logger.debug("Listing User {} Posts...",userId);
		List<Post> posts = buzzService.findUserPosts(userId);
		logger.info("Found {} posts", posts.size());
		PostsResponse postsResponse = new PostsResponse();
		postsResponse.setPosts(posts);
		return postsResponse;
	}
}
