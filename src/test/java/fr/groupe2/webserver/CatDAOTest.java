package fr.groupe2.webserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatDAOTest {
	
	CatDAO catDAO;
	
	@BeforeEach
	public void createNewCatDAO() {
		catDAO = new CatDAO();
		System.out.println("Create CatDAO");
		
	}
	
	@Test
	public void getCatTestIdValid(){
		Assertions.assertNotNull(catDAO.getCat(1));
	}
	
	@Test
	public void getCatTestIdNotValid(){
		Assertions.assertNull(catDAO.getCat(5));
	}
}
