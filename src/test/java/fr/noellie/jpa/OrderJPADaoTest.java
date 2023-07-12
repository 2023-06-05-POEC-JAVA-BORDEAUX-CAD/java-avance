package fr.noellie.jpa;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.noellie.jpa.dao.ClientJPADao;
import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.ClientJPA;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJPADaoTest {

	@EJB
	private OrderJPADao orderJPADao;
	
	@EJB
	private ClientJPADao clientJPADao;

	@Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJPADao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJPADao.class));
		return ejbJar;
	}

	@Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(OrderJPA.class);
		unit.addClass(ClientJPA.class);
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

		// Act
		OrderJPA savedOrder = orderJPADao.save(orderJPA);

		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());

		// Assert
		Assertions.assertNotEquals(jpaId, loadedOrder.getId());
	}
	
	@Test
	public void testSave2OrdersAndFindByDesignation() throws Exception {
		
		//Arrange
		OrderJPA order1 = new OrderJPA();
		String designation = "super désignation";
		order1.setDesignation(designation);
		OrderJPA savedOrder1 = this.orderJPADao.save(order1);
		OrderJPA order2 = new OrderJPA();
		order2.setDesignation(designation);
		OrderJPA savedOrder2 = this.orderJPADao.save(order2);
		
		//Act
		List<OrderJPA> designations = this.orderJPADao.findByDesignation(designation);
		
		//Assert
		Assertions.assertNotNull(designations);
		Assertions.assertEquals(2, designations.size());
	}
	
	@Test
	public void testRelationWithClient() throws Exception {
		// Arrange
		
		// Sauvegarder un client
		ClientJPA clientJPA = new ClientJPA();
		ClientJPA savedClient = this.clientJPADao.save(clientJPA);

		// Rattacher un order à ce client sauvegardé
		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setClient(savedClient);

		// Act
		// Sauvegarder le order (ce qui va persister la relation)
		OrderJPA savedOrder = this.orderJPADao.save(orderJPA);
		
		// S'assurer que la relation est sauvegardée avec un load		
		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());
		
		// Assert
		Assertions.assertNotNull(loadedOrder);
		Assertions.assertNotNull(savedOrder.getClient());
	}
}