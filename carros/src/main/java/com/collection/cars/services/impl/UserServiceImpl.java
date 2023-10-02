package com.collection.cars.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.cars.controller.dto.UserDTO;
import com.collection.cars.model.User;
import com.collection.cars.repository.IUserRepository;
import com.collection.cars.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDTO insert(UserDTO userDTO) {
		User userTemp = userRepository.save(userDTO.toUser());
		return userTemp.toUserDTO();
	}
	
	@Override
	public UserDTO update(Long id, UserDTO userDTO) {
		Optional<User> userTemp = userRepository.findById(id);
		if (userTemp.isPresent()) {
			userDTO.setId(id);
			User userSaveTemp = userRepository.save(userDTO.toUser());
			return userSaveTemp.toUserDTO();
		} else {
			return null;
		}
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<User> userTemp = userRepository.findById(id);
		if (userTemp.isPresent()) {
			return userTemp.get().toUserDTO();
		} else {
			return null;
		}
	}
	
	@Override
	public List<UserDTO> findAll() {
		List<User> userTemp = userRepository.findAll();
		return userTemp.stream().map(u -> u.toUserDTO()).collect(Collectors.toList());
	}
	
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
