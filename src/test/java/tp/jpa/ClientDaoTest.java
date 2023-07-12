package tp.jpa;

import java.util.List;
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

	public ClientModel clientGenerator() {
		String[] compname = { "Axa", "Total", "BNP", "Carrefour", "EDF" };
		String[] firstname = { "Marie", "Julie", "Joris", "Olaf", "Dolfi" };
		String[] lastname = { "Radolf", "Guerric", "Dionisio", "Kesari" };
		String[] mail = { "na@wa.k", "nimp@orte.koi", "foo@bar.baz", "beer@pon.g" };
		String[] phone = { "0417606761", "0300823836", "0136867849", "0483111478" };
		String[] adress = { "15 Rue la Porte", "22 Avenue le clou", "3 boulevard zdedededex" };
		String[] zip = { "XYZ", "70123", "75006", "33542", "64547", "40331" };
		String[] city = { "Nawak", "Paris", "Gironde", "Landes", "Nopnop" };
		String[] country = { "France" };
		State[] states = { State.CANCELED, State.CONFIRMED, State.OPTION };
		ClientModel client = new ClientModel();
		client.setCompanyName(compname[(int) Math.floor(Math.random() * 5)]);
		client.setFirstName(firstname[(int) Math.floor(Math.random() * 5)]);
		client.setLastName(lastname[(int) Math.floor(Math.random() * 4)]);
		client.setEmail(mail[(int) Math.floor(Math.random() * 4)]);
		client.setPhone(phone[(int) Math.floor(Math.random() * 4)]);
		client.setAdress(adress[(int) Math.floor(Math.random() * 3)]);
		client.setZipCode(zip[(int) Math.floor(Math.random() * 6)]);
		client.setCity(city[(int) Math.floor(Math.random() * 5)]);
		client.setCountry(country[(int) Math.floor(Math.random() * 1)]);
		client.setState(states[(int) Math.floor(Math.random() * 3)]);
		return client;
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
		ClientModel client = clientGenerator();
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
		ClientModel client = clientGenerator();
		client = clidao.save(client);

		ClientModel saved = clidao.load(client.getId());

		assertNotNull(client);
		assertNotNull(saved);
		assertEquals(client.getId(), saved.getId());
	}

	@Test
	public void delete() {
		ClientModel client = clientGenerator();
		client = clidao.save(client);

		ClientModel deleted = clidao.delete(client.getId());

		assertNotNull(client);
		assertNotNull(deleted);
		assertEquals(client.getId(), deleted.getId());
	}

	@Test
	public void getAllByCompanyNameTest() {
		for (int i = 0; i < 5; i++) {
			ClientModel client = clientGenerator();
			if (i < 3) {
				client.setCompanyName("CUSTOM NAME");
			}
			ClientModel saved = clidao.save(client);
			assertNotNull(client);
			assertNotNull(saved);
		}

		List<ClientModel> try1 = clidao.getAllByCompanyName("CUSTOM NAME");
		List<ClientModel> try2 = clidao.getAllByCompanyName("NOP");

		assertEquals(try1.size(), 3);
		assertEquals(try2.size(), 0);
	}
}