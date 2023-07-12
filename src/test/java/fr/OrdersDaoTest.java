package fr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.jpa.Clients.Clients;
import fr.jpa.Clients.ClientsDao;
import fr.jpa.Orders.Orders;
import fr.jpa.Orders.OrdersDao;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class OrdersDaoTest {

	@EJB
	private OrdersDao ordersDao;
    private ClientsDao clientsDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(OrdersDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(Orders.class);
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
		String nomOrders = "Designation Test";
		
		Orders orders = new Orders();
		orders.setDesignation(nomOrders);
		
		//Act
		Orders savedOrders = this.ordersDao.save(orders);
		
		//Assert
		Assertions.assertNotNull(savedOrders);
		Assertions.assertNotNull(savedOrders.getId());
		
		Assertions.assertNull(savedOrders.getTypePresta());
		Assertions.assertEquals(nomOrders, savedOrders.getDesignation());
	}

     @Test
    public void testSaveOrderWithClient() {
        // Créer un nouveau client
        Clients client = new Clients();
        client.setFirstName("John Doe");
        
        // Sauvegarder le client
        Clients savedClient = this.clientsDao.save(client);
        
        // Créer un nouvel order
        Orders order = new Orders();
        order.setDesignation("Formation");
        order.setTypePresta("Bowling");
        order.setClient(savedClient);
        
        // Sauvegarder l'order
        Orders savedOrder = this.ordersDao.save(order);
        
        // Charger l'order depuis la base de données
        Orders loadedOrder = ordersDao.load(savedOrder.getId());
        
        // Vérifier que la relation a été sauvegardée
        assertNotNull(loadedOrder);
        assertNotNull(loadedOrder.getClient());
        assertEquals(client.getId(), loadedOrder.getClient().getId());
    }
  
}
