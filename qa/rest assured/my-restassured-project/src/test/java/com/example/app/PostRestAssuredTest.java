package com.example.app;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

class PostRestAssuredTest {
	
	// Caution when pass Post per String
	
	@Test
	void addUserString() {
		String email = "teste_" + "lalala" + "@gmail.com";
		String user = 	"{\n" +
						" \"nome\": \"Fulano da Silva LA\", \n" +
						" \"email\": \""+email+"\", \n" +
						" \"password\": \"teste\", \n" +
						" \"administrador\": \"true\", \n" +
						"}";
		
		Response response =
				given().
				baseUri("https://serverest.dev/").
				basePath("/usuarios").
				contentType(ContentType.JSON).
				body(user).
				when().
				post().
				then().
				extract().response();
		
		System.out.println("Response Body: " + response.asString());
				
	}

}