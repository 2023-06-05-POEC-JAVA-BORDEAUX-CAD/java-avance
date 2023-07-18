package filRouge.service;


import java.util.List;

import filRouge.Dao.ClientDao;
import filRouge.model.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientService {
	@Inject
	private ClientDao clientDao;
	
	/**
	 * 
	 * @param client
	 * @return
	 */
	public Client save(Client client) {
		
	
		return clientDao.save(client);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Client load(int id) {
		return clientDao.find(id);
	}
	
	public List<Client> findAll(){
		 return clientDao.findAll();

	}
	
	public void deleteById(int id) {
		Client ClientToDelete = clientDao.find(id);
		System.out.println("suppression client: " + ClientToDelete.toString() );
		clientDao.delete(ClientToDelete.getId());
	}
	
	
}

