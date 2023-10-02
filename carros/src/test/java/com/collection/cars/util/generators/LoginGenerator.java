package com.collection.cars.util.generators;

import com.collection.cars.controller.dto.LoginDTO;

public class LoginGenerator {

	public static LoginDTO generateLogin() {
		return new LoginDTO("login", "password");
	}

	public static LoginDTO generateLoginWithError() {
		return new LoginDTO("login_error", "password_error");
	}
}
