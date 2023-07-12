package fr.maboite;

import java.util.List;
import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
/*import jakarta.ejb.embeddable.EJBContainer;*/
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import fr.boite.philippe.ClientJpa;
import fr.boite.philippe.ClientJpaDao;
import fr.boite.philippe.OrderJpa;
import fr.boite.philippe.OrderJpaDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ClientJpaDaoTest {

	@EJB
	private ClientJpaDao clientJpaDao;

	@EJB
	private OrderJpaDao orderJpaDao;
	
	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJpaDao.class));
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
		String email = "hassan.Philippe@yahoo.com";
		
		ClientJpa clientJpa = new ClientJpa();
    	clientJpa.setLastName(last_name);
    	clientJpa.setEmail(email);
		
		//Arrange
    	//String last_name = "hassan";
		//String email = "hassan.Philippe@yahoo.com";
		
		//ClientJpa clientJpa = new ClientJpa();
    	//clientJpa.setLastName(last_name);
    	//clientJpa.setEmail(email);
		ClientJpa clientJpa1 = new ClientJpa();
		String companyName = "M2i Formation";
		clientJpa1.setCompanyName(companyName);
		clientJpaDao.save(clientJpa1);
		
		//Act
		//ClientJpa savedClientJpa = this.clientJpaDao.save(clientJpa);
		List<ClientJpa> companyNames = this.clientJpaDao.findByCompanyName(companyName);

		
		//Assert
		//Assertions.assertNotNull(savedClientJpa);
		Assertions.assertNotNull(companyNames);
		Assertions.assertEquals(1, companyNames.size());
	}
    
    @Test
	public void testSaveAndLoadWithOrders() throws Exception {
    	
    	//Arrange
    	ClientJpa clientJpa = new ClientJpa();
    	clientJpa.setFirstName("philippe");
    	clientJpa.setLastName("hassan");
    	ClientJpa savedClientJpa = this.clientJpaDao.save(clientJpa);
    	
    	OrderJpa orderJpa = new OrderJpa();
    	orderJpa.setClientJpa(savedClientJpa);
    	this.orderJpaDao.save(orderJpa);
    	
    	clientJpa.getOrders().add(orderJpa);
    	
    	//Act
    	ClientJpa loadedClientJpa = this.clientJpaDao.load(savedClientJpa.getId());
    	
    	//Assert
		Assertions.assertNotNull(loadedClientJpa);
		Assertions.assertEquals(savedClientJpa.getId(), loadedClientJpa.getId());
		Assertions.assertEquals(savedClientJpa.getFirstName(), loadedClientJpa.getFirstName());
		Assertions.assertEquals(savedClientJpa.getLastName(), loadedClientJpa.getLastName());

	}
    
}
