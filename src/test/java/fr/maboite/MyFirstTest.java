package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("after all");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("after each");
	}

	@Test
	public void testSuccess() {
		int expectedValue = 4;
		int computedValue = 2 + 2;
		assertEquals(expectedValue, computedValue);
	}

	@Test
	@Disabled
	public void testFailure() {
		assertEquals(3, 2);
	}
	
	
	//assertsEquals
	@Test
	public void myTestSuccess() {
		String str1 = "test success";
		String str2 = "test success";
		assertEquals(str1, str2);		
	}
	
	@Test
	public void myTestFailure() {
		String str1 = "test success";
		String str2 = "Je ne correspond pas à la valeur attendue";
		assertEquals(str1, str2);	
	}
	
	//assertsSame
	@Test
	public void myTestSameSucess() {
		String a = "Salut";
		String b = "Salut";
		Assertions.assertSame(a, b);	
	}
	
	@Test
	public void myTestSameFailure() {
		String a = new String("Salut");
		String b = new String("Salut");
		Assertions.assertSame(a, b);	
	}
	
	
}
