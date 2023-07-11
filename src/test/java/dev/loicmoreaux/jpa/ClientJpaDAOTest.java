package dev.loicmoreaux.jpa;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.loicmoreaux.jpa.dao.ClientJpaDAO;
import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJpaDAOTest {
	@EJB
	private ClientJpaDAO clientJpaDAO;
	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDAO.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(ClientJpa.class);
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
		String companyName = "M2i";
		
		ClientJpa client = new ClientJpa();
		client.setCompanyName(companyName);
		
		//Act
		ClientJpa savedClient = this.clientJpaDAO.save(client);
		
		//Assert
		Assertions.assertNotNull(savedClient);
		Assertions.assertNotNull(savedClient.getId());
		
		Assertions.assertNull(savedClient.getCity());
		Assertions.assertEquals(companyName, savedClient.getCompanyName());
	}
	
	@Test
	public void testLoad() throws Exception {
		// Arrange
		String companyName = "M2i";
		
		ClientJpa client = new ClientJpa();
		client.setCompanyName(companyName);
		
		ClientJpa savedClient = this.clientJpaDAO.save(client);
		Integer savedClientId = savedClient.getId();
		
		//Act
		ClientJpa loadedClient = this.clientJpaDAO.load(savedClientId);
		
		//Assert
		Assertions.assertNotNull(loadedClient);
	}
	
	@Test
	public void testDelete() throws Exception {
		// Arrange
		String companyName = "M2i";
		
		ClientJpa client = new ClientJpa();
		client.setCompanyName(companyName);
		
		ClientJpa savedClient = this.clientJpaDAO.save(client);
		Integer savedClientId = savedClient.getId();
		
		//Act
		this.clientJpaDAO.delete(savedClientId);
		ClientJpa deletedClient = this.clientJpaDAO.load(savedClientId);
		
		//Assert
		Assertions.assertNull(deletedClient);
		
	}
}
