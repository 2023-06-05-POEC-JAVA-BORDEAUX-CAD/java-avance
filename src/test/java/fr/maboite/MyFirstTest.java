package fr.maboite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

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
		int aire = calculateurAire.aireRectangle(2, 2);

		// Assert
		Assertions.assertEquals(4, aire);
	}

	@Test
	public void testAireRectangle_3_2() {
		// Arrange
		CalculateurAire calculateurAire = new CalculateurAire();

		// Act
		int aire = calculateurAire.aireRectangle(3, 2);

		// Assert
		Assertions.assertEquals(6, aire);
	}

}
