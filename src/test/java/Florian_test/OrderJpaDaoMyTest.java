package Florian_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Florian.TP_entity.ClientEntityDao;
import Florian.TP_entity.ClientEntity;
import Florian.TP_entity.OrderEntity;
import Florian.TP_entity.OrdersEntityDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJpaDaoMyTest {

	@EJB
	private OrdersEntityDao ordersEntityDao;
	private ClientEntityDao clientEntityDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrdersEntityDao.class));
		return ejbJar;
	}

	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(OrderEntity.class);
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		unit.setProperty("openjpa.Log", "DefaultLevel=WARN,Runtime=INFO,Tool=INFO,SQL=TRACE");
		return unit;
	}

	@Configuration
	public Properties config() throws Exception {
		Properties p = new Properties();
		p.put("jtaTestDataSource", "new://Resource?type=DataSource");
		p.put("jtaTestDataSource.JdbcDriver", "org.h2.Driver");
		p.put("jtaTestDataSource.username", "test");
		p.put("jtaTestDataSource.password", "test");
		p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:test");
		return p;
	}

	@Test
	public void testSave() throws Exception {

		// Arrange
		String designationOrder = "Test";

		OrderEntity order = new OrderEntity();
		order.setDesignation("Test");

		// Act
		OrderEntity savedOrderEntity = this.ordersEntityDao.save(order);

		// Assert
		Assertions.assertNotNull(savedOrderEntity);
		Assertions.assertNotNull(savedOrderEntity.getId());

		Assertions.assertNull(savedOrderEntity.getTypePresta());
		Assertions.assertEquals(designationOrder, savedOrderEntity.getDesignation());
	}

	@Test
	public void testSaveOrderWithClient() {
		// Créer un nouveau client
		ClientEntity client = new ClientEntity();
		client.setFirstName("John Doe");

		// Sauvegarder le client
		ClientEntity savedClient = this.clientEntityDao.save(client);

		// Créer un nouvel order
		OrderEntity order = new OrderEntity();
		order.setDesignation("Formation");
		order.setTypePresta("Jesaispas");
		order.setClient(savedClient);

		// Sauvegarder l'order
		OrderEntity savedOrder = this.ordersEntityDao.save(order);

		// Charger l'order depuis la base de données
		OrderEntity loadedOrder = this.ordersEntityDao.load(savedOrder.getId());

		// Vérifier que la relation a été sauvegardée
		Assertions.assertNotNull(loadedOrder);
		Assertions.assertNotNull(loadedOrder.getClient());
		Assertions.assertEquals(savedOrder.getId(), loadedOrder.getClient().getId());
	}

}