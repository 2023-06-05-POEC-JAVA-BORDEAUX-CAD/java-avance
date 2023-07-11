package fr.nicolas;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.nicolas.jpa.DAO.OrderDAO;
import fr.nicolas.jpa.Entity.Order;
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
        unit.setExcludeUnlistedClasses(true);
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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:file:G:/moi/Documents/M2i/modules/h2-data/formation-poe-java-2023-07-11");
        return p;
    }
    
	@Test
	public void testSave() throws Exception {
		
		//Arrange
		String designation = "Angular avancé";
		
		Order order = new Order();
		order.setDesignation(designation);
		
		//Act
		Order savedOrder = this.orderDAO.save(order);
		
		//Assert
		Assertions.assertNotNull(savedOrder);
		Assertions.assertNotNull(savedOrder.getId());
		
		Assertions.assertNull(savedOrder.getTypePresta());
		Assertions.assertEquals(designation, savedOrder.getDesignation());
	}
	
	
	@Test
	public void testDeleteById() throws Exception {
		//Arrange
		Order order = new Order();
		order.setDesignation("Angular");
		
		Order savedOrder1 = this.orderDAO.save(order);
		Order savedOrder2 = this.orderDAO.save(order);
		
		Assertions.assertNotNull(savedOrder1);
		Assertions.assertNotNull(savedOrder2);
		
		//Act
		
		this.orderDAO.delete(2);
		
		
		Assertions.assertNull(savedOrder2);
	}
	
}
