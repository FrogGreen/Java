package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String showHomePage() {
		return "homePage";
	}

	@GetMapping("/user")
	public String showUserPage() {
		return "userPage";
	}

	@GetMapping("/admin/adminPanel")
	public String showAdminPage() {
		return "adminPage";
	}

	@GetMapping("/tester/testerPanel")
	public String showTesterPage() {
		return "testerPage";
	}
}