package fr.groupe2.tpcrm.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.groupe2.tpcrm.dao.ClientDAO2;
import fr.groupe2.tpcrm.model.Client2;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService2 {

	@Inject
	private ClientDAO2 clientDAO;
	
	public String getClientByIdToString(Integer id) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Client2 client = this.clientDAO.getClientById(id);
		if(client == null) return null;
		return objectMapper.writeValueAsString(client);
	}
	
	public String getClientsToString() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<Integer, Client2> clients = this.clientDAO.getClients();
		if(clients == null || clients.isEmpty()) return null;
		return objectMapper.writeValueAsString(clients);
	}

}
