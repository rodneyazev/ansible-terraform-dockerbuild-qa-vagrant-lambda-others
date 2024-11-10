package com.example.app;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

class MyRestAssuredProjectApplicationTests {
	
	@BeforeTest
	void beforeTest() {
		baseURI = "https://serverest.dev/";
	}
	

	@Test
	void basicStructure() {
		given().
			baseUri("https://serverest.dev/").
			basePath("/usuarios/{_id}").
			pathParam("_id", "0uxuPY0cbmQhpEz1").
		when().
			get().
		then().
			statusCode(200);
	}
	
	@Test
	void basicStructureWithoutBaseUri() {
		given().
			basePath("/usuarios/{_id}").
			pathParam("_id", "0uxuPY0cbmQhpEz1").
		when().
			get().
		then().
			statusCode(200);
	}
	
	@Test
	void extractResponseBody() {
		
		Response response = given().
								basePath("/usuarios/{_id}").
								pathParam("_id", "0uxuPY0cbmQhpEz1").
							when().
								get().
							then().
								extract().response();
		
		System.out.println("Response Body: " + response.asString());
	}
	
	@Test
	void otherExtractResponseBody() {
		
		Response response = given().
								basePath("/usuarios/{_id}").
								pathParam("_id", "0uxuPY0cbmQhpEz1").
							when().
								get();
		response.then().statusCode(200);
		
		System.out.println("Response Body (Other): " + response.asString());
		System.out.println("Status Code: " + response.statusCode());
		System.out.println("Headers: " + response.headers());
	}
	
	@Test
	void usingMatch() {
		given().
			basePath("/usuarios").
		when().
			get().
		then().
			statusCode(200).
			body(
					// get these details in https://serverest.dev/
					"quantidade", equalTo(636),
					"usuarios[0].nome", equalTo("Kimberly Graham"),
					"usuarios[0].nome", equalToIgnoringCase("kimberly Graham"),
					"usuarios[0].nome", containsString("Graham"),
					"usuarios", hasItem(hasEntry("email","Alfonzo71@gmail.com")),
					// $ = raiz
					"$", hasKey("quantidade"),
					"usuarios", hasSize(greaterThan(0)),
					"usuarios", hasSize(lessThan(100)),
					"usuarios", everyItem(hasKey("password")),
					"quantidade", not(equalTo(0)),
					
					"usuarios.password", everyItem(not(empty())),
					"usuarios.password", everyItem(notNullValue()),
					"usuarios.email", not(empty())
			);
	}

}
