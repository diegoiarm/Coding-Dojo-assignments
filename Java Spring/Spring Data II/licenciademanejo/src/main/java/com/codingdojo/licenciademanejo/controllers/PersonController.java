package com.codingdojo.licenciademanejo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.licenciademanejo.models.Person;
import com.codingdojo.licenciademanejo.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/persons/new")
	public String addPersonIndex(Model model, @ModelAttribute("person") Person person) {
		List<Person> persons = personService.allPersons();
		if (persons == null) {
			return "/Views/error.jsp";
		}
		model.addAttribute("persons", persons);
		return "/Views/newperson.jsp";
	}

	@RequestMapping("/persons/{id}")
	public String show(Model model, @PathVariable Long id, @ModelAttribute("person") Person person) {
		Person persons = personService.findPerson(id);
		if (persons == null) {
			return "/Views/error.jsp";
		} else {
			model.addAttribute("person", persons);
			return "/Views/showperson.jsp";
		}
	}

	@PostMapping(value = "/addperson")
	public String addPerson(@Valid @ModelAttribute("person") Person person, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/error";
		} else {
			personService.createPerson(person);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value = "/persons/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/error.jsp";
		} else {
			Person savedPerson = personService.createPerson(person);
			model.addAttribute("person", person);
			return "redirect:/persons/" + savedPerson.getId();
		}
	}

}