package fr.maboite;

import java.util.List;
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
import fr.boite.philippe.OrderJpa;
import fr.boite.philippe.OrderJpaDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrderJpaDaoTest {

	@EJB
	private OrderJpaDao orderJpaDao;
	@EJB
	private ClientJpaDao clientJpaDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ClientJpaDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJpaDao.class));

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
        p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:test");
        return p;
    }
    
    @Test
	public void testSave() throws Exception {
		
		//Arrange
		//String typePresta = "Bonjour_Philippe";
		//OrderJpa orderJpa = new OrderJpa();
		//orderJpa.setTypePresta(typePresta);
    	OrderJpa orderJpa = new OrderJpa();
		String designation = "Bonjour Philippe";
		orderJpa.setDesignation(designation);
		orderJpaDao.save(orderJpa);
		
		//Act
		//OrderJpa savedOrderJpa = this.orderJpaDao.save(orderJpa);
		List<OrderJpa> designations = this.orderJpaDao.findByDesignation(designation);
		
		//Assert
		//Assertions.assertNotNull(savedOrderJpa);
		Assertions.assertNotNull(designations);
		Assertions.assertEquals(1, designations.size());
	}
    
    @Test
   	public void testSaveAndLoadWithClient() throws Exception {
   		 //Arrange  		
       	OrderJpa orderJpa = new OrderJpa();
       	       	       	
       	ClientJpa clientJpa = new ClientJpa();
       	ClientJpa savedClientJpa = this.clientJpaDao.save(clientJpa);
       	
       	orderJpa.setClientJpa(savedClientJpa);
       	    	      	
       	//ClientJpa.setClientJpa(savedClientJpa);
     
   		//Act
   		OrderJpa savedOrderJpa = this.orderJpaDao.save(orderJpa);
   		
   		//Assert
   		Assertions.assertNotNull(savedOrderJpa);
   		
   	}
    
}
