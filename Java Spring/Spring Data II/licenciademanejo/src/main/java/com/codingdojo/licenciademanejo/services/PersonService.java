package com.codingdojo.licenciademanejo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.licenciademanejo.models.Person;
import com.codingdojo.licenciademanejo.repositories.PersonRepository;

@Service
public class PersonService {
	// Agregando la licencia al repositorio como una dependencia.
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	// Devolviendo todas las personas.
	public List<Person> allPersons() {
		return personRepository.findAll();
	}

	// Creando una persona.
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}

	// Obteniendo la información de una persona.
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}

//	// Actualizar una licencia.
//	public License updateLicense(License license) {
//		Optional<License> optionalLicense = licenseRepository.findById(license.getId());
//
//		if (optionalLicense.isPresent()) {
//			License existingLicense = optionalLicense.get();
//			existingLicense.setPerson(license.getName());
//			existingLicense.setState(license.getState());
//			existingLicense.setVersion(license.getVersion());
//
//			return licenseRepository.save(existingLicense);
//		} else {
//			throw new IllegalArgumentException("No se ha encontrado ninguna licencia con el ID entregado.");
//		}
//	}

	// Eliminar una persona.
	public void deletePerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);

		if (optionalPerson.isPresent()) {
			Person person = optionalPerson.get();
			person.getId();
			personRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ninguna persona con el ID entregado.");
		}
	}
}
