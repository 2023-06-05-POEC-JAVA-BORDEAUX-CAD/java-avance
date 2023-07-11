package fr.noellie.jpa;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJPADaoTest {

	@EJB
	private OrderJPADao orderJPADao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJPADao.class));
		return ejbJar;
	}

	@Module
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
	public void testSaveOrderJPADao() throws Exception {
		// Arrange
		String typePresta = "Conférence";

		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setTypePresta("Conférence");
		orderJPA.setDesignation("JDBC");
		orderJPA.setClientId(1);

		// Act
		OrderJPA savedOrder = orderJPADao.save(orderJPA);

		// Assert
		Assertions.assertEquals(typePresta, savedOrder.getTypePresta());
	}

	@Test
	public void testLoadOrderJPADao() throws Exception {
		// Arrange
		Long jpaId = (long) 3;

		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setTypePresta("Conférence");
		orderJPA.setDesignation("JDBC");
		orderJPA.setClientId(1);

		// Act
		OrderJPA savedOrder = orderJPADao.save(orderJPA);

		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());

		// Assert
		Assertions.assertNotEquals(jpaId, loadedOrder.getId());
	}
}