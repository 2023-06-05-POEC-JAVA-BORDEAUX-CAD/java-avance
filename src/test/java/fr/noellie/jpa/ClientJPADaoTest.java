package fr.noellie.jpa;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.noellie.jpa.dao.ClientJPADao;
import fr.noellie.jpa.model.ClientJPA;
import fr.noellie.jpa.model.EtatClient;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJPADaoTest {

	@EJB
	private ClientJPADao clientJPADao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJPADao.class));
		return ejbJar;
	}

	@Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(ClientJPA.class);
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
	public void testSaveClientJPADao() throws Exception {
		// Arrange
		String companyName = "Sopra Steria";
		
		ClientJPA clientJPA = new ClientJPA();
		clientJPA.setCompanyName("Sopra Steria");
		clientJPA.setFirstName("Michel");
		clientJPA.setLastName("Drücker");
		clientJPA.setEmail("michel.drucker@mail.fr");
		clientJPA.setPhone("06 06 06 06 06");
		clientJPA.setAdress("123 Rue des Lilas");
		clientJPA.setZipCode("75002");
		clientJPA.setCity("Paris");
		clientJPA.setCountry("France");
		clientJPA.setState(EtatClient.INACTIVE);
		
		// Act
		ClientJPA savedClient = clientJPADao.save(clientJPA);

		// Assert
		Assertions.assertEquals(companyName, savedClient.getCompanyName());
	}

	@Test
	public void testLoadClientJPADao() throws Exception {
		// Arrange
		String companyName = "Mairie de Bayonne";
		String firstName = "Patrick";
		String lastName = "Sébastien";
		String email = "patrick.sebastien@mail.fr";
		String phone = "06 06 06 06 06";

		ClientJPA clientJPA = new ClientJPA();
		clientJPA.setCompanyName("Mairie de Bayonne");
		clientJPA.setFirstName("Patrick");
		clientJPA.setLastName("Sébastien");
		clientJPA.setEmail("patrick.sebastien@mail.fr");
		clientJPA.setPhone("06 06 06 06 06");
		clientJPA.setAdress("123 Rue des Lilas");
		clientJPA.setZipCode("64100");
		clientJPA.setCity("Bayonne");
		clientJPA.setCountry("France");
		clientJPA.setState(EtatClient.ACTIVE);

		// Act
		ClientJPA savedClient = clientJPADao.save(clientJPA);
		
		ClientJPA loadedClient = clientJPADao.load(savedClient.getId());

		// Assert
		Assertions.assertEquals(companyName, loadedClient.getCompanyName());
		Assertions.assertEquals(firstName, loadedClient.getFirstName());
		Assertions.assertEquals(lastName, loadedClient.getLastName());
		Assertions.assertEquals(email, loadedClient.getEmail());
		Assertions.assertEquals(phone, loadedClient.getPhone());
	}
}
