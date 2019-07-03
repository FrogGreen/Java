package com.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	public HelloWorldController() {
	}

	@RequestMapping("/form")
	public String showForm() {
		return "helloWorld";
	}

	@RequestMapping("/formVersionOne")
	public String simpleWelcome() {
		return "helloWorldConfirmation";
	}

	@RequestMapping("/formVersionTwo")
	public String extendedWelcome(HttpServletRequest request, Model model) {
		String string = request.getParameter("guestName");
		string = string.toUpperCase();
		string = "Welcome! " + string;
		model.addAttribute("greetings", string);
		return "helloWorldConfirmation";
	}

	@RequestMapping("/formVersionThree")
	public String widestWelcome(@RequestParam("guestName") String string, Model model) {
		string = string.toUpperCase();
		string = "Welcome my Friend! " + string;
		model.addAttribute("greetings", string);
		return "helloWorldConfirmation";
	}
}