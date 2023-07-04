package fr.maboite.correction.pojojsonservlet.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;

/**
 * Classe transformant des POJOs en JSON
 */
public class PojoToJson2 {
	
	public String toJson(Pojo2 pojo) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(pojo);
	}

}
