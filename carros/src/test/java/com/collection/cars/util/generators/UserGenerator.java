package com.collection.cars.util.generators;

import java.util.ArrayList;
import java.util.Date;

import com.collection.cars.controller.dto.CarDTO;
import com.collection.cars.controller.dto.UserDTO;

public class UserGenerator {

	public static UserDTO generateNewUser() {
		return new UserDTO(null, "name", "lastName", "email", new Date(), "login", "password", "phone", new ArrayList<CarDTO>());
	}
	
	public static UserDTO generateNewUserBlank() {
		return new UserDTO(null, "", "", "", new Date(), "", "", "", new ArrayList<CarDTO>());
	}
	
	public static UserDTO generateNewUserNull() {
		return new UserDTO(null, null, null, null, null, null, null, null, null);
	}
}
