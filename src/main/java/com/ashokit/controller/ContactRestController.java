package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactRestController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
