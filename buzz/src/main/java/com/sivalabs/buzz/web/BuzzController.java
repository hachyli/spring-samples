/**
 * 
 */
package com.sivalabs.buzz.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.buzz.entities.Post;
import com.sivalabs.buzz.entities.User;
import com.sivalabs.buzz.services.BuzzService;

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
	
	@Autowired
	private TwitterTemplate twitterTemplate;
	
	@RequestMapping(value="/login/form")
	public String login(Model model) {
		User user = new User();
		user.setUserName("admin");
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value={"/","/welcome"}, method=RequestMethod.GET)
	public String welcome(Model model) {
		return "redirect:posts";
	}
	
	@RequestMapping(value={"/posts"}, method=RequestMethod.GET)
	public String showPosts(Model model) {
		logger.debug("Listing Posts...");
		List<Post> posts = buzzService.findAllPosts();
		logger.info("Found {} posts", posts.size());
		model.addAttribute("POSTS_KEY", posts);
		return "home";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public String createPost(@ModelAttribute("newPost") Post post, RedirectAttributes redirectAttributes) 
	{
		logger.debug("Creating a Post...");
		try {
			buzzService.createPost(post);
			logger.debug("Creating Post Success.");
			twitterTemplate.timelineOperations().updateStatus("Spring Social is awesome!");
			redirectAttributes.addFlashAttribute("MESSAGE", "Posted successfully");
			return "redirect:posts";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Creating Post Failed.");
			return "home";
		}
		
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String createUser(@ModelAttribute("newUser") User user) 
	{
		logger.debug("Creating a User...");
		try {
			buzzService.createUser(user);
			logger.debug("Creating User Success.");
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Creating User failed.");
			return "registration";
		}
		
	}
	
	
}
