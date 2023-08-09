package com.codingdojo.mostrar.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mostrar.models.Book;

@Repository
	public interface BookRepository extends CrudRepository<Book, Long>{
	    //Este método recupera todos los libros de la base de datos
	    List<Book> findAll();
	    //Este método encuentra un libro por su descripción
	    List<Book> findByDescriptionContaining(String search);
	    //Este método cuenta cuántos libros contiene cierta cadena en el título
	    Long countByTitleContaining(String search);
	    //Este método borra un libro que empieza con un título específico
	    Long deleteByTitleStartingWith(String search);
	}
	
