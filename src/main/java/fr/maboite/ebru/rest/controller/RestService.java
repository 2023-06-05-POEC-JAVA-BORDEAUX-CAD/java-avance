package fr.maboite.ebru.rest.controller;

import fr.maboite.ebru.rest.dto.RestPojoDto;
import jakarta.ejb.Stateless;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Stateless
@Path("/clients") // Le nom de la r essource est très generalement au pluriel
@Produces("application/json") // format incontournable
public class RestService {

	@GET // (recupere l'id
	@Path("/{id}/{name}") // l'url finale sera classe + methode
	public RestPojoDto getRestServiceBean(@PathParam("id") Integer id, @PathParam("name") String name) { // correspond à
																											// {id}

		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id + " et name " + name);
		RestPojoDto restPojoDto = new RestPojoDto();
		restPojoDto.setId(34);
		restPojoDto.setName("salut");

		return restPojoDto;

	}
	
	@POST
	@Path ("/")
	public RestPojoDto post (RestPojoDto restPojoDto) {
		
		System.out.println( "j'ai un DTO où id est : "
				+ restPojoDto.getId()
				+ " et le nom : "
				+ restPojoDto.getName());
		return restPojoDto;
	}
	
	
	@PUT
	@Path ("/")
	public RestPojoDto put (RestPojoDto restPojoDto) {
		
		System.out.println( "j'ai mis update yuhu: "
				+ restPojoDto.getId()
				+ " et le nom : "
				+ restPojoDto.getName());
		
		return restPojoDto;
	}
	
}
