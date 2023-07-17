package fr.maboite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Classe de tests JUnit classiques
 */
public class CalculateurAireTest {
	
	
	@Test
	public void testAireCarre() throws Exception {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();
		// Act
		int aire = calculateurAire.aireCarre(5);
		// Assert
		Assertions.assertEquals(25, aire);
	}

	@Test
	public void testAireRectangle_2_2() {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();
		// Act
		double aire = calculateurAire.aireRectangle(2, 2);

		// Assert
		Assertions.assertEquals(4, aire);
	}

	@Test
	public void testAireRectangle_3_2() {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();
		// Act
		double aire = calculateurAire.aireRectangle(3, 2);

		// Assert
		Assertions.assertEquals(6, aire);
	}

	@Test
	public void testAireRectangle_3point5_2() {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();
		// Act
		double aire = calculateurAire.aireRectangle(3.33, 2.73);

		// Assert
		Assertions.assertEquals( 9.0909, aire);
	}
	


	@Test
	public void testAireCercleRayon2() {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();
		// Act
		double aire = calculateurAire.aireCercle(2);

		// Assert
		Assertions.assertEquals(12.56, aire, 0.01);
		
	}
	
	@Test
	public void testAireCercleRayonNegatif() {

		CalculateurAire calculateurAire = new CalculateurAire();
		// System.out.println("Bien le bonjour de BeforeEach");
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculateurAire.aireCercle(-1));
	}
	
	@Test
	public void testAireTriangleRectangle_4_5() {
		CalculateurAire calculateurAire = new CalculateurAire();
		double aire = calculateurAire.aireTriangleRectangle(4,5);
		Assertions.assertEquals(10, aire);
	}
	
	@Test
	public void testAireTriangleRectangle_12_2() {
		CalculateurAire calculateurAire = new CalculateurAire();
		double aire = calculateurAire.aireTriangleRectangle(12,2);
		Assertions.assertEquals(12, aire);
	}

}
