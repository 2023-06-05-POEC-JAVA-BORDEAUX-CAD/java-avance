package fr.exoJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonTest {
	
	@Test
	public void methodeErreur()
	{
		//Arrange
		int a = 1;
		int b = 2;
		
		//Act
		int somme = a*b;
		
		//Assert
		Assertions.assertEquals(3,somme);
	}
	
	@Test
	public void methodeBien()
	{
		
		//Arrange
		int a = 1;
		int b = 2;
				
		//Act
		int somme = a+b;
				
		//Assert
		Assertions.assertEquals(3,somme);
		
	}

}
