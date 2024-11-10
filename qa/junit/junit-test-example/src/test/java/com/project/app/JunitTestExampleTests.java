package com.project.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitTestExampleTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void demoTestMethod() {
		assertTrue(true);
	}

}
