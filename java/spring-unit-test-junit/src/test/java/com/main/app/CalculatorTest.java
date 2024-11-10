package com.main.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void addTwoNumbers() {
		Calculator calculator = new Calculator();
		int addOperation = calculator.addOperation(10,20);
		Assertions.assertEquals(30, addOperation);
	}
	
	@Test
	void verifyEvenNumber() {
		Calculator calculator = new Calculator();
		boolean verify = calculator.verifyEvenNumber(2);
		Assertions.assertTrue(verify);
	}

}
