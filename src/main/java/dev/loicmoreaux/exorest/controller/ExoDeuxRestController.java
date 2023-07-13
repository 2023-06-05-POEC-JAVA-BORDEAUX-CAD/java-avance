package dev.loicmoreaux.exorest.controller;

import dev.loicmoreaux.exorest.dto.ExoDeuxRestDto;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/exoorders")
@Produces(MediaType.APPLICATION_JSON)
public class ExoDeuxRestController {
	
	@GET
	public ExoDeuxRestDto getNewDto() {
		System.out.println("Obtention d'un DTO");
		return new ExoDeuxRestDto(1, "du contenu dans un nouveau DT0", true);
	}
	
	@POST
	public ExoDeuxRestDto createDto(ExoDeuxRestDto deuxDto) {
		System.out.println("Création d'un nouveau DTO");
		return deuxDto;
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteDto(@PathParam("id") Integer id) {
		System.out.println("Suppression du DTO id : " + id);
		return Response.ok().build();
	}
}
