package fr.maboite.correction.pojojsonservlet.dao;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoDaoTest {

	@EJB
	private PojoDao pojoDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(PojoDao2.class));
		return ejbJar;
	}

	@Test
	public void testGetById() throws Exception {
		Pojo pojo = pojoDao.getPojo(1);
		Assertions.assertNotNull(pojo);
		Assertions.assertEquals("Hey!", pojo.getName());
	}

}