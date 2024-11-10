package com.project.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calculator;

/*
	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}
*/
	
	@Test
	void testMultiply() {
		calculator = new Calculator();
		assertEquals(20, calculator.multiply(4, 5));
	}
	
	@Test
	void testDivide() {
		calculator = new Calculator();
		assertEquals(2, calculator.divide(4, 2));
	}

}
