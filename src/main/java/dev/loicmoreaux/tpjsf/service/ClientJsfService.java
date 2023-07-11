package dev.loicmoreaux.tpjsf.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.loicmoreaux.tpjsf.dao.ClientJsfDAO;
import dev.loicmoreaux.tpjsf.model.ClientJsf;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJsfService {

	@Inject
	private ClientJsfDAO clientDAO;
	
	public String getClientByIdToString(Integer id) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ClientJsf client = this.clientDAO.getClientById(id);
		if(client == null) return null;
		return objectMapper.writeValueAsString(client);
	}
	
	public String getClientsToString() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<Integer, ClientJsf> clients = this.clientDAO.getClients();
		if(clients == null || clients.isEmpty()) return null;
		return objectMapper.writeValueAsString(clients);
	}
	
	public ClientJsf getClientById(Integer id) {
		return clientDAO.getClientById(id);
	}
	
	public void addClient(ClientJsf newClient) {
		 clientDAO.addClient(newClient);
	}
}