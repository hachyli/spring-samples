/**
 * 
 */
package com.sivalabs.phonebook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.sivalabs.common.model.User;
import com.sivalabs.common.web.util.UserContextUtil;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Controller
public class PhoneBookController
{
	@Autowired
	//private PhoneBookRepository phoneBookRepository;
	private ContactsRepository contactsRepository;
	
	@RequestMapping(value="newContact", method=RequestMethod.GET)
	public String showNewContactForm(HttpSession session, Model model)
	{
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "phonebook/newContact";
	}
	
	@RequestMapping(value="newContact", method=RequestMethod.POST)
	public String saveContact(HttpSession session, @ModelAttribute("contact") Contact contact, BindingResult result, SessionStatus status)
	{
		//Integer contactId = phoneBookRepository.create(contact);
		User user = UserContextUtil.getLoggedinUser(session);
		contact.setUser(user);
		contact = contactsRepository.save(contact);
		System.out.println("Contact Id="+contact.getId());
		return "redirect:showContacts.htm";
	}
	
	@RequestMapping(value="showContacts", method=RequestMethod.GET)
	public String showContacts(HttpSession session, Model model)
	{
		User user = UserContextUtil.getLoggedinUser(session);
		//Set<Contact> contacts = phoneBookRepository.getContacts(user.getUserId());
		List<Contact> contacts = contactsRepository.findByUserId(user.getUserId());
		model.addAttribute("CONTACTS_KEY", contacts);
		return "phonebook/showContacts";
	}
}
