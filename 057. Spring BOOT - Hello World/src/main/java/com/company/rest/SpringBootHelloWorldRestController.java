package com.company.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootHelloWorldRestController {

	@Value("${start.greetings}")
	private String greeting;

	@GetMapping("/")
	public String helloWorld() {
		return greeting;
	}
}