package fr.nicolas;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.nicolas.jpa.DAO.ClientDAO2;
import fr.nicolas.jpa.DAO.OrderDAO;
import fr.nicolas.jpa.Entity.Client;
import fr.nicolas.jpa.Entity.Order;
import jakarta.ejb.EJB;

/**
 * 
 * @author N Duquesne
 *
 */
@RunWithApplicationComposer
public class ClientDAOTest {

	@EJB
	private ClientDAO2 clientDAO;
	
	@EJB
	private OrderDAO orderDAO;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientDAO2.class));
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDAO.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Client.class);
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
		String designation = "Harribo";
		
		
		//Act
		
		Client client = new Client();
		client.setCompanyName(designation);
		Client savedClient = this.clientDAO.save(client);
		
		Order order = new Order();
		order.setClient(savedClient);
		
		Order savedOrder = this.orderDAO.save(order);
		
		
		//Assert
		Assertions.assertNotNull(savedClient);
		Assertions.assertNotNull(savedOrder);
		
		Assertions.assertNotNull(savedClient.getOrders());
		Assertions.assertEquals(designation, savedClient.getCompanyName());
		Assertions.assertEquals(1, savedClient.getOrders().size());
	}
	
	
	@Test
	public void testDeleteById() throws Exception {
		//Arrange
		String compName = "Harribo";
		Client client = new Client();
		client.setCompanyName(compName);
		
		Client savedOrder1 = this.clientDAO.save(client);
		Client savedOrder2 = this.clientDAO.save(client);
		
		Assertions.assertNotNull(savedOrder1);
		Assertions.assertNotNull(savedOrder2);
		
		//Act
		
		this.clientDAO.delete(savedOrder2.getId());
		
		Client clientGet = this.clientDAO.find(savedOrder2.getId());
		
		Assertions.assertNull(clientGet);
	}
	
	@Test
	public void getClientByCompanyName() throws Exception {
		//Arrange
		Client client = new Client();
		String compName = "Harribo";
		client.setCompanyName(compName);
		
		Client savedOrder1 = this.clientDAO.save(client);
		
		
		//Act 
		
		List<Client> clients = this.clientDAO.getClientByCompName(compName);
		
		for(Client cli: clients) {
			System.out.println(cli.getCompanyName());
		}
		
		Assertions.assertNotNull(clients);
		
		Assertions.assertNotEquals(1, clients.size());
		
	}
	
}
