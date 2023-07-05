package TPAlexis;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Test;

import jakarta.ejb.EJB;
import junit.framework.Assert;

@RunWithApplicationComposer
public class AlexisTest {

	@EJB
	private AlexisService test; // on injecte dans Junit

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(AlexisService.class));
		return ejbJar;
	}

	@Test
	public void testIsWeekEnd() {
		Assert.assertTrue(this.test.isWeekEnd(8, 7, 2023)); // on test la variable que l'on a injecté 
	}

	@Test
	public void testIsntWeekEnd() {
		Assert.assertFalse(this.test.isWeekEnd(4, 7, 2023));
	}

}  // on ne peut pas retourner null , ca retourne soit vrai soit faux
