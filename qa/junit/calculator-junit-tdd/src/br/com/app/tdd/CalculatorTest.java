package br.com.app.tdd;

import org.junit.Assert;
import org.junit.Test;



public class CalculatorTest {
	
	@Test
	public void somarDoisNumerosPositivos() {
		Calculator calc = new Calculator();
		int somar = calc.somar(3, 7);
		Assert.assertEquals(10, somar);
	}

}
