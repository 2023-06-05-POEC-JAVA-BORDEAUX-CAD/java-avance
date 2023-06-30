package tpjson.dao;

import java.util.ArrayList;
import java.util.HashMap;

import tpjson.model.Client;

public class PojoDao {
	

	public PojoDao() {
	}



	private  HashMap<Integer, Client> mesClients = new HashMap<>();

	public Client getClient(Integer id) {
		return mesClients.get(id);
	}

	
	
	public HashMap<Integer, Client> populateClient(int nbrClient) {
		for (int i = 0; i < nbrClient; i++) {
			mesClients.put(i,new Client("nom" + i, "prenom" + i));
		}
		return mesClients;
	}



}
