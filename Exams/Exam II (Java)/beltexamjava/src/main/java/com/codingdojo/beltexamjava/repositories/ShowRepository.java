package com.codingdojo.beltexamjava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexamjava.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {

	// Método para encontrar todos los shows.
	List<Show> findAll();

	boolean existsByName(String name);

}
