package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import fr.maboite.tests.*;


import org.junit.jupiter.api.Test;

public class AreaCalcTest {

	@Test
	public void square_area() {
		AreaCalculator ac = new AreaCalculator();
		Integer expectedValue = ac.calcSquareArea(5);
		int computedValue = 5*5;
		assertEquals(expectedValue, computedValue);
	}

	@Test
	public void asserttrue() {
		assertTrue(false);
	}
	
	@Test
	public void assertfalse() {
		assertFalse(false);
	}
	
	@Test
	public void assertsame() {
		String a = new String("Hello");
		String b = new String("Hello");
		
		assertSame(a, b);
	}
	
	
	@Test void assertEqualsClass() {
		String a = new String("Hello");
		String b = new String("Hello");
		assertEquals(a, b);
	}
}
