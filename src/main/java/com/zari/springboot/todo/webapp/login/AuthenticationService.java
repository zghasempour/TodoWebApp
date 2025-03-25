package com.zari.springboot.todo.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name, String password) {
		boolean isNameValid = name.equalsIgnoreCase("zahra");
		boolean isPasswordValid = password.equalsIgnoreCase("zari");
		return isNameValid && isPasswordValid;
	}
}
