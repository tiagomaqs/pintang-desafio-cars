package com.collection.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collection.cars.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
