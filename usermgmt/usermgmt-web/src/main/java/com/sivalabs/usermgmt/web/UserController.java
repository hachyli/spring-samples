/**
 * 
 */
package com.sivalabs.usermgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class UserController 
{
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
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
	public String userhome(@RequestParam(value="query", defaultValue="") String searchName, Model model) 
	{
		List<User> users = null;
		if(StringUtils.isBlank(searchName)){
		users = userService.findAllUsers();
		}else{
			users = userService.searchUsers(searchName);
		}
		model.addAttribute("USERS", users);
		return "userhome";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.GET)
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "createUser";
	}
	
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	//@ResponseBody
	public String createUser(User user, Model model,final RedirectAttributes redirectAttrs) 
	{
		try {
			userService.createUser(user);
			redirectAttrs.addFlashAttribute("msg","User created successfully");
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
			//return "failure";
			//redirectAttrs.addFlashAttribute("msg","Unable to create User");
			model.addAttribute("msg","Unable to create User. Reason:"+e.getMessage());
			return "createUser";
		}
		return "redirect:/userhome.htm";
		//return "success";
	}
	
	@RequestMapping(value="/updateUser", method = RequestMethod.GET)
	public String editUser(@RequestParam("userId")Integer userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, Model model,final RedirectAttributes redirectAttrs) 
	{
		try {
			//System.out.println("Updating user: "+user);
			userService.updateUser(user);
			redirectAttrs.addFlashAttribute("msg","User updated successfully");
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("msg","Unable to update User. Reason:"+e.getMessage());
			return "updateUser";
		}
		return "redirect:/userhome.htm";
		//return "success";
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@RequestParam("userId")Integer userId, Model model,final RedirectAttributes redirectAttrs) 
	{
		try {
			userService.deleteUser(userId);
			redirectAttrs.addFlashAttribute("msg","User delete successfully");
		} catch (Exception e) {
			logger.error(e.getMessage());
			redirectAttrs.addFlashAttribute("msg","Unable to delete User");
			return "false";
		}
		//return "redirect:/userhome.htm";
		return "success";
	}
	
	
}
