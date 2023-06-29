package fr.exoJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonTest {
	
	@Test
	public void methodeAssertTrue(){
		
		//Assert
		Assertions.assertTrue(false);
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
		String actual = new String("Hello");;
				
		//Assert
		Assertions.assertSame(expected,actual);
	}
	

}
