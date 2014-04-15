/**
 * 
 */
package com.sivalabs.forum.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.forum.domain.Post;
import com.sivalabs.forum.domain.Topic;
import com.sivalabs.forum.domain.User;
import com.sivalabs.forum.services.ForumService;
import com.sivalabs.forum.web.util.UserContextHolder;

/**
 * @author skatam
 *
 */
@Controller
@RequestMapping("/forums/{forumId}/topics/{topicId}")
public class PostController
{
	private ForumService forumService;
	@Autowired
	public void setForumService(ForumService forumService)
	{
		this.forumService = forumService;
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.GET)
	public ModelAndView showReplyForm(@PathVariable("topicId") long topicId
			, HttpServletRequest request)
	{
		UserContextHolder.getMandatoryLoggedinUser(request.getSession());
		
		ModelAndView mav = new ModelAndView("reply");
		Topic topic = this.forumService.getTopic(topicId);
		mav.addObject("topic", topic);
		
		Post post = new Post();
		post.setTopic(topic);
		post.setTitle("Re: "+topic.getTitle());
		
		mav.addObject("post", post);
		
		return mav;
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public ModelAndView saveReply(@PathVariable("forumId") long forumId,
			@PathVariable("topicId") long topicId,
			Post post, HttpServletRequest request)
	{
		post.setPostedOn(new Date());
		//User user = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		User user = UserContextHolder.getMandatoryLoggedinUser(request.getSession());
		
		post.setPostedBy(user);
		
		long postId = this.forumService.createPost(post);
		System.out.println("PostId="+postId);
		//ModelAndView mav = new ModelAndView("redirect:topic.do?topicId="+post.getTopic().getTopicId());
		String url = "/forums/"+forumId+"/topics/"+topicId;
		ModelAndView mav = new ModelAndView("redirect:"+url);
		
		return mav;
	}
}
