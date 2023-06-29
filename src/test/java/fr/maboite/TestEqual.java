package fr.maboite;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

/**
 * Utilise assertSame et assertEquals
 * pour tester l'égalité avec == et l'égalité avec .equals
 */
public class TestEqual {

	@Test
	public void testS1_S2_same() throws Exception {
		String s1 = "Salut";
		String s2 = s1;
		
		boolean egalite = (s1 == s2);
		Assert.assertTrue(egalite);
		//equivaut à 
		Assert.assertSame(s1, s2);
	}

	@Test
	public void testS1_S2_not_same() throws Exception {
		String s1 = new String("Salut");
		String s2 = new String("Coucou");
		
		boolean egalite = (s1 == s2);
		Assert.assertFalse(egalite);
		//equivaut à 
		Assert.assertNotSame(s1, s2);
	}

	@Test
	public void testS1_S2_not_same_with_same_string() throws Exception {
		String s1 = new String("Salut");
		String s2 = new String("Salut");
		
		boolean egalite = (s1 == s2);
		Assert.assertFalse(egalite);
	}

	@Test
	public void testS1_S2_equals_with_same_string() throws Exception {
		String s1 = new String("Salut");
		String s2 = new String("Salut");
		
		boolean egalite = (s1.equals(s2));
		Assert.assertTrue(egalite);
		//equivaut à 
		Assert.assertEquals(s1, s2);
	}

}
