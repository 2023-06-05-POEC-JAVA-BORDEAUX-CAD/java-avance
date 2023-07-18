package fr.groupe2.api;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import fr.groupe2.tpapi.dao.*;
import fr.groupe2.tpapi.model.*;
import jakarta.ejb.EJB;

/**
 * 
 * @author N Duquesne
 *
 */
@RunWithApplicationComposer
public class OrderDAOTest {

	@EJB
	private OrderDao orderDAO;
	
	@EJB
	private ClientDao clientDAO;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(ClientDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Order.class);
        unit.addClass(Client.class);
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
		String clientName = "Nicolas";
		
		Client client = new Client();
		client.setFirstName(clientName);
		
		Client savedClient = this.clientDAO.save(client);
		
		Order order = new Order();
		order.setDesignation(designation);
		order.setClient(savedClient);
		
		
		//Act
		Order savedOrder = this.orderDAO.save(order);
		
		//Assert
		Assertions.assertNotNull(savedOrder);
		Assertions.assertNotNull(savedClient);
		Assertions.assertNotNull(savedOrder.getClient());
		
		Assertions.assertEquals(designation, savedOrder.getDesignation());
		Assertions.assertNotNull(savedOrder.getClient().getFirstName());
	}
	
	
//	@Test
//	public void testDeleteById() throws Exception {
//		//Arrange
//		Order order = new Order();
//		order.setDesignation("Angular");
//		
//		Order savedOrder1 = this.orderDAO.save(order);
//		Order savedOrder2 = this.orderDAO.save(order);
//		
//		Assertions.assertNotNull(savedOrder1);
//		Assertions.assertNotNull(savedOrder2);
//		
//		//Act
//		
//		this.orderDAO.delete(savedOrder2.getId());
//		
//		Order orderGet = this.orderDAO.find(savedOrder2.getId()); 
//		Assertions.assertNull(orderGet);
//	}
	
}
