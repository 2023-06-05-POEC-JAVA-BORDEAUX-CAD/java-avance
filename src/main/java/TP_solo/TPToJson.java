package TP_solo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TPToJson {
	
	
	/**
	 * Classe transformant des POJOs en JSON
	 */
		
		public String toJson(TPSolo tp) throws JsonProcessingException{
			return new ObjectMapper().writeValueAsString(tp);
		}

	}


