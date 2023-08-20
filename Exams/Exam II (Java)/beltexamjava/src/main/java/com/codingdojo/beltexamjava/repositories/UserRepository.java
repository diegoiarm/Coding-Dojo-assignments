package com.codingdojo.beltexamjava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltexamjava.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// Encontrar usuario por nombre.
	User findByName(String name);

	// Encontrar usuario por email.
	User findByEmail(String email);

}
