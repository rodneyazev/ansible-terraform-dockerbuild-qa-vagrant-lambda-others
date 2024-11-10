package com.example.app;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

class PostRestAssuredTestRightWay {
	
	// Caution when pass Post per String
	
	@Test
	void addUserString() {
		String email = "teste_" + "lalala" + "@gmail.com";
		
		// Instead JSONObject we can use through DTO too
		JSONObject user = new JSONObject();
		user.put("nome", "teste");
		user.put("email", email);
		user.put("password", "teste");
		user.put("administrador", "true");
		
		Response response =
				given().
				baseUri("https://serverest.dev/").
				basePath("/usuarios").
				contentType(ContentType.JSON).
				body(user.toString()).
				when().
				post().
				then().
				extract().response();
		
		System.out.println("Response Body: " + response.asString());
				
	}

}
