package fr.maboite.correction.pojojsonservlet.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.pojojsonservlet.dao.PojoDaoMock;

public class PojoServiceTest {
	
	@Test
	public void testGet() {
		PojoService pojoService = new PojoService();
		pojoService.setPojoDao(new PojoDaoMock());
		Assertions.assertNotNull(pojoService.get(1));
	}

}
