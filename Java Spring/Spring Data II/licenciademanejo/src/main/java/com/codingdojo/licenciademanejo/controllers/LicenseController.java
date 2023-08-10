package com.codingdojo.licenciademanejo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.licenciademanejo.models.License;
import com.codingdojo.licenciademanejo.models.Person;
import com.codingdojo.licenciademanejo.services.LicenseService;
import com.codingdojo.licenciademanejo.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;

	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}

	@RequestMapping("/licenses/new")
	public String addLicenseIndex(Model model, @ModelAttribute("license") License license) {
		List<License> licenses = licenseService.allLicenses();
		if (licenses == null) {
			return "/Views/error.jsp";
		}
		List<Person> allPersons = personService.allPersons(); // Obtener la lista de todas las personas

		Person person = new Person();
		String fullName = person.getFullName();

		license = new License();
		model.addAttribute("fullName", fullName);
		model.addAttribute("allPersons", allPersons); // Agregar la lista de personas al modelo
		model.addAttribute("license", license);

		return "/Views/newlicense.jsp";
	}

	@PostMapping(value = "/addlicense")
	public String addLicense(@Valid @ModelAttribute("license") License license, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/error";
		} else {
			licenseService.createLicense(license);
			return "redirect:/licenses";
		}
	}

	@RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License license, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/error.jsp";
		} else {
			// Guardar la nueva licencia
			License savedLicense = licenseService.createLicense(license);
			model.addAttribute("license", license);
			return "redirect:/licenses/" + savedLicense.getId();
		}
	}

}