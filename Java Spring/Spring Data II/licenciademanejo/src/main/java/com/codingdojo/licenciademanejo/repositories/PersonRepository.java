package com.codingdojo.licenciademanejo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.licenciademanejo.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	// Este método recupera todas las licencias de la base de datos
	List<Person> findAll();

	// Este método encuentra una persona que contenga una cadena de texto específica en su nombre.
	List<Person> findByfirstNameContaining(String search);
}
