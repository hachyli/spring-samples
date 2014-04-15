/**
 * 
 */
package com.sivalabs.forum.web.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.forum.domain.Forum;
import com.sivalabs.forum.services.ForumService;

/**
 * @author skatam
 *
 */
@Controller
@RequestMapping("/forums")
public class ForumController
{
	private ForumService forumService;
	@Autowired
	public void setForumService(ForumService forumService)
	{
		this.forumService = forumService;
	}
	
	@RequestMapping("")
	public ModelAndView listForums()
	{
		ModelAndView mav = new ModelAndView("forumsHome");		
		Collection<Forum> forums = this.forumService.getForums();
		mav.addObject("forums", forums);
		return mav;
	}
	
	@RequestMapping({"/{forumId}"})
	public ModelAndView showForum(@PathVariable("forumId") long forumId, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("showForum");
		Forum forum = this.forumService.getForum(forumId);
		request.getSession().setAttribute("currentForum", forum);
		mav.addObject("forum", forum);
		return mav;
	}
	
	/*
	@RequestMapping("/topic")
	public ModelAndView showTopic(@RequestParam("topicId") long topicId)
	{
		ModelAndView mav = new ModelAndView("showTopic");
		Topic topic = this.forumService.getTopic(topicId);
		mav.addObject("topic", topic);
		return mav;
	}
	
	@RequestMapping(value="newTopic", method=RequestMethod.GET)
	public ModelAndView newTopicForm(@RequestParam("forumId") long forumId)
	{
		ModelAndView mav = new ModelAndView("newTopic");		
		Forum forum = new Forum();
		forum.setForumId(forumId);
		
		Topic topic = new Topic();
		topic.setForum(forum);
		
		mav.addObject("topic", topic);
		
		return mav;
	}
	
	@RequestMapping(value="newTopic", method=RequestMethod.POST)
	public ModelAndView saveTopic(Topic topic, HttpServletRequest request)
	{
		User user = (User) request.getSession().getAttribute("LOGGEDIN_USER"); 
		topic.setPostedOn(new Date());
		topic.setStartedBy(user);
		
		topic = this.forumService.createTopic(topic);
		long topicId = topic.getTopicId();
		ModelAndView mav = new ModelAndView("redirect:topic.do?topicId="+topicId);
		return mav;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView showReplyForm(@RequestParam("topicId") long topicId)
	{
		ModelAndView mav = new ModelAndView("reply");
		Topic topic = this.forumService.getTopic(topicId);
		mav.addObject("topic", topic);
		
		Post post = new Post();
		post.setTopic(topic);
		post.setTitle("Re: "+topic.getTitle());
		
		mav.addObject("post", post);
		
		return mav;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public ModelAndView saveReply(Post post, HttpServletRequest request)
	{
		post.setPostedOn(new Date());
		User user = (User) request.getSession().getAttribute("LOGGEDIN_USER");
		post.setPostedBy(user);
		
		long postId = this.forumService.createPost(post);
		System.out.println("PostId="+postId);
		ModelAndView mav = new ModelAndView("redirect:topic.do?topicId="+post.getTopic().getTopicId());
		return mav;
	}
	*/
}
