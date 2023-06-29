package fr.maboite.exercice;

import org.junit.jupiter.api.*;

public class ExerciceJUnit1 {
	
	@BeforeAll
	public static void addBeforeAll() {
		System.out.println("BeforeAll lancé");
	}
	
	@BeforeEach
	public void addBeforeEach() {
		System.out.println("BeforeEach lancé");
	}
	
	// assertEquals permet de comparer les deux paramètres pour vérifier qu’ils sont égaux
	@Test
	public void testSuccess() {
		int expectedValue = 10;
		int computedValue = 5 * 2;
		Assertions.assertEquals(expectedValue, computedValue);
	}

	@Test
	public void testSuccess2() {
		int expectedValue = 600;
		int computedValue = 150 * 4;
		Assertions.assertEquals(expectedValue, computedValue);
	}

	// assertTFalse permet de vérifier que la condition passée en paramètre est false
	@Test
	public void testSuccess3() {
		String string = "Hello World !";

		Assertions.assertFalse(string.isBlank());
	}

	// assertTrue permet de vérifier que la condition passée en paramètre est vraie
	@Test
	public void testFailure() {
		Assertions.assertTrue(false);
	}

	@Test
	public void testFailure2() {
		Assertions.assertEquals(13, 20);
	}

	// assertSame permet de vérifier que les deux objets passés en paramètre sont en fait le même objet
	@Test
	public void testSameSuccess() {
		String s1 = "Hello";
		String s2 = "Hello";
		Assertions.assertSame(s1, s2);
	}
	
	@Test
	public void testSameFailure() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		Assertions.assertSame(s1, s2);
	}
	
	@AfterEach
	public void addAfterEach() {
		System.out.println("AfterEach lancé");
	}
	
	@AfterAll
	public static void addAfterAll() {
		System.out.println("AfterAll lancé");
	}
}
