package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

	private final TagRepository tagRepository;

	public QuestionService(QuestionRepository questionRepository, TagRepository tagRepository) {
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
	}

	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	public Question findquestionById(Long id) {
		Optional<Question> optQuest = questionRepository.findById(id);
		if (optQuest.isPresent()) {
			return optQuest.get();
		} else {
			return null;
		}
	}

	@Transactional
	public Question createQuestion(Question question, String tagsString) {

		List<Tag> tags = parseTagsString(tagsString);

		question.setTags(tags);

		return questionRepository.save(question);
	}

	private List<Tag> parseTagsString(String tagsString) {
		List<Tag> tags = new ArrayList<>();
		String[] tagNames = tagsString.split(",");

		for (String tagName : tagNames) {
			Tag tag = tagRepository.findBySubject(tagName.trim());
			if (tag == null) {
				tag = new Tag(tagName.trim());
				tagRepository.save(tag);
			}
			tags.add(tag);
		}

		return tags;
	}

	public Question updatequestion(Question question) {
		return questionRepository.save(question);
	}

	public void deletequestion(Long id) {
		questionRepository.deleteById(id);
	}

}
