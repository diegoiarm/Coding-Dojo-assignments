package com.codingdojo.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/dojo")
	public String dojo() {
		return "<h1>¡El Dojo es increíble!</h1>";

	}

	@RequestMapping("/burbank-dojo")
	public String burbank() {
		return "<h1>El Dojo Burbank está localizado al sur de California.</h1>";

	}

	@RequestMapping("/san-jose")
	public String sanjose() {
		return "<h1>El Dojo SJ es el cuartel general.</h1>";

	}
}
