package com.codingdojo.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lenguajes.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository<Languages, Long> {
	// Este método recupera todos los libros de la base de datos
	List<Languages> findAll();

	// Este método encuentra un lenguaje por su creador;
	List<Languages> findByCreatorContaining(String search);

	// Este método cuenta cuántos lenguajes contiene cierta cadena en el título
	Long countByNameContaining(String search);

	// Este método borra un lenguaje que empieza con un título específico
	Long deleteByNameStartingWith(String search);
}
