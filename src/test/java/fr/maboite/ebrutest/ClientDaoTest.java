package fr.maboite.ebrutest;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.ebru.jpa.entity.ClientJpaDao;
import fr.maboite.ebru.jpa.entity.ClientJPA;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientDaoTest {

	@EJB
	private ClientJpaDao clientDao;

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
	public void testSave() throws Exception {

		// Arrange

		ClientJPA clientJpa = new ClientJPA();
		
		clientJpa.setCompanyName("Capgemini");
		clientJpa.setFirstName("Fabrice");
		clientJpa.setLastName("Martin");
		clientJpa.setEmail("martin@mail.com");
		clientJpa.setPhone("06 56 85 84 33");
		clientJpa.setAdress("abc");
		clientJpa.setZipCode("xyz");
		clientJpa.setCity("Nantes");
		clientJpa.setCountry("France");
		clientJpa.setState(false);

		// Act
		ClientJPA testsaveJpa = clientDao.save(clientJpa);

		// Assert
		Assertions.assertNotNull(clientJpa);
		Assertions.assertNotNull(testsaveJpa);
		Assertions.assertNotNull(testsaveJpa.getId());

		
		Assertions.assertEquals("Capgemini",testsaveJpa.getCompanyName());
		Assertions.assertEquals(clientJpa.getFirstName(), testsaveJpa.getFirstName());
		Assertions.assertEquals("Martin", testsaveJpa.getLastName());
		Assertions.assertEquals("martin@mail.com", testsaveJpa.getEmail());
		Assertions.assertEquals("06 56 85 84 33", testsaveJpa.getPhone());
		Assertions.assertEquals("abc", testsaveJpa.getAdress());
		Assertions.assertEquals("xyz", testsaveJpa.getZipCode());
		Assertions.assertEquals("Nantes", testsaveJpa.getCity());
		Assertions.assertEquals("France", testsaveJpa.getCountry());
		Assertions.assertEquals(false, testsaveJpa.getState());

	}

}
