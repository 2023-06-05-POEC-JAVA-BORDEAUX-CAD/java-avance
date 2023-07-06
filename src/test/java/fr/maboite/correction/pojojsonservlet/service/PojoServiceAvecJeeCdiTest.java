package fr.maboite.correction.pojojsonservlet.service;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.pojojsonservlet.dao.PojoDao;
import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoServiceAvecJeeCdiTest {

	@EJB
	private PojoService pojoService;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(PojoDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(PojoService.class));
		return ejbJar;
	}

	@Test
	public void testGetById() throws Exception {
		Pojo2 pojo = pojoService.get(1);
		Assertions.assertNotNull(pojo);
		Assertions.assertEquals("Hey!", pojo.getName());
	}

}