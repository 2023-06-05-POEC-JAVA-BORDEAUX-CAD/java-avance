package fr.nicolas;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.nicolas.jpa.DAO.ClientDAO2;
import fr.nicolas.jpa.Entity.Client;
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

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientDAO2.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
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
		String designation = "Harribo";
		
		Client client = new Client();
		client.setCompanyName(designation);
		
		//Act
		Client savedOrder = this.clientDAO.save(client);
		
		//Assert
		Assertions.assertNotNull(savedOrder);
		Assertions.assertNotNull(savedOrder.getId());
		
		Assertions.assertNull(savedOrder.getEmail());
		Assertions.assertEquals(designation, savedOrder.getCompanyName());
	}
	
	
	@Test
	public void testDeleteById() throws Exception {
		//Arrange
		Client client = new Client();
		client.setCompanyName("Harribo");
		
		Client savedOrder1 = this.clientDAO.save(client);
		Client savedOrder2 = this.clientDAO.save(client);
		
		Assertions.assertNotNull(savedOrder1);
		Assertions.assertNotNull(savedOrder2);
		
		//Act
		
		this.clientDAO.delete(savedOrder2.getId());
		
		Client clientGet = this.clientDAO.find(savedOrder2.getId());
		
		Assertions.assertNull(clientGet);
	}
	
}
