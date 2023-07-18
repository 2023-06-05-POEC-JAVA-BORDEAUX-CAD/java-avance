package fr.groupe2.tpcrm.dao;
import java.util.HashMap;
import java.util.Map;

import fr.groupe2.tpcrm.model.Client2;
import jakarta.ejb.Stateless;

@Stateless
public class ClientDAO2 {
	private Map<Integer, Client2> clients = new HashMap<>();
	
	public ClientDAO2()  {
		this.clients.put(1, new Client2(1, "Capgemini", "Fabrice", "Martin", "martin@mail.com", "06 56 85 84 33", "abc", "xyz", "Nantes", "France",false));
		this.clients.put(2, new Client2(2, "M2I Formation", "Julien", "Lamard", "lamard@mail.com", "06 11 22 33 44", "abc", "xyz", "Paris", "France",true));
	}
	
	public Client2 getClientById(Integer id) {
		return this.clients.get(id);
	}
	
	public Map<Integer, Client2> getClients(){
		return this.clients;
	}

}
