package fr.groupe2.tpcrm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.groupe2.tpcrm.dao.ClientDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject
	private ClientDAO clientDAO;
	
	public String getClientByIdToString(Integer id) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this.clientDAO.getClientById(id));
	}
	
	public String getClientsToString() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this.clientDAO.getClients());
	}

}
