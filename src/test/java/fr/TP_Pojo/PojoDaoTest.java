package fr.TP_Pojo;

import jakarta.annotation.security.RunAs;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;


	
	public class PojoDaoTest {
	
	@EJB
	private PojoDao pojoDao; 
	
	
	@Test
	public void test1() throws Exception {
		Pojo pojo = pojoDao.getPojo(1);
		Assertions.assertNotNull(pojo);
		Assertions.assertEquals("Hey!", pojo.getName());
	}

}
