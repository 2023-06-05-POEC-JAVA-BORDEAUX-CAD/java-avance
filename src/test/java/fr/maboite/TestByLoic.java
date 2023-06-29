package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestByLoic {
	@BeforeEach
	public void methodBeforeEach() {
		System.out.println("-- BeforeEach");
	}
	
	@AfterEach
	public void methodAfterEach() {
		System.out.println("   AfterEach --");
	}
	
	@BeforeAll
	public static void methodBeforeAll() {
		System.out.println("-- BeforeAll --");
	}
	
	@AfterAll
	public static void methodAfterAll() {
		System.out.println("-- AfterAll --");
	}
	
	@Test
	public void testSuccess(){
		assertTrue(true);
	}
	
	@Test
	public void testFail(){
		assertTrue(false);
	}
	
	@Test
	public void testAssertFalseSuccess(){
		assertFalse(false);;
	}
	
	@Test
	public void testEqualsFail() {
		int valueToTest = 5;
		// test l'égalité des valeurs
		assertEquals(4, valueToTest);
	}
	
	@Test
	public void testSameSucess() {
		// test si deux objets font référence au même objet en mémoire
		String reference = new String("it's a Trap!");
		String valueToTest = reference;
		assertSame(reference, valueToTest);
	}
	
	@Test
	public void testSameFail() {
		// test si deux objets font référence au même objet en mémoire
		String reference = new String("it's a Trap!");
		String valueToTest = new String("it's a Trap!");
		assertSame(reference, valueToTest);
	}
}
