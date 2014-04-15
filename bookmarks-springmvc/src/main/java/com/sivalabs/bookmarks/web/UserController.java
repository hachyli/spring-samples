/**
 * 
 */
package com.sivalabs.bookmarks.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.bookmarks.entities.BookMark;
import com.sivalabs.bookmarks.entities.Tag;
import com.sivalabs.bookmarks.entities.User;
import com.sivalabs.bookmarks.services.BookMarkService;
import com.sivalabs.bookmarks.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class UserController 
{
	private static final int DEFAULT_NO_OF_BOOKMARKS_PER_PAGE = 10;
	
	@Autowired private UserService userService;
	@Autowired private BookMarkService bookMarkService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		return "welcome";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) 
	{
		String view = "login";
		User loginUser = userService.login(user.getUserName(), user.getPassword());
		if(loginUser != null)
		{
			request.getSession().setAttribute("LOGIN_USER", loginUser);
			view = "redirect:/userhome.htm";
		}
		else
		{
			model.addAttribute("error", "Your login attempt was not successful, try again");
		}
		return view;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.htm";
	}
	
	@RequestMapping("/userhome")
	public String userhome(@RequestParam(value="page", defaultValue="0") String page, 
							@RequestParam(value="pageSize", required=false) String pageSize, 
							Model model) 
	{
		int pageNo = 0;
		int rowsPerPage = DEFAULT_NO_OF_BOOKMARKS_PER_PAGE;
		try {
			pageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			pageNo = 0;
		}
		try {
			rowsPerPage = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			rowsPerPage = DEFAULT_NO_OF_BOOKMARKS_PER_PAGE;
		}
		Page<BookMark> results = bookMarkService.getBookMarks(pageNo, rowsPerPage);
		List<BookMark> bookMarks = results.getContent();
		
		model.addAttribute("BOOKMARKS", bookMarks);
		model.addAttribute("currentPage", results.getNumber());
		model.addAttribute("hasNextPage", results.hasNextPage());
		model.addAttribute("hasPreviousPage", results.hasPreviousPage());
		
		return "userhome";
	}
	
	@RequestMapping(value="/createBookMark", method=RequestMethod.POST)
	//@ResponseBody
	public String createBookMark(BookMark bookMark, Model model,
								RedirectAttributes redirectAttrs, 
								HttpServletRequest request) 
	{
		try 
		{
			String tagsString = request.getParameter("tagList");
			bookMark.setTags(this.buildTags(tagsString));
			bookMarkService.create(bookMark);
			redirectAttrs.addFlashAttribute("msg","Bookmark Saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("msg","Unable to save Bookmark");
		}
		return "redirect:/userhome.htm";
	}
	
	private Set<Tag> buildTags(String tagsString)
	{
		Set<Tag> tags = new HashSet<Tag>();
		if(!StringUtils.isBlank(tagsString)){
			String[] tagNames = StringUtils.split(tagsString, ",");
			for (String tagName : tagNames)
			{
				if(!StringUtils.isBlank(tagName))
				{
					Tag tag = new Tag(null, tagName);
					tags.add(tag);
				}
			}
		}
		return tags;
	}
}
