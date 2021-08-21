package com.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
