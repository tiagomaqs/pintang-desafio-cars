package com.collection.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collection.cars.model.Car;

public interface ICarRepository extends JpaRepository<Car, Long>{

}
