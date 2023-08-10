package com.codingdojo.listadeestudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.listadeestudiantes.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{
	
	// Método para encontrar todos los estudiantes.
	List<Student> findAll();
	
	// Método para encontrar estudiantes según ID.
	Optional<Student> findStudentById(Long id);
	
	// Método para encontrar contactos null.
	List<Student> findByContactIsNull();


}