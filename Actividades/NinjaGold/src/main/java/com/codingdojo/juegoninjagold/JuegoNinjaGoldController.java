package com.codingdojo.juegoninjagold;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class JuegoNinjaGoldController {

	// Definición de variables:

	// Ganancias mínimas y máximas de la granja.
	private static final int min_Farm = 10;
	private static final int max_Farm = 20;
	// Ganancias mínimas y máximas de la cueva.
	private static final int min_Cave = 5;
	private static final int max_Cave = 10;
	// Ganancias mínimas y máximas de la casa.
	private static final int min_House = 2;
	private static final int max_House = 5;
	// Ganancia máxima y pérdida máxima del casino.
	private static final int min_Casino = -50;
	private static final int max_Casino = 50;
	// Pérdida mínima y máxima del spa.
	private static final int min_Spa = -20;
	private static final int max_Spa = -5;
	// Deuda máxima que puede tener el ninja.
	private static final int max_Debt = -100;
	
	// Método para generar un número random.
	public int randomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	@RequestMapping("/gold")
	public String index() {
		return "Views/index.jsp";
	}
	
	@RequestMapping("/prison")
	public String prison() {
		return "Views/prison.jsp";
	}

	@RequestMapping("/activities")
	public String realizarActividad(HttpSession session, Model model, String place) {
		Integer goldObj = (Integer) session.getAttribute("gold");
		int gold = goldObj != null ? goldObj.intValue() : 0;

		LocalDateTime now = LocalDateTime.now();
		String time = now.toString();

		int goldRevenue = 0;

		switch (place) {
		case "farm":
			goldRevenue = randomNumber(min_Farm, max_Farm);
			break;
		case "cave":
			goldRevenue = randomNumber(min_Cave, max_Cave);
			break;
		case "house":
			goldRevenue = randomNumber(min_House, max_House);
			break;
		case "casino":
			goldRevenue = randomNumber(min_Casino, max_Casino);
			break;
		case "spa":
			goldRevenue = randomNumber(min_Spa, max_Spa);
			break;
		default:
			break;
		}

		gold += goldRevenue;

		if (gold <= max_Debt) {
			return "redirect:/prison";
		}

		session.setAttribute("gold", gold);

		Activities activity = new Activities(place, goldRevenue, time);
		addActivity(session, activity);

		model.addAttribute("activities", getActivity(session));

		return "redirect:/gold";
	}

	private void addActivity(HttpSession session, Activities activity) {
		List<Activities> activities = getActivity(session);
		activities.add(activity);
		session.setAttribute("activities", activities);
	}

	private List<Activities> getActivity(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Activities> activities = (List<Activities>) session.getAttribute("activities");
		if (activities == null) {
			activities = new ArrayList<>();
		}
		return activities;
	}
	
	@RequestMapping("/reset")
	public String resetGold(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    session.setAttribute("gold", 0);
	    session.setAttribute("activities", null);
	    return "redirect:/gold"; // Redirecciona a la página principal después de restablecer el valor.
	}

}
