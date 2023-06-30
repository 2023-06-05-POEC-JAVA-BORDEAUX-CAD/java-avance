package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tpjson.model.Client;

public class PojoToJson {
	
public String toJson(Client client) throws JsonProcessingException {
	
	String json = new ObjectMapper().writeValueAsString(client);

	return   json;
};
}
