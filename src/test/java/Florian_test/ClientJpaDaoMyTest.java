package Florian_test;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Florian.TP_entity.ClientEntityDao;
import Florian.TP_entity.ClientEntity;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJpaDaoMyTest {

	@EJB
	private ClientEntityDao clientEntityDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientEntityDao.class));
		return ejbJar;
	}

	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(ClientEntity.class);
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
		String lastNameClient = "coucou";
		
		ClientEntity client = new ClientEntity();
		client.setCompanyName("Test");
		
		//Act
		ClientEntity savedClientEntity = this.clientEntityDao.save(client);
		
		//Assert
		Assertions.assertNotNull(savedClientEntity);
		Assertions.assertNotNull(savedClientEntity.getId());
		
		Assertions.assertNull(savedClientEntity.getPhone());
		Assertions.assertEquals(lastNameClient, savedClientEntity.getLastName());
	}

}