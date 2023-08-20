package com.codingdojo.beltexamjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.beltexamjava.models.Show;
import com.codingdojo.beltexamjava.repositories.ShowRepository;

@Service
public class ShowService {
	private final ShowRepository showRepository;
	
	// Método para importar CRUD en ShowService.

	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}
	
	// Método para encontrar todos los shows en la lista.

	public List<Show> allShow() {
		return showRepository.findAll();
	}
	
	// Método para crear un show.

	public Show createShow(Show show) {
		return showRepository.save(show);
	}
	
	// Método para encontrar un show por ID.

	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	// Método para editar un show.

	public Show updateShow(Show show) {
		Optional<Show> optionalShow = showRepository.findById(show.getId());
		if (optionalShow.isPresent()) {
			Show s = optionalShow.get();
			s.setName(show.getName());
			s.setNetwork(show.getNetwork());
			return showRepository.save(s);
		} else {
			return null;
		}
	}
	
	// Método para eliminar un show.

	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	// Método para comprobar si un show existe.
	
	public boolean showExists(String showTitle) {
		return showRepository.existsByName(showTitle);
	}

}
