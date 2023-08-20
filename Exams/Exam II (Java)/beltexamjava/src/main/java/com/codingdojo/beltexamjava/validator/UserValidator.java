package com.codingdojo.beltexamjava.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.beltexamjava.models.User;

@Component
public class UserValidator implements Validator {

	// Se verifica si el validador es compatible con la clase User.
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	// Validación para que la contraseña y su respectiva confirmación coincidan.

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}
