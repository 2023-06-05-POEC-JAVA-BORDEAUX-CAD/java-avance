package fr.maboite.correction.service;

import fr.maboite.correction.jpa.dao.ClientJpaDao;
import fr.maboite.correction.jpa.model.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	@Inject
	private ClientJpaDao clientJpaDao;
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	public Client save(Client client) {
		
		Client clientTest = new Client("companyNameTest","firstNameTest","lastNameTest","email@test.com","0123455678","118 rue du test","33000","Bordeaux","France",true);
		
		Client savedClient = clientJpaDao.save(clientTest);
		System.out.println(client);
		
		
		Client loadedClient = (Client) clientJpaDao.find(savedClient.getId());
		System.out.println(loadedClient);
		
		return clientJpaDao.save(client);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Client load(int id) {
		return clientJpaDao.find(id);
	}
	
	
	public void deleteById(int id) {
		Client ClientToDelete = clientJpaDao.find(id);
		System.out.println("suppression client: " + ClientToDelete.toString() );
		clientJpaDao.delete(ClientToDelete.getId());
	}
	
	
}

