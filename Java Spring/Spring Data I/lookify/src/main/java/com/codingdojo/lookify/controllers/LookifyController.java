package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepository;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	@Autowired
	LookifyRepository lookifyRepository;
	@Autowired
	LookifyService lookifyService;

	@GetMapping("/")
	public String index() {
		return "/Views/index.jsp";
	}

	@GetMapping("/songs/new")
	public String newsong() {
		return "/Views/newSong.jsp";
	}

	@GetMapping("/songs/{id}")
	public String newsong(@PathVariable("id") Long id, Model model) {
		Lookify song = lookifyService.getSongById(id);
		model.addAttribute("song", song);
		return "/Views/songData.jsp";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> songs = lookifyService.getAllSongs();
		model.addAttribute("songs", songs);
		return "/Views/dashboard.jsp";
	}

	@PostMapping("/songs/searchbytitle")
	public String searchbytitle(@RequestParam("artist") String artist) {
		return "redirect:/search/" + artist;
	}

	@GetMapping("/search/topTen")
	public String seachtopten(Model model) {
		List<Lookify> topten = lookifyService.findTop10Songs();
		model.addAttribute("topten", topten);
		return "/Views/topten.jsp";
	}

	@GetMapping("/search/{name}")
	public String searchbytitle(@PathVariable("name") String name, Model model) {
		String queryName = name + "%";
		List<Lookify> artistObject = lookifyService.getArtistByName(queryName);
		model.addAttribute("artistObject", artistObject);
		model.addAttribute("name", name);
		return "/Views/dashboard2.jsp";
	}

	@PostMapping("/songs/create")
	public String createsong(@RequestParam("title") String title, @RequestParam("artist") String artist,
			@RequestParam("rating") int rating) {
		Lookify song = new Lookify();
		song.setArtist(artist);
		song.setRating(rating);
		song.setTitle(title);
		lookifyRepository.save(song);
		return "redirect:/songs/new";
	}

	@PostMapping("/songs/delete")
	public String createsong(@RequestParam("id") Long id) {
		lookifyRepository.deleteById(id);
		return "redirect:/dashboard";
	}
}