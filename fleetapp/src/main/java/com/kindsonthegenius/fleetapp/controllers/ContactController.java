package com.kindsonthegenius.fleetapp.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	

	@GetMapping("/contacts")
	public String getContacts(Model model) {
		List<Contact> contactList = contactService.getContacts();
		model.addAttribute("contacts", contactList);

		return "contact";
	}

	@RequestMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		System.out.println("Reached here contacts/addNew"); 
		
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping("/contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {
		return contactService.findById(id);

	}

	@RequestMapping(value = "/contacts/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

}
