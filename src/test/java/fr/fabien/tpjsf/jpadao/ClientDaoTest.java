package fr.fabien.tpjsf.jpadao;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.fabien.tpjsf.jpamodel.Client;
import fr.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientDaoTest {

	@EJB
	private ClientDao clientDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientDao.class));
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
		client.setCity("Bordeaux");
		Client savedClient = this.clientDao.save(client);
		
		//Act
		Client loadedClient = this.clientDao.find(savedClient.getId());
		
		//Assert
		Assertions.assertNotNull(loadedClient);
		Assertions.assertEquals(savedClient.getId(), loadedClient.getId());
		Assertions.assertEquals(savedClient.getCity(), loadedClient.getCity());
		
	}
    
	@Test
	public void testSaveAndRemove() throws Exception {
		
		//Arrange
		Client client = new Client();
		client.setCity("Bordeaux");
		Client savedClient = this.clientDao.save(client);
		
		//Act
		this.clientDao.delete(savedClient.getId());
		
		//Assert
		Client loadedClient = this.clientDao.find(savedClient.getId());
		Assertions.assertNull(loadedClient);
	}
	
}