package tp.jpa;

import jakarta.ejb.EJB;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.testing.Module;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWithApplicationComposer
public class OrderDaoTest {
	@EJB
	private OrderDao ordao;

	@EJB
	private ClientDao clidao;

	@Module
	public EjbJar beans() {
		EjbJar ejb = new EjbJar("ordao");
		ejb.addEnterpriseBean(new StatelessBean(OrderDao.class));
		ejb.addEnterpriseBean(new StatelessBean(ClientDao.class));
		return ejb;
	}

	@Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(OrderModel.class);
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		unit.setProperty("openjpa.Log", "DefaultLevel=WARN,Runtime=INFO,Tool=INFO,SQL=TRACE");
		return unit;
	}

	@Configuration
	public Properties config() throws Exception {
		Properties props = new Properties();
		props.put("jtaTestDataSource", "new://Resource?type=DataSource");
		props.put("jtaTestDataSource.JdbcDriver", "org.h2.Driver");
		props.put("jtaTestDataSource.username", "root");
		props.put("jtaTestDataSource.password", "");
		props.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:test");
		return props;
	}

	@Test
	public void save() {
		OrderModel order = new OrderModel();
		order.setTypePresta("testdata");
		order.setDesignation("testdata");
		order.setClientId(1); // not nullable
		OrderModel saved = ordao.save(order);

		assertNotNull(order);
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertEquals(order.getTypePresta(), saved.getTypePresta());
		assertEquals(order.getDesignation(), saved.getDesignation());
		assertEquals(order.getClientId(), saved.getClientId());
	}

	@Test
	public void load() {
		OrderModel order = new OrderModel();
		order.setTypePresta("testdata");
		order.setDesignation("testdata");
		order.setClientId(1); // not nullable
		order = ordao.save(order);

		OrderModel saved = ordao.load(order.getId());

		assertNotNull(order);
		assertNotNull(saved);
		assertEquals(order.getId(), saved.getId());
	}

	@Test
	public void delete() {
		OrderModel order = new OrderModel();
		order.setTypePresta("testdata");
		order.setDesignation("testdata");
		order.setClientId(1); // not nullable
		order = ordao.save(order);

		OrderModel deleted = ordao.delete(order.getId());

		assertNotNull(order);
		assertNotNull(deleted);
		assertEquals(order.getId(), deleted.getId());
	}

	@Test
	public void manytoone() {
		ClientModel client = ClientDaoTest.clientGenerator();
		client = clidao.save(client);

		OrderModel order = new OrderModel();
		order.setTypePresta("testdata");
		order.setDesignation("testdata");
		order.setClient(client);
		order = ordao.save(order);

		OrderModel loaded = ordao.load(order.getId());

		assertNotNull(order);
		assertNotNull(client);
		assertNotNull(loaded);
		assertNotNull(order.getClient());
		assertNotNull(loaded.getClient());

		assertEquals(loaded.getId(), order.getId());
		assertEquals(loaded.getClient().getId(), client.getId());
	}
}
