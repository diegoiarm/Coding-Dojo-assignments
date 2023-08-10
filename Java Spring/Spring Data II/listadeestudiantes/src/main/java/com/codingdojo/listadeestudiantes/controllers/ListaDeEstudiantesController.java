package com.codingdojo.listadeestudiantes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.codingdojo.listadeestudiantes.models.Contact;
import com.codingdojo.listadeestudiantes.models.Student;
import com.codingdojo.listadeestudiantes.services.ContactService;
import com.codingdojo.listadeestudiantes.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class ListaDeEstudiantesController {
	
	private final ContactService contactService;
	private final StudentService studentService;

	public ListaDeEstudiantesController(ContactService contactService, StudentService studentService) {
		this.contactService = contactService;
		this.studentService = studentService;

	}

	@RequestMapping("/students")
	public String index(Model model, @ModelAttribute("student") Student student) {
		List<Student> students = studentService.allStudent();
		List<Contact> contacts = contactService.allContact();
		model.addAttribute("studentInfo", students);
		model.addAttribute("contactInfo", contacts);
		return "/Views/index.jsp";
	}
	
	@RequestMapping("/students/new")
	public String student(Model model, @ModelAttribute("student") Student student) {
		return "/Views/student.jsp";
	}
	
	@RequestMapping(value = "/students/new", method = RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/error.jsp";
		} else {
			studentService.createStudent(student);
			model.addAttribute("student", student);
			return "redirect:/contact/new";
		}
	}
	
	@RequestMapping("/contact/new")
	public String contact(Model model, @ModelAttribute("contact") Contact contact) {
	    List<Student> allStudents = studentService.allStudent();
	    model.addAttribute("allStudents", allStudents);
	    
		return "/Views/contact.jsp";
	}
	
	@RequestMapping(value = "/contact/new", method = RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/error.jsp";
		} else {
	        Contact savedContact = contactService.createContact(contact);
	        
	        // Actualizar el objeto savedContact con el estudiante asociado
	        savedContact.setStudent(studentService.findById(contact.getStudent().getId()).orElse(null));
	        return "redirect:/students";
		}
	}
	
	
}
