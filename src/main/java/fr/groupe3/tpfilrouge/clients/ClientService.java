package fr.groupe3.tpfilrouge.clients;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject
	private ClientDao clientDao;

	//methodes individuel
	public Client get(Integer id) {

		Client client = clientDao.getClient(id);

		return client;

	}

		
	public String toJson(Client client) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(client);
	}
	
	//methode pour List tous les clients
	
	public String mapToJson(Map <Integer, Client> clients)throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(clients.values());
		
		//return new ObjectMapper().writeValueAsString(clients.values());
		
		return jsonData;
	}

}