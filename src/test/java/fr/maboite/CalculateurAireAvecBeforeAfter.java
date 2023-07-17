package fr.maboite;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Utilise @BeforeAll , @BeforeEach ...
 * pour ajouter des comportements avant chaque test (et après avec
 * les annotations @AfterAll et @AfterEach)
 */
public class CalculateurAireAvecBeforeAfter {
	
	private CalculateurAire calculateurAire;
	
	@BeforeAll
	public static void methodeLanceeAvantTousLesTests() {
		// System.out.println("Bien le bonjour de BeforeAll");
	}
	
	@AfterAll
	public static void methodeLanceeApresTousLesTests() {
		// System.out.println("Bien le bonjour de AfterAll");
	}
	
	@BeforeEach
	public void methodeLanceeAvantChaqueTest() {
		// Arrange
		// System.out.println("Bien le bonjour de BeforeEach");
		calculateurAire = new CalculateurAire();
	}
	
	@AfterEach
	public void methodeLanceeApresChaqueTest() {
		// System.out.println("Bien le bonjour de After each");
	}

	@Test
	public void testAireCarre() throws Exception {
		
		// Act
		int aire = calculateurAire.aireCarre(5);
		// Assert
		Assertions.assertEquals(25, aire);
	}

	@Test
	public void testAireRectangle_2_2() {

		// Act
		double aire = calculateurAire.aireRectangle(2, 2);

		// Assert
		Assertions.assertEquals(4, aire);
	}

	

}
