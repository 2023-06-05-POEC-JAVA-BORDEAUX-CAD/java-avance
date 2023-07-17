package fr.maboite.rest.controller;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/textplain") // Le nom de la ressource est très généralement au pluriel
@Produces("text/plain") // Format text/plain
public class MonPremierRestControllerTextPlain {

	@GET
	@Path("/text")
	public String getPhrase() {
		return "Barbie World";
		
	}
	
	
}
