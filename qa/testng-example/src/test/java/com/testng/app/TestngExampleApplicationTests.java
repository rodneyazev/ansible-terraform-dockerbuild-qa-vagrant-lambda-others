package com.testng.app;


import static org.testng.Assert.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
class TestngExampleApplicationTests {
	
	protected int value1, value2;
	@Test
	void setup() {
		System.out.println("Opening browser");
		value1 = 3;
		value2 = 3;
	}
	
	@Test
	void login() {
		System.out.println("Login test.");
	}
	
	@Test
	void teardown() {
		System.out.println("Closing browser");
	}
	
	@Test
	public void testAdd() {
		double result = value1 + value2;
		assertTrue(result == 6);
	}

}
