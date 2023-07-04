package dev.loicmoreaux.pojoservlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJson {

	public String toJson(Pojo pojo) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(pojo);	
	}

}