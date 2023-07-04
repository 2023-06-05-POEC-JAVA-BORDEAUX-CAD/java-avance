package fr.groupe2.webserver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.junit5.RunWithApplicationComposer;
import org.junit.jupiter.api.Test;
import jakarta.ejb.EJB;
import fr.group2.webserver.CatService;
import fr.group2.webserver.CatDAO;

@RunWithApplicationComposer
public class CatServiceTestCDI {

	@EJB
	private CatService cs;

	
	@org.apache.openejb.testing.Module
	public EjbJar beans() {
		EjbJar ejbJar = new EjbJar("my-beans");
		ejbJar.addEnterpriseBean(new StatelessBean(CatDAO.class));
		ejbJar.addEnterpriseBean(new StatelessBean(CatService.class));
		return ejbJar;
	}
	
	
	@Test
	public void getCatTestIdValid() {
		
		assertNotNull(cs.getCat(1));
	}
	
}
