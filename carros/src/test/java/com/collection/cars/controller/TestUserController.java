package com.collection.cars.controller;

import static io.restassured.RestAssured.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.collection.cars.util.generators.UserGenerator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(2)
class TestUserController {
	private static long idUser = 1;
	
	@LocalServerPort
    int port;

	@BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }
	
	@Test
	@Order(1)
	void testInsertUserWithError() {
		RestAssured.given().body(UserGenerator.generateNewUserNull()).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());

		RestAssured.given().body(UserGenerator.generateNewUserBlank()).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		
	}
	
	@Test
	@Order(2)
	void testInsertUserWithSuccess() {
		RestAssured.given().body(UserGenerator.generateNewUser()).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	@Order(3)
	void testFindUserWithSuccess() {
		when().get("/api/users/"+idUser)
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	@Order(4)
	void testFindUserNotExist() {
		when().get("/api/users/"+1000)
		.then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	@Order(5)
	void testListUsersWithSuccess() {
		when().get("/api/users")
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	@Order(6)
	void testUpdateUserWithSuccess() {
		RestAssured.given().body(UserGenerator.generateNewUser()).contentType(ContentType.JSON)
		.when().put("/api/users/"+idUser)
		.then().statusCode(HttpStatus.OK.value());
	}
}