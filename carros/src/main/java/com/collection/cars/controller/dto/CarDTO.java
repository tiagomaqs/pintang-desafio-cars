package com.collection.cars.controller.dto;

import com.collection.cars.model.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	private Long id;
	private Integer year;
	private String licensePlate;
	private String model;
	private String color;
	
	public Car toCar() {
		Car carTemp = new Car();
		carTemp.setId(getId());
		carTemp.setYear(getYear());
		carTemp.setLicensePlate(getLicensePlate());
		carTemp.setModel(getModel());
		carTemp.setColor(getColor());
		return carTemp;
	}
}