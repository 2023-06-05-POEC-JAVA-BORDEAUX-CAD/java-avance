package fr.maboite.correction.jpa.dao;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJpaDaoTest {

	@EJB
	private ClientJpaDao clientDao;

	@EJB
	private OrderJpaDao orderDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJpaDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setProvider(HibernatePersistenceProvider.class);
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Client.class);
        unit.addClass(Order.class);
        unit.setProperty("javax.persistence.schema-generation.database.action","drop-and-create");
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
		Client client = new Client();
		
		//Act
		Client savedClient = this.clientDao.save(client);
		
		//Assert
		Assertions.assertNotNull(savedClient);
		Assertions.assertNotNull(savedClient.getId());
		
	}
    
	@Test
	public void testSaveAndLoad() throws Exception {
		
		//Arrange
		Client client = new Client();
		client.setFirstName("Jean");
		client.setLastName("Dupont");
		client.setState(Boolean.TRUE);
		Client savedClient = this.clientDao.save(client);
		
		//Act
		Client loadedClient = this.clientDao.load(savedClient.getId());
		
		//Assert
		Assertions.assertNotNull(loadedClient);
		Assertions.assertEquals(savedClient.getId(), loadedClient.getId());
		Assertions.assertEquals(savedClient.getFirstName(), loadedClient.getFirstName());
		Assertions.assertEquals(savedClient.getLastName(), loadedClient.getLastName());
		Assertions.assertEquals(savedClient.getState(), loadedClient.getState());
		
	}
    
	@Test
	public void testSaveAndRemove() throws Exception {
		
		//Arrange
		Client client = new Client();
		client.setAddress("5 rue tabaga");
		Client savedClient = this.clientDao.save(client);
		
		//Act
		this.clientDao.delete(savedClient.getId());
		
		//Assert
		Client loadedClient = this.clientDao.load(savedClient.getId());
		Assertions.assertNull(loadedClient);
	}
    
	@Test
	public void testSave2ClientsAndFindByCompanyName() throws Exception {
		
		//Arrange
		Client client1 = new Client();
		String companyName = "World Company";
		client1.setCompanyName(companyName);
		this.clientDao.save(client1);
		
		Client client2 = new Client();
		client2.setCompanyName(companyName);
		this.clientDao.save(client2);
		
		//Act
		List<Client> clients = this.clientDao.findByCompanyName(companyName);
		
		//Assert
		Assertions.assertEquals(2, clients.size());
	}
	

    
	@Test
	public void testSaveAndLoadWithOrders() throws Exception {
		
		//Arrange
		Client client = new Client();
		client.setFirstName("Jean");
		client.setLastName("Dupont");
		client.setState(Boolean.TRUE);
		Client savedClient = this.clientDao.save(client);
		
		Order order = new Order();
		order.setDesignation("Commande du client");
		order.setClient(savedClient);
		this.orderDao.save(order);
		
		client.getOrders().add(order);
		 
		//Act
		List<Client> clients = this.clientDao.findByIdWithOrders(savedClient.getId());
		
		//Assert
		Assertions.assertNotNull(clients);
		Assertions.assertEquals(1, clients.size());
		Assertions.assertNotNull(clients.get(0).getOrders());
		Assertions.assertEquals(1, clients.get(0).getOrders().size());
		
	}
	
}