/**
 * 
 */
package fr.test.philippe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOne {
	@BeforeAll
	public static void methodeLanceBeforeAllTest() {
		System.out.println("Avant le lancement tous les tests");
		
	}
	@AfterAll
	public static void methodeLanceAfterAllTest() {
		System.out.println("Apres le lancement tous les tests");
		
	}
		
	@BeforeEach
	public void methodeLanceBeforeTest() {
		System.out.println("Avant le lancement de test");
	
	}
	
	@AfterEach
	public void methodeLanceAoresTest() {
		System.out.println("Apres le lancement de test");
	}
	
 @Test
	
	public void testAireCarre() throws Exception {
		// TODO Auto-generated method stub
		CalculAire calculAire = new CalculAire();
		
		int aire = calculAire.aireCarre(6);
		
		Assertions.assertEquals(36, aire);
		Assertions.assertTrue(true);
		
	}
	 
	 @Test
	
	public void testAireRectangle() {
		// TODO Auto-generated method stub
		CalculAire calculAire = new CalculAire();
		
		int aire = calculAire.aireRectangle(3, 3);
		
		Assertions.assertEquals(9, aire);
	
	}

}
