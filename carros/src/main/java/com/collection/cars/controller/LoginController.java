package com.collection.cars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collection.cars.controller.dto.LoginDTO;

@RestController
public class LoginController {

	@GetMapping("/pessoa")
	public String signin() {
		return "Helloe mm";
	}
	
	@PostMapping("/signin")
	@ResponseBody
	public void signin(LoginDTO loginDTO) {

	}
}
