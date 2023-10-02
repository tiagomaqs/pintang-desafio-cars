package com.collection.cars.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.collection.cars.model.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	private String phone;
	private List<CarDTO> cars;

	public User toUser() {
		User userTemp = new User();
		userTemp.setId(getId());
		userTemp.setFirstName(getFirstName());
		userTemp.setLastName(getLastName());
		userTemp.setEmail(getEmail());
		userTemp.setBirthday(getBirthday());
		userTemp.setLogin(getLogin());
		userTemp.setPassword(getPassword());
		userTemp.setPhone(getPhone());
		if (getCars() != null) {
			userTemp.setCars(getCars().stream().map(c -> c.toCar()).collect(Collectors.toList()));
		}
		return userTemp;
	}
}