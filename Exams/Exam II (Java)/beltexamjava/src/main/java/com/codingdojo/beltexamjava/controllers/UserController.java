package com.codingdojo.beltexamjava.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.beltexamjava.models.Rating;
import com.codingdojo.beltexamjava.models.Show;
import com.codingdojo.beltexamjava.models.User;
import com.codingdojo.beltexamjava.services.RatingService;
import com.codingdojo.beltexamjava.services.ShowService;
import com.codingdojo.beltexamjava.services.UserService;
import com.codingdojo.beltexamjava.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ShowService showService;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private RatingService ratingService;

	// Métodos GET.

	@GetMapping("/")
	public String registerLogin(@ModelAttribute("user") User user, HttpSession session, Model model) {
		String errorMessage = (String) session.getAttribute("error");
		if (errorMessage != null) {
			model.addAttribute("error", errorMessage);
			session.removeAttribute("error"); // Elimina el mensaje de error de login tras refrescar el sitio.
		}
		String successMessage = (String) session.getAttribute("success");
		if (successMessage != null) {
			model.addAttribute("success", successMessage);
			session.removeAttribute("success"); // Elimina el mensaje de éxito en el registro tras refrescar el sitio.
		}
		return "/Views/loginRegister.jsp";
	}

	@GetMapping("/shows")
	public String home(HttpSession session, Model model) {
		// Comparación para ordenar rating de forma descendente.
		Long uID = (Long) session.getAttribute("userId");
		User user = userService.findUserById(uID);
		List<Show> shows = showService.allShow();
		Collections.sort(shows, (show1, show2) -> Double.compare(show2.avg(), show1.avg()));
		model.addAttribute("shows", shows);
		model.addAttribute("user", user);
		return "/Views/allShows.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/shows/new")
	public String createForm(Model model, @ModelAttribute("show") Show show, HttpSession session) {
		Long uID = (Long) session.getAttribute("userId");
		userService.findUserById(uID);
		return "/Views/newShow.jsp";

	}

	@GetMapping(value = "/shows/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("rating") Rating rating) {
		// Comparación para ordenar rating de forma ascendente.
		Long uID = (Long) session.getAttribute("userId");
		User user = userService.findUserById(uID);
		Show show = showService.findShow(id);
		List<Rating> ratings = new ArrayList<>(show.getRatings());
		Collections.sort(ratings, Comparator.comparingDouble(Rating::getRating));
		model.addAttribute("ratings", ratings);
		model.addAttribute("user", user);
		model.addAttribute("show", show);

		return "/Views/viewShow.jsp";
	}

	@GetMapping(value = "/shows/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Show show = showService.findShow(id);
		Long currentUser = (Long) session.getAttribute("userId");
		// Condición para que los usuarios no puedan editar shows que no hayan creado.
		if (show != null && show.getUser() != null && currentUser != null
				&& currentUser.equals(show.getUser().getId())) {
			model.addAttribute("show", show);
			return "/Views/editShow.jsp";
		} else {
			return "redirect:/shows";
		}
	}

	// Métodos POST.

	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "/Views/loginRegister.jsp";
		} else {
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			session.setAttribute("success", "Succesfully registered!");
		}
		return "redirect:/";
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean Authentified = userService.authenticateUser(email, password);
		if (Authentified) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		} else {
			session.setAttribute("error", "Incorrect email/password. Please try again.");
			return "redirect:/";
		}
	}

	@PostMapping("/shows/new")
	public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "/Views/newShow.jsp";
		}

		if (showService.showExists(show.getName())) {
			model.addAttribute("showExistsError", "El show ya existe.");
			return "/Views/newShow.jsp";
		}

		Long uID = (Long) session.getAttribute("userId");
		userService.findUserById(uID).getName();
		showService.createShow(show);
		return "redirect:/shows";
	}

	@PostMapping("/shows/{id}/edit")
	public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session,
			@PathVariable("id") Long id) {

		if (result.hasErrors()) {
			return "/Views/editShow.jsp";
		} else {

			Show editedShow = showService.findShow(id);
			Long userId = (Long) session.getAttribute("userId");
			userService.findUserById(userId).getName();
			editedShow.setName(show.getName());
			editedShow.setNetwork(show.getNetwork());
			showService.updateShow(editedShow);
			return "redirect:/shows/" + editedShow.getId();
		}
	}

	@PostMapping("/shows/{id}/rate")
	public String rateShow(@Valid @PathVariable("id") Long showId, @RequestParam("rating") Double rating,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		Show show = showService.findShow(showId);
		Rating newRating = new Rating();
		newRating.setRating(rating);
		newRating.setShow(show);
		newRating.setUser(user);
		ratingService.createRating(newRating);
		return "redirect:/shows/" + showId;
	}

	@RequestMapping(value = "/shows/{id}/delete", method = RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
		showService.deleteShow(id);
		return "redirect:/shows";
	}

}
