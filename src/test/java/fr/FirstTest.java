package fr;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.habillage.Pantalons;



public class FirstTest {

@BeforeAll
	public static void beforeAll() throws JsonProcessingException {
		System.out.println("before all");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("before each");
	}

  @AfterAll
	public static void afterAll() throws JsonProcessingException {
		System.out.println("after all");
	}

  @AfterEach
	public void afterEach() {
		System.out.println("after each");
	}



  @Test
  public void Echec() throws Exception {   
    Pantalons pantalon = new Pantalons();
    pantalon.setLongueur(false); 
    Assertions.assertTrue(false);
  }

  @Test
  public void Succes() throws Exception{
    int a=2;
    int b=2;

    int somme = a + b;
    Assertions.assertEquals(4, somme);
  }
  
}
