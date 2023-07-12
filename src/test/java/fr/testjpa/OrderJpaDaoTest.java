package fr.testjpa;

import java.util.Properties;
import java.util.List;

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
public class OrderJpaDaoTest {
	@EJB
	private OrderDao orderDao;
	
	@EJB
	private ClientJpaDao clientJpaDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDao.class));
		return ejbJar;
	}

	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(OrderJpa.class);
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
		String prestation = "coaching";
		OrderJpa orderjpa = new OrderJpa();
		orderjpa.setTypePresta(prestation);

		// Act
		OrderJpa savedorderjpa = this.orderDao.save(orderjpa);

		// Assert
		Assertions.assertNotNull(savedorderjpa);
		Assertions.assertNotNull(savedorderjpa.getId());

	}

	@Test
	public void OrderTestDaoJpaManyToOne() {
		//Arrange
		
		/*Création et sauvegarde d 'un client*/
		ClientJpa clientJpa = new ClientJpa();
		clientJpa.setFirstName("Kendrick");
		clientJpa.setLastName("LAMAR");
		 ClientJpa savedClient=this.clientJpaDao.saveClient(clientJpa);
		
		/*Création d un order rattaché à un client*/
		OrderJpa orderJpa=new OrderJpa();
		orderJpa.setClientJpa(savedClient);
		OrderJpa savedOrder=this.orderDao.save(orderJpa);
		
		
		//Arrange
		OrderJpa loadedOrder=this.orderDao.load(savedOrder.getId());
		
		//Assert
		
		// s'assure qu' il y a un Client
		Assertions.assertNotNull(loadedOrder.getClientJpa());
		
		
		//s'assure que l 'id du client est le même dans ClientJpa et OrderJpa
		Assertions.assertEquals(savedClient.getId(),loadedOrder.getClientJpa().getId());
		
		
		

	}

}
