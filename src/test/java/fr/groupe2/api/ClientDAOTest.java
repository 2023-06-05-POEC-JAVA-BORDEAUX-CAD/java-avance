package fr.groupe2.api;
import java.util.List;
import java.util.ArrayList;
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
public class ClientDAOTest {

	@EJB
	private ClientDao clientDao;
	
	@EJB
	private OrderDao orderDAO;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
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
		Client savedClient = this.clientDao.save(client);
		
		
		//Assert
		Assertions.assertNotNull(savedClient);
		Assertions.assertNotNull(savedClient.getId());
		Assertions.assertEquals(designation, savedClient.getCompanyName());
	}

	
	@Test
	public void getClients() throws Exception {
		
		//Act
		List<Client> clients = this.clientDao.getAllClients();
		
		//Assert
		Assertions.assertNotNull(clients);
		Assertions.assertNotNull(clients.get(0));
	}
	
	@Test public void getClient() throws Exception {
		Client client = this.clientDao.find(1);
		
		Assertions.assertNotNull(client);
	}
	
	
	
	@Test
	public void testDeleteById() throws Exception {
		//Arrange
		String compName = "Harribo";
		Client client = new Client();
		client.setCompanyName(compName);
		
		Client savedOrder1 = this.clientDao.save(client);
		Client savedOrder2 = this.clientDao.save(client);
		
		Assertions.assertNotNull(savedOrder1);
		Assertions.assertNotNull(savedOrder2);
		
		//Act
		
		this.clientDao.delete(savedOrder2.getId());
		
		Client clientGet = this.clientDao.find(savedOrder2.getId());
		
		Assertions.assertNull(clientGet);
	}
	
}
