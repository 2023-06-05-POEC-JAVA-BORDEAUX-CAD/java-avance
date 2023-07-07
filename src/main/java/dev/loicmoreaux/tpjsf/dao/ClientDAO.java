package dev.loicmoreaux.tpjsf.dao;
import java.util.HashMap;
import java.util.Map;

import dev.loicmoreaux.tpjsf.model.Client;
import jakarta.ejb.Stateless;

@Stateless
public class ClientDAO {
	private Map<Integer, Client> clients = new HashMap<>();
	
	public ClientDAO()  {
		this.clients.put(1, new Client(1, "Capgemini", "Fabrice", "Martin", "martin@mail.com", "06 56 85 84 33", "abc", "xyz", "Nantes", "France",false));
		this.clients.put(2, new Client(2, "M2I Formation", "Julien", "Lamard", "lamard@mail.com", "06 11 22 33 44", "abc", "xyz", "Paris", "France",true));
	}
	
	public Client getClientById(Integer id) {
		return this.clients.get(id);
	}
	
	public Map<Integer, Client> getClients(){
		return this.clients;
	}
	
	public void addClient(Client newClient) {
		this.clients.put(newClient.getId(), newClient);
		//return "ajout du Client";
	}

}