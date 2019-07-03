package com.company;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/guestForm")
	public String guestFormula(Model model) {
		model.addAttribute("guest", new Guest());
		return "guest";
	}

	@RequestMapping("/guestConfirmation")
	public String guestConfirmation(@Valid @ModelAttribute("guest") Guest guest, BindingResult bindingResult) {
		System.out.println("Binding result: " + bindingResult);
		if (bindingResult.hasErrors()) {
			return "guest";
		} else {
			System.out.println("We can greet on our site: " + guest.getFirstName() + " " + guest.getLastName());
			return "guestConfirmation";
		}
	}
}