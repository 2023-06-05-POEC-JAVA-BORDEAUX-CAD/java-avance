package fr.maboite.fabien;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

	@Beforeall
	public static void testAvantLesTests() {
		System.out.println("apparait avant tous les tests");
	}
	
	@Afterall
	public static void testApresTousLesTests() {
		System.out.println("apparait apres tous les tests");
	}
	
	@beforeeach
	public static void testAvantChaqueTests() {
		System.out.println("apparait avant chaque tests");
	}
	

	@aftereach
	public static void testApresChaqueTests() {
		System.out.println("apparait apres chaque tests");
	}
	
	
	@Test
	public void test1() throws Exception {
		String s1 = new String ("Salut");
		String s2 = new String ("coucou");
		
		boolean egalite = (s1==s2);
		System.out.println(egalite);
	}
	
	@BeforeAll

	public void test2() throws Exception {
		String s1 = "Salut";
		String s2 = s1;
		
		boolean egalite = (s1==s2);
		System.out.println(egalite);
	}
	
//	public void main() throws Exception {
//		//Arrange
//		IndicateurYesNo indicateurYesNo = new IndicateurYesNo();
//		//Act
//		String response = indicateurYesNo.responseNeeded("Yes");
//		//Assert
//		Assertions.assert("Yes", reponse);
//	}
	
	@Test

	public void testIsYes()  throws Exception {
		//Arrange
		IndicateurYesNo indicateurYesNo = new IndicateurYesNo();
		
		//Act
		String answer = indicateurYesNo.answerYes("Yes");
		//Assert
		
		Assertions.assertTrue("Yes",(answer));
	}
		
	
//	private boolean isYesOrNo(String answer) {
//        return answer.equalsIgnoreCase("Yes");
//    }
	
	@Test
	public void testIsTrue() {
        assertTrue(condition:true);
    }

    private void assertTrue(boolean answer) {
	// TODO Auto-generated method stub
	
}

	@Test
    public void testIsFalse() {
        boolean answer = false;
        assertFalse(answer);
    }

}
