package com.codingdojo.mostrarlafecha;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MostrarlafechaController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String fecha(Model model) {
		// Obtener la fecha actual
		LocalDate fechaActual = LocalDate.now();

		// Crear un objeto DateTimeFormatter con el formato deseado
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM, yyyy");

		// Obtener la fecha actual formateada en el formato deseado como una cadena
		String fechaFormateada = fechaActual.format(formatoFecha);

		// Añadir atributo para luego retornarlo en el JSP
		model.addAttribute("fechaFormateada", fechaFormateada);

		return "date.jsp";
	}

	@RequestMapping("/time")
	public String tiempo(Model model) {
		// Obtener la hora actual
		LocalTime horaActual = LocalTime.now();

		// Crear un objeto DateTimeFormatter con el formato deseado
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("h:mm a");

		// Obtener la hora actual formateada en inglés como una cadena
		String horaFormateada = horaActual.format(formatoHora);

		// Añadir atributo para luego retornarlo en el JSP
		model.addAttribute("horaFormateada", horaFormateada);

		return "time.jsp";
	}
}
