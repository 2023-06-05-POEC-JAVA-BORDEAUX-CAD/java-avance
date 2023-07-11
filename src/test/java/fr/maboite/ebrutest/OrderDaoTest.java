package fr.maboite.ebrutest;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.ebru.jpa.entity.OrderJPA;
import fr.maboite.correction.jpa.model.PojoJpa;
import fr.maboite.ebru.jpa.entity.OrderDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderDaoTest {

	@EJB
	private OrderDao orderDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
		return ejbJar;
	}

	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(OrderJPA.class);
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

		OrderJPA orderJpa = new OrderJPA();

		orderJpa.setType("Formation");
		orderJpa.setDesignation("Angular init");
		orderJpa.setClient_id(2);

		// Act
		OrderJPA testsaveJpa = orderDao.save(orderJpa);

		// Assert
		Assertions.assertNotNull(orderJpa);
		Assertions.assertNotNull(testsaveJpa);
		Assertions.assertNotNull(testsaveJpa.getId());

		Assertions.assertNull(testsaveJpa.getType());
		Assertions.assertNull(testsaveJpa.getDesignation());
		Assertions.assertNull(testsaveJpa.getClient_id());

		Assertions.assertEquals(orderJpa.getType(), testsaveJpa.getType());
		Assertions.assertEquals(orderJpa.getDesignation(), testsaveJpa.getDesignation());
		Assertions.assertEquals(orderJpa.getClient_id(), testsaveJpa.getClient_id());

		// on peut mettre directement le nom de type, designation ou client id au lieu
		// de orderJpa.get...

	}

	@Test
	public void testLoad() throws Exception {

		// Arrange

		OrderJPA orderJpa = new OrderJPA();

		orderJpa.setType("Formation");
		orderJpa.setDesignation("Angular init");
		orderJpa.setClient_id(2);

		// Act
		OrderJPA testloadJpa = orderDao.load(orderJpa);

	}

}
