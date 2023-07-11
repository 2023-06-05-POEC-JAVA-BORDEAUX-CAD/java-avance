package fr.maboite;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.fabien.tpjsf.jpadao.OrderDao;
import fr.maboite.fabien.tpjsf.jpamodel.Order;
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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:file:C:/dev/h2-data/formation-poe-java-2023-07-12");
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
		order.setDesignation("Designation s'affiche");
		order.setType_presta("formation");
		Order savedOrder = this.orderDao.save(order);
		
		//Act
		Order loadedOrder = this.orderDao.find(savedOrder.getId());
		
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
		//this.orderDao.delete(savedOrder.getId());
		
		//Assert
		Order loadedOrder = this.orderDao.find(savedOrder.getId());
		Assertions.assertNull(loadedOrder);
	}
	
}