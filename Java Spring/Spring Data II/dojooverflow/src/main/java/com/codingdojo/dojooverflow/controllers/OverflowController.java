package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/questions")
public class OverflowController {

	@Autowired
	private final AnswerService answerService;
	@Autowired
	private final QuestionService questionService;
	@Autowired
	private final TagService tagService;

	public OverflowController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.answerService = answerService;
		this.questionService = questionService;
		this.tagService = tagService;
	}

	@GetMapping("")
	public String getIndex(Model model) {
		List<Question> questions = questionService.findAll();
		model.addAttribute("questions", questions);
		return "/Views/dashboard.jsp";
	}

	@GetMapping("/new")
	public String getFormQuestion(Model model) {
		Question question = new Question();
		question.setTags(new ArrayList<>());

		model.addAttribute("question", new Question());
		return "/Views/questionForm.jsp";
	}

	@GetMapping("{id}")
	public String showQuestion(@PathVariable("id") Long questionId, Model model) {

		Question question = questionService.findquestionById(questionId);

		if (question == null) {

			return "error";
		}

		List<Answer> answers = answerService.findAnswerByQuestionId(questionId);

		model.addAttribute("question", question);
		model.addAttribute("answers", answers);

		model.addAttribute("answer", new Answer());

		return "/Views/questionAnswer.jsp";
	}

	@PostMapping("/new")
	public String postNewQuestion(@ModelAttribute("question") Question question, Model model) {
		try {
			Question newQuestion = questionService.createQuestion(question, question.getTagsInput());
			return "redirect:/questions/" + newQuestion.getId();
		} catch (Exception e) {
			model.addAttribute("error", "Error creating question: " + e.getMessage());
			System.out.println("Error creating question: " + e.getMessage());
			return "/Views/questionForm.jsp";
		}
	}

	@PostMapping("/{id}/post")
	public String postNewAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result,
			@PathVariable(value = "id") Long id, Model model) {
		if (result.hasErrors()) {
			return "redirect:/questions/" + id;
		} else {
			answer.setQuestion(questionService.findquestionById(id));
			Answer newAnswer = new Answer();
			newAnswer.setAnswerText(answer.getAnswerText());
			newAnswer.setQuestion(answer.getQuestion());

			answerService.createAnswer(newAnswer);

			List<Answer> updatedAnswers = answerService.findAnswerByQuestionId(id);

			model.addAttribute("answers", updatedAnswers);

			Question question = questionService.findquestionById(id);
			model.addAttribute("question", question);

			return "/Views/questionAnswer.jsp";
		}
	}

}