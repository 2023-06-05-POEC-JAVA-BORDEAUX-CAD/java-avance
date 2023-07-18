package fr.maboite.correction.jpa.dao;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.model.Product;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class ProductJpaDaoTest {

	@EJB
	private ProductJpaDao productDao;

	@EJB
	private OrderJpaDao orderDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(ProductJpaDao.class));
		ejbJar.addEnterpriseBean(new StatelessBean(OrderJpaDao.class));
		return ejbJar;
	}

	@org.apache.openejb.testing.Module
	public PersistenceUnit persistence() {
		PersistenceUnit unit = new PersistenceUnit("PersisterPU");
		unit.setProvider(HibernatePersistenceProvider.class);
		unit.setJtaDataSource("jtaTestDataSource");
		unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
		unit.addClass(Product.class);
		unit.addClass(Order.class);
		unit.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
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
		p.put("jtaTestDataSource.JdbcUrl", "jdbc:h2:mem:tests");
		return p;
	}

	@Test
	public void testSave() throws Exception {

		// Arrange
		Product product = new Product();

		// Act
		Product savedProduct = this.productDao.save(product);

		// Assert
		Assertions.assertNotNull(savedProduct);
		Assertions.assertNotNull(savedProduct.getId());

	}

	@Test
	public void testSaveAndLoad() throws Exception {

		// Arrange
		Product product = new Product();
		product.setName("Poignée de porte octogonale");
		product.setPrice(34_00);
		Product savedProduct = this.productDao.save(product);

		// Act
		Product loadedProduct = this.productDao.load(savedProduct.getId());

		// Assert
		Assertions.assertNotNull(loadedProduct);
		Assertions.assertEquals(savedProduct.getId(), loadedProduct.getId());
		Assertions.assertEquals(savedProduct.getPrice(), loadedProduct.getPrice());

	}

	@Test
	public void testSaveAndFindByName() throws Exception {

		// Arrange
		Product product = new Product();
		product.setName("marteau pilon thermobarique");
		product.setPrice(34_00);
		Product savedProduct = this.productDao.save(product);

		// Act
		// Assert
		Assertions.assertFalse(this.productDao.findByName(null).isEmpty());
		Assertions.assertFalse(this.productDao.findByName("").isEmpty());
		Assertions.assertFalse(this.productDao.findByName("marteau").isEmpty());
		Assertions.assertFalse(this.productDao.findByName("PILON").isEmpty());
		Assertions.assertTrue(this.productDao.findByName("jean").isEmpty());

	}

	@Test
	public void testSaveAndRemove() throws Exception {

		// Arrange
		Product product = new Product();
		Product savedProduct = this.productDao.save(product);

		// Act
		this.productDao.delete(savedProduct.getId());

		// Assert
		Product loadedProduct = this.productDao.load(savedProduct.getId());
		Assertions.assertNull(loadedProduct);
	}

//	@Test
//	public void testSaveAndLoadWithOrders() throws Exception {
//
//		// Arrange
//		Product product = new Product();
//		product.setFirstName("Jean");
//		product.setLastName("Dupont");
//		product.setState(Boolean.TRUE);
//		Product savedProduct = this.productDao.save(product);
//
//		Order order = new Order();
//		order.setDesignation("Commande du product");
//		order.setProduct(savedProduct);
//		this.orderDao.save(order);
//
//		product.getOrders().add(order);
//
//		// Act
//		List<Product> products = this.productDao.findByIdWithOrders(savedProduct.getId());
//
//		// Assert
//		Assertions.assertNotNull(products);
//		Assertions.assertEquals(1, products.size());
//		Assertions.assertNotNull(products.get(0).getOrders());
//		Assertions.assertEquals(1, products.get(0).getOrders().size());
//
//	}

}