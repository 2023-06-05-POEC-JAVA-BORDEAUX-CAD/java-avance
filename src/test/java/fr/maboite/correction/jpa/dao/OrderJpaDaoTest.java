package fr.maboite.correction.jpa.dao;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJpaDaoTest {

	@EJB
	private OrderJpaDao orderDao;

	@EJB
	private ClientJpaDao clientDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJpaDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Order.class);
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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:tests");
        return p;
    }
    
	@Test
	public void testSave() throws Exception {
		
		//Arrange
		Order order = new Order();
		
		//Act
		Order savedOrder = this.orderDao.save(order);
		
		//Assert
		Assertions.assertNotNull(savedOrder);
		Assertions.assertNotNull(savedOrder.getId());
		
	}
    
	@Test
	public void testSaveAndLoad() throws Exception {
		
		//Arrange
		Order order = new Order();
		order.setDesignation("super désignation");
		Order savedOrder = this.orderDao.save(order);
		
		//Act
		Order loadedOrder = this.orderDao.load(savedOrder.getId());
		
		//Assert
		Assertions.assertNotNull(loadedOrder);
		Assertions.assertEquals(savedOrder.getId(), loadedOrder.getId());
		Assertions.assertEquals(savedOrder.getDesignation(), loadedOrder.getDesignation());
		
	}
    
	@Test
	public void testSaveAndRemove() throws Exception {
		
		//Arrange
		Order order = new Order();
		order.setDesignation("super désignation");
		Order savedOrder = this.orderDao.save(order);
		
		//Act
		this.orderDao.delete(savedOrder.getId());
		
		//Assert
		Order loadedOrder = this.orderDao.load(savedOrder.getId());
		Assertions.assertNull(loadedOrder);
	}
    
	@Test
	public void testSave2OrdersAndFindByDesignation() throws Exception {
		
		//Arrange
		Order order1 = new Order();
		String designation = "super désignation";
		order1.setDesignation(designation);
		Order savedOrder1 = this.orderDao.save(order1);
		Order order2 = new Order();
		order2.setDesignation(designation);
		Order savedOrder2 = this.orderDao.save(order2);
		
		//Act
		List<Order> designations = this.orderDao.findByDesignation(designation);
		
		//Assert
		Assertions.assertNotNull(designations);
		Assertions.assertEquals(2, designations.size());
	}
	

    
	@Test
	public void testSaveAndLoadWithClient() throws Exception {
		
		//Arrange
		Order order = new Order();
		order.setDesignation("Salut ! ");
		
		Client client = new Client();
		client.setFirstName("Jean");
		Client savedClient = this.clientDao.save(client);
		
		order.setClient(savedClient);
		Order savedOrder = this.orderDao.save(order);
		
		//Act
		Order loadedOrder = this.orderDao.load(savedOrder.getId());
		
		//Assert
		Assertions.assertNotNull(loadedOrder);
		Assertions.assertEquals(savedOrder.getId(), loadedOrder.getId());
		Assertions.assertNotNull(loadedOrder.getClient());
		Assertions.assertEquals("Jean", loadedOrder.getClient().getFirstName());
		
	}
	
}