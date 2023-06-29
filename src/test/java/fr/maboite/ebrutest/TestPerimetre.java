package fr.maboite.ebrutest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPerimetre {

	@Test
	public void testP() {
		CalculPerimetre calculPerimetre = new CalculPerimetre();
		int perimetre = calculPerimetre.pCarre(2);
		Assertions.assertEquals(8, perimetre);

	}

	@Test
	public void echec() {
		Assertions.assertTrue(false);

	}

}
