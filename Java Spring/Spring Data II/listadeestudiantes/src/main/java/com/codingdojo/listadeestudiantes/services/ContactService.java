package com.codingdojo.listadeestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.listadeestudiantes.models.Contact;
import com.codingdojo.listadeestudiantes.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	// Obtener todos los contactos.
	public List<Contact> allContact() {
		return contactRepository.findAll();
	}


	// Obtener contacto existente por ID.
	public Optional<Contact> findById(Long id) {
		return contactRepository.findById(id);
	}

	// Crear o actualizar.
	public Contact createContact(Contact c) {
		return contactRepository.save(c);
	}

	// Eliminar.
	public void deleteCategory(Long id) {
		contactRepository.deleteById(id);
	}

}
