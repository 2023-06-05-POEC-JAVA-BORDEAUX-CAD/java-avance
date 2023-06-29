package fr.exoJUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonTest {
	
	@BeforeEach
	public void BF(){
		
		System.out.println("BeforeEach");
		
	}
	
	@BeforeAll
	public static void BA(){
		
		System.out.println("BeforeAll");
	}
	
	@AfterEach
	public void AE(){
		
		System.out.println("AfterEach");
	}
	
	@AfterAll
	public static void AA(){
		
		System.out.println("AfterAll");
	}
	
	@Test
	public void methodeAssertTrue(){
		
		//Assert
		Assertions.assertTrue(true);
	}
	
	
	@Test
	public void assertAssertFalse(){
		
		//Assert
		Assertions.assertFalse(false);
		
	}
	
	
	@Test
	public void methodeAssertEquals(){
		
		//Arrange
		String expected = "Hello";
		String actual = new String("Hello");

		//Assert
		Assertions.assertEquals(expected,actual);	
	}
	
	
	@Test
	public void methodeAssertSame(){
		
		//Arrange
		String expected = "Hello";
		String actual = "Hello";
				
		//Assert
		Assertions.assertSame(expected,actual);
	}
	

}
