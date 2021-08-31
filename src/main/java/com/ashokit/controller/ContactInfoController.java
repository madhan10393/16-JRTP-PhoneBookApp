package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.ContactInfo;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String getContactInfoPage(Model model) {
		model.addAttribute("contact", new ContactInfo());
		return "contactinfo";
	}

	@PostMapping("/savecontact")
	public String saveContact(@ModelAttribute("contact") ContactInfo contact, Model model) {
		boolean isSave = contactService.saveContact(contact);
		if (isSave) {
			model.addAttribute("success", "Contact Saved Successfully");
		} else {
			model.addAttribute("failure", "Contact doesn't Saved");
		}
		return "contactinfo";
	}

	@GetMapping("/viewcontacts")
	public String viewAllContacts(Model model) {
		List<ContactInfo> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewcontact";
	}

}
