package com.collection.cars.services;

import java.util.List;

import com.collection.cars.controller.dto.UserDTO;

public interface IUserService {

	UserDTO insert(UserDTO userDTO);

	UserDTO findById(Long id);

	List<UserDTO> findAll();

	void deleteById(Long id);

	UserDTO update(Long id, UserDTO userDTO);

}
