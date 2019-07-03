package com.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@RequestMapping("/pizzaViaAnnotationsForm")
	public String pizzaViaAnnotationsFormula(Model model) {
		PizzaViaAnnotations pizzaViaAnnotations = new PizzaViaAnnotations();
		model.addAttribute("pizza", pizzaViaAnnotations);
		return "pizzaViaAnnotations";
	}

	@RequestMapping("/pizzaViaAnnotationsConfirmation")
	public String pizzaViaAnnotationsConfirmation(@ModelAttribute("pizza") PizzaViaAnnotations pizza) {
		System.out.println("The pizza will be delivered to: " + pizza.getStreetName() + " " + pizza.getHouseNumber()
				+ ", " + pizza.getCityDistrict());
		return "pizzaViaAnnotationsConfirmation";
	}

	@RequestMapping("/pizzaViaCodeForm")
	public String pizzaViaCodeFormula(Model model) {
		PizzaViaCode pizzaViaCode = new PizzaViaCode();
		model.addAttribute("pizza", pizzaViaCode);
		return "pizzaViaCode";
	}

	@RequestMapping("/pizzaViaCodeConfirmation")
	public String pizzaViaCodeConfirmation(@ModelAttribute("pizza") PizzaViaCode pizza) {
		System.out.println("The pizza will be delivered to: " + pizza.getStreetName() + " " + pizza.getHouseNumber()
				+ ", " + pizza.getCityDistrict());
		return "pizzaViaCodeConfirmation";
	}
}