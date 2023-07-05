package fr.maboite.testjee;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoDaoTest {
	
	@EJB
	private PojoDaoService pojoservice;

	@EJB
	private PojoDao pojoDao;	
	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(PojoDao.class));
		return ejbJar;
	}

	//tests pojoDao
	@Test
	public void testGet() throws Exception {
		
		Pojo pojo = pojoDao.get(1);
		Assertions.assertNotNull(pojo);
	}
	
	
	public void testGetPojo() throws Exception {
		Pojo pojo = pojoservice.getPojo(1);
		Assertions.assertNotNull(pojo);
	}
	    
	
	
}
