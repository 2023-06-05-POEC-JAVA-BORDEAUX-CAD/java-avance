package dev.loicmoreaux.pojoservlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PojoDAOTest {

	PojoDAO pojoDAO;
	
	@BeforeEach
	public void createNewPojoDAO() {
		pojoDAO = new PojoDAO();
		System.out.println("Create CatDAO");
		
	}
	
	@Test
	public void getPojoTestIdValid(){
		Assertions.assertNotNull(pojoDAO.getPojo(1));
	}
	
	@Test
	public void getPojoTestIdNotValid(){
		Assertions.assertNull(pojoDAO.getPojo(5));
	}
}
