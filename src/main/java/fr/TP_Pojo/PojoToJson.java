package fr.TP_Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ejb.Stateless;


public class PojoToJson {


	public String toJson(Pojo pojo) {
	      ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         return objectMapper.writeValueAsString(pojo);
	         
	      } 
	      catch (JsonProcessingException e) {
	    	  
	         e.printStackTrace();
	         return null;
	      }
	   }
	}