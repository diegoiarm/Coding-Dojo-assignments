package com.codingdojo.listadeestudiantes.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.listadeestudiantes.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

	// Método para encontrar todos los contactos.
	List<Contact> findAll();

}