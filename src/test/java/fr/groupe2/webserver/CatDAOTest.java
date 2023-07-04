package fr.groupe2.webserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.group2.webserver.*;

public class CatDAOTest {

	CatDAO catDao;
	
	@BeforeEach
	public void createNewCatDAO() {
		catDao = new CatDAO();
	}
	
	@Test
	public void getCatTestIdValid() {
		assertNotNull(catDao.getCat(1));
	}
	
	@Test
	public void getCatTestIdNotValid() {
		assertNull(catDao.getCat(5));
	}
	
}
