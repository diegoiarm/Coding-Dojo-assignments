package com.codingdojo.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lenguajes.models.Languages;
import com.codingdojo.lenguajes.repositories.LanguageRepository;

@Service
public class LanguageService {
	// Agregando el lenguaje al repositorio como una dependencia.
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// Devolviendo todos los lenguajes.
	public List<Languages> allLanguages() {
		return languageRepository.findAll();
	}

	// Creando un lenguaje.
	public Languages createLanguage(Languages l) {
		return languageRepository.save(l);
	}

	// Obteniendo la información de un lenguaje.
	public Languages findLanguage(Long id) {
		Optional<Languages> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	// Actualizar un lenguaje.
	public Languages updateLanguage(Languages language) {
		Optional<Languages> optionalLanguage = languageRepository.findById(language.getId());

		if (optionalLanguage.isPresent()) {
			Languages existingLanguage = optionalLanguage.get();
			existingLanguage.setName(language.getName());
			existingLanguage.setCreator(language.getCreator());
			existingLanguage.setVersion(language.getVersion());

			return languageRepository.save(existingLanguage);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ningún lenguaje con el ID entregado.");
		}
	}

	// Eliminar un lenguaje.
	public void deleteLanguage(Long id) {
		Optional<Languages> optionalLanguage = languageRepository.findById(id);

		if (optionalLanguage.isPresent()) {
			Languages language = optionalLanguage.get();
			language.getId();
			languageRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ningún lenguaje con el ID entregado.");
		}
	}
}
