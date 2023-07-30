package com.codingdojo.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}
	
	@RequestMapping("/")
	public String holacliente() {
		return "<h1>Hola cliente! ¿Cómo va todo?</h1>";
		
	}

	@RequestMapping("/random")
	public String springbootpulento() {
		return "<h1>Spring Boot es pulentoooo!</h1>";
		
	}
	
	
}
