package com.codingdojo.holahumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HolahumanoController {
	@RequestMapping("")
	public String index(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastName", required = false) String lastname) {
		// Si no se entrega un nombre, retorna "Hola Humano!".
		if (name == null) {
			return "<h1>Hola Humano!</h1><br>Bienvenid@ a Spring Boot!";
		} else {
			// Caso contrario, retorna "Hola (nombre)!".
			String greeting = "<h1>Hola " + name;
			if (lastname != null && !lastname.isEmpty()) {
				// Se comprueba que se haya entregado un apellido. De haber, se retorna Hola
				// (nombre) (apellido)!.
				greeting += " " + lastname;
			}
			greeting += "!</h1><br>Bienvenid@ a Spring Boot!";
			return greeting;
		}
	}
}

// Para comprobar, utiliza "http://localhost:(puerto)/?name=John&lastName=Doe" en la URL.
