package fr.maboite;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPremier {

	@BeforeAll
	public static void testAvantTousLesTests() {
		System.out.println("test avant tous les tests");
	}
	
	
	@AfterAll
	public static void testApresTousLesTests() {
		System.out.println("test apres tous les tests");
	}
	
	
	@BeforeEach
	public void testAvantLesChaqueTest() {
		System.out.println("test avant chaque test");
	}

	@AfterEach
	public void testApresChaqueTest() {
		System.out.println("test apres chaque tests");

	}
	
	

//	@Test
//	public void testFailAlways() {
//
//		Assertions.assertTrue(false);
//	}

	@Test
	public void testSuccess() {
		// Arrange
		int a = 2;
		int b = 3;
		int aireTriRec = (a * b) / 2;

		// Act
		int aire = AireTriRec.calculaireAireTriRec(a, b);

		// Assert
		Assertions.assertEquals(aireTriRec, aire);
	

	}

}
