package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.ContactInfo;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		ContactInfo contactInfo = contactService.getByContactId(contactId);
		model.addAttribute("contact", contactInfo);
		return "contactinfo";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId,Model model) {
		contactService.deleteByContactId(contactId);
		return "redirect:viewcontacts";
	}
	
}
