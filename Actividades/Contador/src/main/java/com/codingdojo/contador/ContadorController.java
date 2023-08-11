package com.codingdojo.contador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ContadorController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {

		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			// Si el contador no existe en la sesión, establecerlo a 0.
			count = 0;
		}

		count++;

		// Se reestablece el contador mediante un setAttribute para incluir count++.

		session.setAttribute("count", count);
		model.addAttribute("count", count);

		return "index.jsp";
	}

	@RequestMapping("/doublevisit")
	public String doublevisit(HttpSession session, Model model) {

		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			// Si el contador no existe en la sesión, establecerlo a 0.
			count = 0;
		}

		count += 2;

		// Se reestablece el contador mediante un setAttribute para incluir count++.

		session.setAttribute("count", count);
		model.addAttribute("count", count);

		return "doublevisit.jsp";
	}

	
	@RequestMapping("/reset")
	public String resetCounter(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    session.setAttribute("count", 0);
	    return "redirect:/counter"; // Redirecciona a la página del contador después de restablecer el valor.
	}

	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}

}
