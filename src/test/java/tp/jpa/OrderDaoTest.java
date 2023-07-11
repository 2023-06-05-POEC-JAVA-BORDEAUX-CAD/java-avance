package tp.jpa;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Module;

import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderDaoTest {
	@EJB
	private OrderDao ordao;

	@Module
	public EjbJar beans() {
		EjbJar ejb = new EjbJar("ordao");
		ejb.addEnterpriseBean(new StatelessBean(OrderDao.class));
		return ejb;
	}
}
