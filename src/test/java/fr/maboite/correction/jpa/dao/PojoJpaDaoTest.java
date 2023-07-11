package fr.maboite.correction.jpa.dao;

import java.util.Properties;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.EJB;

@RunWithApplicationComposer
public class PojoJpaDaoTest {

	@EJB
	private PojoJpaDao pojoJpaDao;

	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(PojoJpaDao.class));
		return ejbJar;
	}
	
    @org.apache.openejb.testing.Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("PersisterPU");
        unit.setJtaDataSource("jtaTestDataSource");
        unit.setNonJtaDataSource("jtaTestDataSourceUnManaged");
        unit.addClass(PojoJpa.class);
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
		
		//Arrange
		String nomPojo = "coucou";
		
		PojoJpa pojoJpa = new PojoJpa();
		pojoJpa.setNom(nomPojo);
		
		//Act
		PojoJpa savedPojoJpa = this.pojoJpaDao.save(pojoJpa);
		
		//Assert
		Assertions.assertNotNull(savedPojoJpa);
		Assertions.assertNotNull(savedPojoJpa.getId());
		
		Assertions.assertNull(savedPojoJpa.getAdresse());
		Assertions.assertEquals(nomPojo, savedPojoJpa.getNom());
	}
	
}