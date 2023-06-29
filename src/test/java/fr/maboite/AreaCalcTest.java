package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import fr.maboite.tests.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AreaCalcTest {
	AreaCalculator ac;
	
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Nouveau test");
		this.ac = new AreaCalculator();
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("tests finished");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("test finished");
	}
	
	@Test
	public void square_area() {
		
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
