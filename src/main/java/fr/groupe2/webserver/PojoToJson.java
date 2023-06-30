package fr.groupe2.webserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJson {

	public String toJson(Cat cat) throws JsonProcessingException {
		String json = new ObjectMapper().writeValueAsString(cat);
		return json;
	}

}