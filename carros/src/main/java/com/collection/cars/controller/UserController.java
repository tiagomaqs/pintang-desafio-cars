package com.collection.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collection.cars.controller.dto.UserDTO;
import com.collection.cars.services.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>>  findAll() {
		List<UserDTO> userDTO = userService.findAll();
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
		UserDTO userDTO = userService.findById(id);
		if (userDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		}
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserDTO userDTO) {
		userDTO = userService.insert(userDTO);
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO) {
		userDTO = userService.update(id, userDTO);
		if (userDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}

}
