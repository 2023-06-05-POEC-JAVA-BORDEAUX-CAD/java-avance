package fr;



import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.jpa.Clients.Clients;
import fr.jpa.Clients.ClientsDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientsDaoTest {

	@EJB
	private ClientsDao clientsDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientsDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Clients.class);
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
	public void testSave() throws Exception {
		
		//Arrange
		String nomClients = "Last Name Test";
		
		Clients clients = new Clients();
		clients.setLastName(nomClients);
		
		//Act
		Clients savedClients = this.clientsDao.save(clients);
		
		//Assert
		Assertions.assertNotNull(savedClients);
		Assertions.assertNotNull(savedClients.getId());
		
		Assertions.assertNull(savedClients.getEmail());
		Assertions.assertEquals(nomClients, savedClients.getLastName());
	}

    @Test
	public void testSave2OrdersAndFindByCompanyName() throws Exception {
		
		//Arrange
		Clients client1 = new Clients();
		String companyName = "super company name";
		client1.setCompanyName(companyName);
		Clients savedClient1 = this.clientsDao.save(client1);
		Clients client2 = new Clients();
		client2.setCompanyName(companyName);
		Clients savedClient2 = this.clientsDao.save(client2);
		
		//Act
		List<Clients> companyNames = this.clientsDao.findByCompanyName(companyName);
		
		//Assert
		Assertions.assertNotNull(companyNames);
		Assertions.assertEquals(2, companyNames.size());
	}  
  
}