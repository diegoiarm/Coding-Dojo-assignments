package com.codingdojo.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String codingdojo() {
		return "<h1>¡Hola Coding Dojo!</h1>";

	}

	@RequestMapping("/python")
	public String python() {
		return "<h1>¡Python/Django fue increíble!</h1>";

	}

	@RequestMapping("/java")
	public String spring() {
		return "<h1>¡Java/Spring es mejor!</h1>";

	}
}