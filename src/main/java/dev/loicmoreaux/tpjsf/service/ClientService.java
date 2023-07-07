package dev.loicmoreaux.tpjsf.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.loicmoreaux.tpjsf.controllers.ClientFormBean;
import dev.loicmoreaux.tpjsf.dao.ClientDAO;
import dev.loicmoreaux.tpjsf.model.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject
	private ClientDAO clientDAO;
	
	public String getClientByIdToString(Integer id) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Client client = this.clientDAO.getClientById(id);
		if(client == null) return null;
		return objectMapper.writeValueAsString(client);
	}
	
	public String getClientsToString() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<Integer, Client> clients = this.clientDAO.getClients();
		if(clients == null || clients.isEmpty()) return null;
		return objectMapper.writeValueAsString(clients);
	}
	
	public Client getClientById(Integer id) {
		return clientDAO.getClientById(id);
	}
	
	public void addClient(Client newClient) {
		 clientDAO.addClient(newClient);
	}
}