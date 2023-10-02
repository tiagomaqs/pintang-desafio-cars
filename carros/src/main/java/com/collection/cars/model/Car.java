package com.collection.cars.model;

import com.collection.cars.controller.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "ano")
	private Integer year;
	private String licensePlate;
	private String model;
	private String color;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	public CarDTO toCarDTO() {
		CarDTO carTemp = new CarDTO();
		carTemp.setId(getId());
		carTemp.setYear(getYear());
		carTemp.setLicensePlate(getLicensePlate());
		carTemp.setModel(getModel());
		carTemp.setColor(getColor());
		return carTemp;
	}
}
