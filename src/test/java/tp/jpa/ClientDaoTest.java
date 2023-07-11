package tp.jpa;

import jakarta.ejb.EJB;
import java.util.Properties;
import tp.jpa.ClientModel.State;
import org.junit.jupiter.api.Test;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.testing.Module;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWithApplicationComposer
public class ClientDaoTest {
	@EJB
	private ClientDao clidao;

	@Module
	public EjbJar beans() {
		EjbJar ejb = new EjbJar("ordao");
		ejb.addEnterpriseBean(new StatelessBean(ClientDao.class));
		return ejb;
	}

	@Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(ClientModel.class);
		unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		unit.setProperty("openjpa.Log", "DefaultLevel=WARN,Runtime=INFO,Tool=INFO,SQL=TRACE");
		return unit;
	}

	@Configuration
	public Properties config() throws Exception {
		Properties props = new Properties();
		props.put("jtaTestDataSource", "new://Resource?type=DataSource");
		props.put("jtaTestDataSource.JdbcDriver", "org.h2.Driver");
		props.put("jtaTestDataSource.username", "root");
		props.put("jtaTestDataSource.password", "");
		props.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:test");
		return props;
	}

	@Test
	public void save() {
		ClientModel client = new ClientModel();
		client.setCompanyName("NAME");
		client.setFirstName("TestName");
		client.setLastName("LastName");
		client.setEmail("faketest@test.com");
		client.setPhone("0542134302");
		client.setAdress("Adresse de test");
		client.setZipCode("XYZ");
		client.setCity("VilleTest");
		client.setCountry("FRANCE");
		client.setState(State.CONFIRMED);
		ClientModel saved = clidao.save(client);

		assertNotNull(client);
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertEquals(client.getCompanyName(), saved.getCompanyName());
		assertEquals(client.getFirstName(), saved.getFirstName());
		assertEquals(client.getLastName(), saved.getLastName());
		assertEquals(client.getEmail(), saved.getEmail());
		assertEquals(client.getPhone(), saved.getPhone());
		assertEquals(client.getAdress(), saved.getAdress());
		assertEquals(client.getZipCode(), saved.getZipCode());
		assertEquals(client.getCity(), saved.getCity());
		assertEquals(client.getCountry(), saved.getCountry());
		assertEquals(client.getState(), saved.getState());
	}

	@Test
	public void load() {
		ClientModel client = new ClientModel();
		client.setCompanyName("NAME");
		client.setFirstName("TestName");
		client.setLastName("LastName");
		client.setEmail("faketest@test.com");
		client.setPhone("0542134302");
		client.setAdress("Adresse de test");
		client.setZipCode("XYZ");
		client.setCity("VilleTest");
		client.setCountry("FRANCE");
		client.setState(State.CONFIRMED);
		client = clidao.save(client);

		ClientModel saved = clidao.load(client.getId());

		assertNotNull(client);
		assertNotNull(saved);
		assertEquals(client.getId(), saved.getId());
	}

	@Test
	public void delete() {
		ClientModel client = new ClientModel();
		client.setCompanyName("NAME");
		client.setFirstName("TestName");
		client.setLastName("LastName");
		client.setEmail("faketest@test.com");
		client.setPhone("0542134302");
		client.setAdress("Adresse de test");
		client.setZipCode("XYZ");
		client.setCity("VilleTest");
		client.setCountry("FRANCE");
		client.setState(State.CONFIRMED);
		client = clidao.save(client);

		ClientModel deleted = clidao.delete(client.getId());

		assertNotNull(client);
		assertNotNull(deleted);
		assertEquals(client.getId(), deleted.getId());
	}
}