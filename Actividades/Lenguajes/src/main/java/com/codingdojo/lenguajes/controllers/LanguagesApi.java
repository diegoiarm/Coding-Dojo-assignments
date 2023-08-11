package com.codingdojo.lenguajes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lenguajes.models.Languages;
import com.codingdojo.lenguajes.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService languageService;

	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/api/languages")
	public List<Languages> index() {
		return languageService.allLanguages();
	}

	@RequestMapping(value = "/api/languages", method = RequestMethod.POST)
	public Languages create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
			@RequestParam(value = "version") String version) {
		Languages language = new Languages(name, creator, version);
		return languageService.createLanguage(language);
	}

	@RequestMapping("/api/languages/{id}")
	public Languages show(@PathVariable("id") Long id) {
		Languages language = languageService.findLanguage(id);
		return language;
	}

	@PutMapping("/api/languages/{id}")
	public Languages updateLanguage(@PathVariable Long id, @RequestParam String name, @RequestParam String creator,
			@RequestParam String version, Languages language) {
		Languages updatedLanguage = languageService.updateLanguage(language);
		return updatedLanguage;
	}

	@DeleteMapping("api/languages/{id}")
	public ResponseEntity<String> deleteLanguage(@PathVariable Long id) {
		languageService.deleteLanguage(id);
		return ResponseEntity.ok().body("Lenguaje eliminado exitosamente.");
	}
}