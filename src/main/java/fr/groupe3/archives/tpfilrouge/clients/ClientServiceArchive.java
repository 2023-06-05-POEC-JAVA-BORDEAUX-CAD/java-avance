package fr.groupe3.archives.tpfilrouge.clients;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientServiceArchive {

	@Inject
	private ClientDaoArchive clientDao;

	// methodes individuel
	public ClientArchive get(Integer id) {

		ClientArchive client = clientDao.getClient(id);

		return client;

	}

	public String toJson(ClientArchive client) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(client);
	}

	// methode pour List tous les clients

	public String mapToJson(Map<Integer, ClientArchive> clients) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(clients.values());

		// return new ObjectMapper().writeValueAsString(clients.values());

		return jsonData;
	}

}