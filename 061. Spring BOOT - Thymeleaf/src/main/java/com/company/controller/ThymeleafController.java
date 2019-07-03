package com.company.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

	@Value("${start.greetings}")
	private String greeting;

	@Value("${start.page}")
	private String startPage;

	@GetMapping("/")
	public String helloWorld(Model model) {
		model.addAttribute("welcome", greeting);
		model.addAttribute("date", new java.util.Date());
		return startPage;
	}
}