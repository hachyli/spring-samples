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

import com.sivalabs.forum.domain.Forum;
import com.sivalabs.forum.domain.Topic;
import com.sivalabs.forum.domain.User;
import com.sivalabs.forum.services.ForumService;
import com.sivalabs.forum.web.util.UserContextHolder;

/**
 * @author skatam
 *
 */
@Controller
@RequestMapping("/forums/{forumId}/topics")
public class TopicController
{
	private ForumService forumService;
	@Autowired
	public void setForumService(ForumService forumService)
	{
		this.forumService = forumService;
	}
	
	@RequestMapping(value="/{topicId}", method=RequestMethod.GET)
	public ModelAndView showTopic(@PathVariable("topicId") long topicId)
	{
		ModelAndView mav = new ModelAndView("showTopic");
		Topic topic = this.forumService.getTopic(topicId);
		mav.addObject("topic", topic);
		return mav;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, params="newTopic")
	public ModelAndView newTopicForm(@PathVariable("forumId") long forumId
			, HttpServletRequest request)
	{
		UserContextHolder.getMandatoryLoggedinUser(request.getSession());
		
		ModelAndView mav = new ModelAndView("newTopic");		
		Forum forum = new Forum();
		forum.setForumId(forumId);
		
		Topic topic = new Topic();
		topic.setForum(forum);
		
		mav.addObject("topic", topic);
		
		return mav;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView saveTopic(Topic topic, HttpServletRequest request)
	{
		//User user = (User) request.getSession().getAttribute("LOGGEDIN_USER"); 
		
		User user = UserContextHolder.getMandatoryLoggedinUser(request.getSession());
		topic.setPostedOn(new Date());
		topic.setStartedBy(user);
		
		topic = this.forumService.createTopic(topic);
		long topicId = topic.getTopicId();
		String url = "/forums/"+topic.getForum().getForumId()+"/topics/"+topicId;
		ModelAndView mav = new ModelAndView("redirect:"+url);
		return mav;
	}
	
}
