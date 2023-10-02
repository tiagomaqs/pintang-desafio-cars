package com.collection.cars.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.collection.cars.util.generators.LoginGenerator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(3)
class TestLoginController {
	
	@LocalServerPort
    int port;

	@BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }
	
	@Test
	@Order(1)
	void testLoginWithError() {
		RestAssured.given().body(LoginGenerator.generateLoginWithError()).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(HttpStatus.UNAUTHORIZED.value());
	}
	
	@Test
	@Order(2)
	void testLoginWithSuccess() {
		RestAssured.given().body(LoginGenerator.generateLogin()).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().statusCode(HttpStatus.OK.value());
	}

}