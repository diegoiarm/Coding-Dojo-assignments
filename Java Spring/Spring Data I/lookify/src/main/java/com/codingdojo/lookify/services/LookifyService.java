package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	@Autowired
	LookifyRepository lookifyRepository;
	
    public List<Lookify> getAllSongs() {
        return lookifyRepository.findAll();
    }

    public Lookify getSongById(Long id) {
        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    
    public List<Lookify> getArtistByName(String name) {
    	return lookifyRepository.findArtistByName(name);
    }
    
    public List<Lookify> findTop10Songs() {
    	return lookifyRepository.findTop10Songs();
    }
}