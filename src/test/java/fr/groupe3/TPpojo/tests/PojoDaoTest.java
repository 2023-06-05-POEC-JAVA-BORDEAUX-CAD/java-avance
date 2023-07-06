package fr.groupe3.TPpojo.tests;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.groupe3.TPpojo.Pojo;
import fr.groupe3.TPpojo.PojoDao3;
import fr.groupe3.TPpojo.PojoService3;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoDaoTest {
	
	@EJB
	private PojoDao3 pojoDao;
	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(PojoDao3.class));
		ejbJar.addEnterpriseBean(new StatelessBean(PojoService3.class));
		return ejbJar;
	}
	
	@Test
	public void testGetPojoById() throws Exception {
		Pojo pojo = pojoDao.getPojo(1);
		Assertions.assertNotNull(pojo);
		Assertions.assertEquals("Pojo 1", pojo.getName());
	}
	
}
