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
		AreaCalculator ac = new AreaCalculator();
		AreaCalculator ac2 = ac;
		
		assertSame(ac, ac2);
	}
	
	
	@Test void assertEqualsClass() {
		AreaCalculator ac = new AreaCalculator();
		AreaCalculator ac2 = ac;
		assertEquals(ac, ac2);
	}
}
