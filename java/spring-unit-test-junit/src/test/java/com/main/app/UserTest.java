package com.main.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	// @BeforeAll  - Once before all tests
	// @BeforeEach - Before each test
	// @AfterEach  - After each test
	// @AfterAll   - Once after all tests
	
	private User user;
	
	@BeforeAll
	public static void startTest() {
		System.out.println("Start Test ... - @BeforeAll\n");
	}
	
	@AfterAll
	public static void endTest() {
		System.out.println("End Test ... - AfterAll");
	}
	
	@BeforeEach
	public void createUser() {
		System.out.println("User created - @BeforeEach");
		user = new User();
		user.setUsername("rodney");
		user.setSalary(1000d);
	}
	
	@AfterEach
	public void afterEach(){
		System.out.println("Done. - @AfterEach\n");
	}

	@Test
	public void readjustmentHigherNote() {
		System.out.println("HigherNote");
		user.readjustment(9);
		double salary = user.getSalary();
		Assertions.assertEquals(1500, salary);
	}
	
	@Test
	public void readjustmentLowerNote() {
		System.out.println("LowerNote");
		user.readjustment(5);
		double salary = user.getSalary();
		Assertions.assertEquals(1100, salary);
	}

}
