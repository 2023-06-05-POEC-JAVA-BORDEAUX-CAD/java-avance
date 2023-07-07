package fr.nicolas.facebean.tpClient.Service;
import java.util.List;
import java.util.Map;

import fr.nicolas.facebean.tpClient.DAO.ClientDAO;
import fr.nicolas.facebean.tpClient.Entity.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	
	@Inject
	ClientDAO clientDAO;
	
	public ClientService() {}

	public Map<Integer, Client> getClients() {
		
		return clientDAO.getClients();
	}
	
	
	public Client getClient(Integer id) {
		return clientDAO.getClientById(id);
	}
	
	public Client getDummyClient() {
		return clientDAO.getClientById(1);
	}
	
	public void save(Client client) {
		clientDAO.insertClient(client);
	}
	
}
