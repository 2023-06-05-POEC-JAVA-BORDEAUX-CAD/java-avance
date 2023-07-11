package dev.loicmoreaux.jpa;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.loicmoreaux.jpa.dao.OrderDAO;
import dev.loicmoreaux.jpa.model.Order;
import jakarta.ejb.EJB;


@RunWithApplicationComposer
public class OrderDAOTest {
	@EJB
	private OrderDAO orderDAO;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDAO.class));
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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:file:D:/Dev Web/M2i/Java/testOrderDao");
        return p;
    }
    
	@Test
	public void testSave() throws Exception {
		
		//Arrange
		String typePrestaOrder = "Formation";
		String designationOrder = "HTML";
		Integer clientIdOrder = 1;
		
		Order order = new Order();
		order.setTypePresta(typePrestaOrder);
		order.setDesignation(designationOrder);
		order.setClientId(clientIdOrder);
		
		//Act
		Order savedOrder = this.orderDAO.save(order);
		
		//Assert
		Assertions.assertNotNull(savedOrder);
		Assertions.assertNotNull(savedOrder.getId());
		
		Assertions.assertNull(savedOrder.getNbDays());
		Assertions.assertEquals(typePrestaOrder, savedOrder.getTypePresta());
	}
	
	@Test
	public void testLoad() throws Exception {
		// Arrange
		String typePrestaOrder = "Formation";
		String designationOrder = "HTML";
		Integer clientIdOrder = 1;
		
		Order order = new Order();
		order.setTypePresta(typePrestaOrder);
		order.setDesignation(designationOrder);
		order.setClientId(clientIdOrder);
		
		Order savedOrder = this.orderDAO.save(order);
		Integer savedOrderId = savedOrder.getId();
		
		//Act
		Order loadedOrder = this.orderDAO.load(savedOrderId);
		
		//Assert
		Assertions.assertNotNull(loadedOrder);
	}
	
	@Test
	public void testDelete() throws Exception {
		// Arrange
		String typePrestaOrder = "Formation";
		String designationOrder = "HTML";
		Integer clientIdOrder = 1;
		
		Order order = new Order();
		order.setTypePresta(typePrestaOrder);
		order.setDesignation(designationOrder);
		order.setClientId(clientIdOrder);
		
		Order savedOrder = this.orderDAO.save(order);
		Integer savedOrderId = savedOrder.getId();
		
		//Act
		this.orderDAO.delete(savedOrderId);
		Order deletedOrder = this.orderDAO.load(savedOrderId);
		
		//Assert
		Assertions.assertNull(deletedOrder);
		
	}
	
	
}
