/**
 * 
 */
package com.sivalabs.phonebook.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.phonebook.entities.Contact;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.PhonebookService;

/** 
 * @author siva
 *
 */
@Controller
public class PhonebookController 
{
	@Autowired
	private PhonebookService phonebookService;
	
	@RequestMapping(value="/phonebook")
	public String phonebook(Model model) {
		return "phonebook";
	}
	
	@RequestMapping("/searchContacts")
	public String searchContacts(@RequestParam(value="searchCriteria", defaultValue="") String name,
			HttpServletRequest request) {
		Integer userId = ((User)request.getSession().getAttribute("LOGIN_USER")).getUserId();
		List<Contact> contacts = phonebookService.searchUserContacts(userId, name);
		request.setAttribute("SEARCH_CONTACTS_REULTS", contacts);
		return "phonebook";
	}
	
	@RequestMapping("/newContactForm")
	public String newContactForm(Model model, HttpServletRequest request) {
		Contact contact = new Contact();
		model.addAttribute("Contact", contact);
		return "newContact";
	}
	
	@RequestMapping("/saveContact")
	public String saveContact(@Valid @ModelAttribute("Contact") Contact contact, 
			BindingResult bindingResult,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()){
			return "newContact";
		}
		Integer userId = ((User)request.getSession().getAttribute("LOGIN_USER")).getUserId();
		contact.setUser((User)request.getSession().getAttribute("LOGIN_USER"));
		
		phonebookService.addContact(userId, contact);
		redirectAttributes.addFlashAttribute("MSG", "Contact Saved Successfully"); 		
		return "redirect:searchContacts.htm";
	}
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam(value="contactId") Integer contactId,
			Model model, HttpServletRequest request) {
		Integer userId = ((User)request.getSession().getAttribute("LOGIN_USER")).getUserId();
		Contact contact = phonebookService.getContactById(contactId);
		System.err.println(userId +":"+ contact.getContactId());
		if(userId == contact.getUser().getUserId()){
			model.addAttribute("Contact", contact);
		}		
		return "editContact";
	}
	
	@RequestMapping("/updateContact")
	public String updateContact(@Validated @ModelAttribute("Contact") Contact contact,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model, HttpServletRequest request
			) {
		contact.setUser((User)request.getSession().getAttribute("LOGIN_USER"));
		if(bindingResult.hasErrors()){
			return "editContact";
		}
		phonebookService.updateContact(contact);
		redirectAttributes.addFlashAttribute("MSG", "Contact Updated Successfully"); 	
		return "redirect:searchContacts.htm";
	}
	
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam(value="contactId") Integer contactId,
			RedirectAttributes redirectAttributes,
			Model model, HttpServletRequest request) {
		System.err.println("contactId:"+contactId);
		phonebookService.deleteContact(contactId);
		redirectAttributes.addFlashAttribute("MSG", "Contact Deleted Successfully"); 		
		return "redirect:searchContacts.htm";
	}
}
