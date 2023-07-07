package tp.date.service;

import jakarta.ejb.EJB;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;

@RunWithApplicationComposer
public class DateServiceTest {
	@EJB
	private DateService date;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(DateService.class));
		return ejbJar;
	}

	@Test
	public void isWeek() {
		Assert.assertTrue(this.date.isWeek(8, 7, 2023));
	}

	@Test
	public void isntWeek() {
		Assert.assertFalse(this.date.isWeek(4, 7, 2023));
	}
}
