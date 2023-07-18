package fr.groupe3.archives.tpfilrouge.commandes;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class CommandeService {

	@Inject
	CommandeDao commandeDao;

	public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	public String toJson(Commande commande) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(commande);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String MapToJson(Map<Integer, Commande> commandeMap) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonData = objectMapper.writeValueAsString(commandeMap.values());
			return jsonData;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Commande get(Integer id) {
		Commande commande = commandeDao.getCommande(id);
		if (commande == null) {
			return null;
		}
		return commande;
	}	
}
