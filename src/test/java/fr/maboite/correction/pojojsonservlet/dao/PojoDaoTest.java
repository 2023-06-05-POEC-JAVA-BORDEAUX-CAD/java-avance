package fr.maboite.correction.pojojsonservlet.dao;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatefulBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.pojojsonservlet.dao.PojoDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoDaoTest {

	@EJB
	private PojoDao pojoDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatefulBean(PojoDao.class));
		return ejbJar;
	}

	@Test
	public void test1() throws Exception {
		System.out.println(pojoDao.getPojo(3));
	}

}