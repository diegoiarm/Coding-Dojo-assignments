package com.codingdojo.listadeestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.listadeestudiantes.models.Student;
import com.codingdojo.listadeestudiantes.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// Obtener todos los estudiantes.
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}
	
	// Obtener estudiante existente por ID.
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}
	
	
	// Obtener estudiante null.
	public List<Student> nullStudent() {
        return studentRepository.findByContactIsNull();
    }

	// Crear estudiante.
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	
	// Crear 3 estudiantes.
	public void create3Student(Student s) {
		Student student1 = new Student(s.getFirstName(), s.getLastName(), s.getAge());
	    Student student2 = new Student(s.getFirstName(), s.getLastName(), s.getAge());
	    Student student3 = new Student(s.getFirstName(), s.getLastName(), s.getAge());

	    studentRepository.save(student1);
	    studentRepository.save(student2);
	    studentRepository.save(student3);
		
	}

	// Eliminar estudiante.
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}