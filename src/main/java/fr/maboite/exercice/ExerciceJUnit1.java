package fr.maboite.exercice;

import org.junit.jupiter.api.*;

public class ExerciceJUnit1 {
	@Test
	public void testSuccess() {
		int expectedValue = 10;
		int computedValue = 5 * 2;
		Assertions.assertEquals(expectedValue, computedValue);
	}
	
	@Test
	public void testFailure() {
		Assertions.assertEquals(10, 50);
	}
}
