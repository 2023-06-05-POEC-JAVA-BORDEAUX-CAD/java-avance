package fr.maboite.ebrutest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPerimetre {

	
	@BeforeAll
	
	public static void afficheavanttout() {
		System.out.println("Bonjour afficheavanttout");
	}
	
	@AfterAll
	
	public static void afficheaprestout() {
		System.out.println("Bonjour afficheaprestout");
	}
	
	@BeforeEach
	
	public void avantchaquetest() {
		System.out.println("Bonjour avantchaquetest");
		
	}
	
	@AfterEach
	
	public void apreschaquetest() {
		System.out.println("Bonjour apreschaquetest");
	}
	
	
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
