package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	public Tag findtagById(Long id) {
		Optional<Tag> optTag = tagRepository.findById(id);
		if (optTag.isPresent()) {
			return optTag.get();
		} else {
			return null;
		}
	}

	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}

	public Tag updatetag(Tag tag) {
		return tagRepository.save(tag);
	}

	public void deletetag(Long id) {
		tagRepository.deleteById(id);
	}

	public Tag findTagBySubject(String tagName) {
		return tagRepository.findBySubject(tagName);
	}

}