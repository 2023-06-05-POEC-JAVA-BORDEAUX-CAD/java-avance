package dev.loicmoreaux.tpjsf.dao;
import java.util.HashMap;
import java.util.Map;

import dev.loicmoreaux.tpjsf.model.ClientJsf;
import jakarta.ejb.Stateless;

@Stateless
public class ClientJsfDAO {
	private Map<Integer, ClientJsf> clients = new HashMap<>();
	
	public ClientJsfDAO()  {
		this.clients.put(1, new ClientJsf(1, "Capgemini", "Fabrice", "Martin", "martin@mail.com", "06 56 85 84 33", "abc", "xyz", "Nantes", "France",false));
		this.clients.put(2, new ClientJsf(2, "M2I Formation", "Julien", "Lamard", "lamard@mail.com", "06 11 22 33 44", "abc", "xyz", "Paris", "France",true));
	}
	
	public ClientJsf getClientById(Integer id) {
		return this.clients.get(id);
	}
	
	public Map<Integer, ClientJsf> getClients(){
		return this.clients;
	}
	
	public void addClient(ClientJsf newClient) {
		this.clients.put(newClient.getId(), newClient);
		//return "ajout du Client";
	}

}