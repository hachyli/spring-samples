package com.sivalabs.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sivalabs.forum.entities.Forum;
import com.sivalabs.forum.services.ForumService;

/**
 * @author Siva
 *
 */
@Controller
public class ForumController
{
	@Autowired
	private ForumService forumService;
	
	@RequestMapping("/showForum")
	public String showForum(@RequestParam("forumId")Long forumId, Model model)
	{
		Forum forum = forumService.findForum(forumId);
		model.addAttribute("FORUM_KEY", forum);
		return "show_forum";
	}
}
