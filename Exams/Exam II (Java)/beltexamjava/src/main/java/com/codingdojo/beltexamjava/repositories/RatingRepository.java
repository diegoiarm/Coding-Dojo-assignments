package com.codingdojo.beltexamjava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexamjava.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	
	// Consulta SQL para obtener nombre y rating por ID.

	@Query("SELECT u.name, r.rating FROM Rating r JOIN r.user u WHERE r.show.id = :showId")
	List<Object[]> nameAndRatingById(Long showId);
	
	// Consulta SQL para obtener promedios redondeados a 1 decimal.

	@Query("SELECT ROUND(AVG(r.rating), 1) FROM Rating r WHERE r.show.id = :showId")
	List<Double> averageRating(Long showId);

}
