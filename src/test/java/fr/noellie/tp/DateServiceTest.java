package fr.noellie.tp;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class DateServiceTest {
	@EJB
	private DateService dateService;
	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(DateDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(DateService.class));
		return ejbJar;
	}
	
	@Test
	public void testJourEnSemaine() throws Exception {
		Assertions.assertTrue(DateService.jourEnSemaine(4,7,2023));
	}
	
	@Test
	public void testJourEnWeekEnd() throws Exception {
		Assertions.assertFalse(DateService.jourEnSemaine(1,7,2023));
	}
}
