package fr.maboite.fabien.tpjsf.testjpa;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import fr.maboite.fabien.TP.test.injectCDI.Pojo;
import fr.maboite.fabien.TP.test.injectCDI.PojoDao;
import fr.maboite.fabien.TP.test.injectCDI.PojoDaoInterface;
import fr.maboite.fabien.TP.test.injectCDI.RunWithApplicationComposer;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJpaDaoTest {

	@EJB
	private OrderDaoInterface orderDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
		return ejbJar;
	}

	@Test
	public void test1() throws Exception {
		Order order = orderDao.getOrder(1);
		Assertions.assertNotNull(order);
		Assertions.assertEquals("Hey!", order.getName());
	}

} {

	@EJB
	private OrderDaoInterface orderDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
		return ejbJar;
	}

	@Test
	public void test1() throws Exception {
		Pojo order = orderDao.getOrder(1);
		Assertions.assertNotNull(order);
		Assertions.assertEquals("Hey!", order.getName());
	}

}