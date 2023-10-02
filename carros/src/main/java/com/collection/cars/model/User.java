package com.collection.cars.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.collection.cars.controller.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	private String login;
	private String password;
	private String phone;
	@OneToMany(mappedBy = "user")
	private List<Car> cars;

	public UserDTO toUserDTO() {
		UserDTO userTemp = new UserDTO();
		userTemp.setId(getId());
		userTemp.setFirstName(getFirstName());
		userTemp.setLastName(getLastName());
		userTemp.setEmail(getEmail());
		userTemp.setBirthday(getBirthday());
		userTemp.setLogin(getLogin());
		userTemp.setPassword(getPassword());
		userTemp.setPhone(getPhone());
		userTemp.setCars(getCars().stream().map(c -> c.toCarDTO()).collect(Collectors.toList()));
		return userTemp;
	}
}
