package fr.groupe2.webserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CatServiceTestMock {

	@Test
	public void getCatTestIdValid() {
		CatServiceMock csm = new CatServiceMock();
		assertNotNull(csm.getCat(1));
	}
	
}
