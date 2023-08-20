package com.codingdojo.beltexamjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexamjava.models.Rating;
import com.codingdojo.beltexamjava.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	// Método para encontrar rating según ID del show.

	public List<Object[]> getRatingByShowId(Long showId) {
		List<Object[]> ratings = ratingRepository.nameAndRatingById(showId);
		return ratings;
	}
	
	// Método para encontrar rating promedio según ID del show.

	public List<Double> findByAverageRating(Long showId) {
		List<Double> average = ratingRepository.averageRating(showId);
		return average;
	}
	
	// Método para añadir un rating.

	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

}
