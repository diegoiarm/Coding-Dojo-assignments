package com.codingdojo.beltexamjava.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexamjava.models.User;
import com.codingdojo.beltexamjava.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Método para registrar a un usuario utilizando bCrypt en la contraseña.

	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}

	// Método para encontrar a un usuario por su email.
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	// Método para encontrar a un usuario por su ID.

	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	
	// Método para autenticar a un usuario usando bCrypt.
	
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return false;
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
