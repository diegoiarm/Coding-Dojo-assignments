package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	
	// Busca todas las canciones en la database.
	List<Lookify> findAll();
	
	// Busca las canciones por nombre del artista.
	@Query(value="SELECT * FROM songs where artist like ?1", nativeQuery=true)
    List<Lookify> findArtistByName(String name);
	
	// Encuentra 10 canciones en orden de rating descendiente.
	@Query(value="SELECT * FROM songs order by rating desc limit 10", nativeQuery=true)
    List<Lookify> findTop10Songs();
	
}
