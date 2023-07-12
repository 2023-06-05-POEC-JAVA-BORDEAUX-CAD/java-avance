package fr.testjpa;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.jpa.ClientJpa;
import fr.maboite.jpa.ClientJpaDao;
import fr.maboite.jpa.OrderDao;
import fr.maboite.jpa.OrderJpa;
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
		p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:file:C:/dev/h2-data/formation-poe-java-2023-07-11");
		return p;
	}

	@Test
	public void testSave() throws Exception {
		// Arrange
		String firstName = "Patrick";
		String lastName = "Bruel";
		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setFirstName(firstName);
		
		clientJpa.setLastName(lastName);

		// Act

		ClientJpa savedClientJpa = this.clientJpaDao.saveClient(clientJpa);

		// Assert

		Assertions.assertNotNull(savedClientJpa);
		Assertions.assertNotNull(savedClientJpa.getId());

	}

	@Test
	public void testgetElementById() throws Exception {
		// Arrange

		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setCompanyName("ib");
		ClientJpa savedClientJpa = this.clientJpaDao.saveClient(clientJpa);
		//saveClientJpa a créé l'id pour le client ib	
		
		// Act

		ClientJpa clientIdAttendu=clientJpaDao.findClient(savedClientJpa.getId());
		//recherce dans la base de donnée l'id du client créé

		// Assert
		Assertions.assertNotNull(clientIdAttendu);
		

	}
	
	 @Test
	    public void testFindByCompanyName()throws Exception{
	    	//Arrange
		 /*1er client */
	    	String nomCompany="2iTeck";
	    	ClientJpa clientjpa= new ClientJpa();
	    	clientjpa.setCompanyName(nomCompany);
	    	
	   
	    	
	    	/*sauve dans la base de donnée*/
	    	clientJpaDao.saveClient(clientjpa);
	    
	    	
	    	//Act
	    	List<ClientJpa> nomAttendu=this.clientJpaDao.findByCompanyName(nomCompany);
	    	
	    	//Assert
	    	Assertions.assertNotNull(nomAttendu);
	    	
	    	
	    }

}
