package com.codingdojo.lenguajes.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lenguajes.models.Languages;
import com.codingdojo.lenguajes.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguagesController {
	private final LanguageService languagesService;

	public LanguagesController(LanguageService languageService) {
		this.languagesService = languageService;
	}

	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("languages") Languages language) {
		List<Languages> languages = languagesService.allLanguages();
		if (languages == null) {
			return "/Views/error.jsp";
		}
		model.addAttribute("languageList", languages);
		return "/Views/index.jsp";
	}

	@PostMapping(value = "/add")
	public String addLanguage(@Valid @ModelAttribute("language") Languages language, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/error";
		} else {
			languagesService.createLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/new.jsp";
		} else {
			languagesService.createLanguage(language);
			model.addAttribute("language", language);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/languages/{id}")
	public String show(@PathVariable Long id, Model model) {
		Languages languages = languagesService.findLanguage(id);

		if (languages == null) {
			return "/Views/error.jsp";
		}

		model.addAttribute("language", languages);

		return "/Views/show.jsp";
	}

	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Languages language = languagesService.findLanguage(id);
		model.addAttribute("language", language);
		return "/Views/edit.jsp";
	}

	@RequestMapping(value = "/languages/edit/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @Valid @ModelAttribute("language") Languages language,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/edit.jsp";
		} else {
			languagesService.updateLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value = "/languages/delete/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Languages language) {
		if (id == null) {
			return "/Views/error.jsp";
		} else {
			languagesService.deleteLanguage(id);
		}
		return "redirect:/languages";
	}
}