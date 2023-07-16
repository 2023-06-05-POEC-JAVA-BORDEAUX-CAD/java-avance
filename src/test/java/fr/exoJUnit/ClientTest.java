package fr.exoJUnit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.maboite.exoJPA.Client.ClientEntity;
import fr.maboite.exoJPA.Client.ClientJpaDao;

public class ClientTest {
	
	ClientJpaDao clientDao = new ClientJpaDao();
	
	@Test
	public void testFindByCompanyName() throws Exception {
		
		//Arrange
		ClientEntity client1 = new ClientEntity();
		String companyName = "super compagny";
		client1.setCompanyName(companyName);
		ClientEntity savedClient1 = this.clientDao.save(client1);
		
		ClientEntity client2 = new ClientEntity();
		client2.setCompanyName(companyName);
		ClientEntity savedClient2 = this.clientDao.save(client2);
		
		//Act
		List<ClientEntity> companyNames = this.clientDao.findByCompanyName(companyName);
		
		//Assert
		Assertions.assertNotNull(companyNames);
		Assertions.assertEquals(2, companyNames.size());
	}

}
