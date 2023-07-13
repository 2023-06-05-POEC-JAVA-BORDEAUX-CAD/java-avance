package dev.loicmoreaux.exorest.controller;

import dev.loicmoreaux.exorest.dto.ExoPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/clients")
@Produces("application/json")
public class ExoPremierRestController {
	
	@GET
	public ExoPremierRestDto getPremierRestDto () {
		System.out.println("GET in progress...");
		ExoPremierRestDto premierRestDto = new ExoPremierRestDto();
		premierRestDto.setId(1);
		premierRestDto.setName("Hello World!");
		return premierRestDto;
	}
	
	@GET
	@Path("/{id}")
	public ExoPremierRestDto getPremierRestDtoById (@PathParam("id") Integer id) {
		System.out.println("GET in progress...");
		ExoPremierRestDto premierRestDto = new ExoPremierRestDto();
		premierRestDto.setId(id);
		premierRestDto.setName("Coucou!");
		System.out.println("création du pojo id : " + id);
		return premierRestDto;
	}
	
	@GET
	@Path("/text")
	@Produces("text/plain")
	public String getTextPlain () {
		System.out.println("GET Text/Plain in progress...");
		
		return "C'est du text plain";
	}
}
