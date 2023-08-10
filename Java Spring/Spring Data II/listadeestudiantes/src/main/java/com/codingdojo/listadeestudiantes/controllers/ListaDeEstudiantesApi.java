package com.codingdojo.listadeestudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.listadeestudiantes.models.Contact;
import com.codingdojo.listadeestudiantes.models.Student;
import com.codingdojo.listadeestudiantes.services.ContactService;
import com.codingdojo.listadeestudiantes.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class ListaDeEstudiantesApi {
	@Autowired
	private final StudentService studentService;
	@Autowired
	private final ContactService contactService;

	public ListaDeEstudiantesApi(StudentService studentService, ContactService contactService) {
		this.studentService = studentService;
		this.contactService = contactService;
	}

	// Métodos GET.

	@GetMapping("/students/new")
	public String createStudentGet(@ModelAttribute("student") Student student) {
		return "student.jsp";
	}

	@GetMapping("/contacts/new")
	public String createContact(Model model, @ModelAttribute("contact") Contact contact) {
		List<Student> students = studentService.allStudent();
		Student student = new Student();
		String fullName = student.getFullName();

		model.addAttribute("fullName", fullName);
		model.addAttribute("students", students);
		return "contact.jsp";
	}

	// Métodos POST.

	@PostMapping("/students/new")
	public String createStudentsPost(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return result.toString();
		} else {
			if ("John".equals(student.getFirstName()) && "Doe".equals(student.getLastName())
					&& student.getAge() == 35) {
				studentService.create3Student(student);
			} else {
				studentService.createStudent(student);
			}
			return "redirect:/api/students/new";
		}
	}

	@PostMapping("/contacts/new")
	public String createContactsPost(@Valid @ModelAttribute("contactinfo") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return result.toString();
		} else {
			contactService.createContact(contact);
			return "redirect:/api/contacts/new";
		}
	}
}
