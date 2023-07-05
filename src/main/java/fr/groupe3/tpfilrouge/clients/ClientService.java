package fr.groupe3.tpfilrouge.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.ejb.Stateless;

@Stateless
public class ClientService {

	
		public String toJson(Pojo pojo) throws JsonProcessingException{
			return new ObjectMapper().writeValueAsString(pojo);
		}

	}

	
	
	
}
