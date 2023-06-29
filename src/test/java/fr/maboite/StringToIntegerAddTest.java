package fr.maboite;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.maboite.tests.*;


public class StringToIntegerAddTest {
	
	StringToIntegerAdd stia;
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Nouveau test");
		this.stia = new StringToIntegerAdd();
	}
	
	@Test
	public void return500_2() {
		Assertions.assertEquals(500, stia.addSubStringIntegers("400,100"));
	}
	
	@Test
	public void return600_2() {
		Assertions.assertEquals(600, stia.addSubStringIntegers("400,200"));
	}

	
	@Test
	public void return500_3() {
		Assertions.assertEquals(500, stia.addSubStringIntegers("200,100,200"));
	}
	@Test
	public void return600_3() {
		Assertions.assertEquals(600, stia.addSubStringIntegers("200,200,200"));
	}
}
