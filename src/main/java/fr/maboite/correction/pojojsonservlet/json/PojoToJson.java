package fr.maboite.correction.pojojsonservlet.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;

/**
 * Classe transformant des POJOs en JSON
 */
public class PojoToJson {
	
	public String toJson(Pojo pojo) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(pojo);
	}

}
