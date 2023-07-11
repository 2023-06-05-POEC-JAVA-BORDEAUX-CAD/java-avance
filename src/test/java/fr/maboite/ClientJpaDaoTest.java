package fr.maboite;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.boite.philippe.ClientJpa;
import fr.boite.philippe.ClientJpaDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJpaDaoTest {

	@EJB
	private ClientJpaDao clientJpaDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDao.class));
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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:test");
        return p;
    }
    
    @Test
	public void testSave() throws Exception {
		
		//Arrange
    	String last_name = "hassan";
		//String email = "hassan.Philippe@yahoo.com";
		
		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setLastName(last_name);
	//	clientJpa.setEmail(email);
		
		//Act
		ClientJpa savedClientJpa = this.clientJpaDao.save(clientJpa);
		
		//Assert
		Assertions.assertNotNull(savedClientJpa);
	}
}
