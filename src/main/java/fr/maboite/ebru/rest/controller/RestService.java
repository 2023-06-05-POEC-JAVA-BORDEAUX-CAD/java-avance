package fr.maboite.ebru.rest.controller;

import fr.maboite.ebru.rest.dto.RestPojoDto;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

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

//	@GET // (recupere l'id
//	@Path("/{id}")
//	public Response getRestServiceBean(@PathParam("id") Integer id) {
//		
//		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);
//
//		if (id < 0) {
//			return Response.status(Status.NOT_FOUND).build();
//			
//		}
//			
//			RestPojoDto restPojoDto = new RestPojoDto();
//			restPojoDto.setId(34);
//			restPojoDto.setName("salut");
//			return Response.ok(restPojoDto).header("au-fait", "ca va").build();
//		}

	

	@POST
	@Path("/")
	public RestPojoDto post(@Valid RestPojoDto restPojoDto) {

		System.out.println("j'ai un DTO où id est : " + restPojoDto.getId() + " et le nom : " + restPojoDto.getName());
		return restPojoDto;
	}

	@PUT
	@Path("/")
	public RestPojoDto put(RestPojoDto restPojoDto) {

		System.out.println("j'ai mis update yuhu: " + restPojoDto.getId() + " et le nom : " + restPojoDto.getName());

		return restPojoDto;
	}

	
	@DELETE
	@Path("/{id}")
	public void delete (@PathParam("id") Integer id) { 

		System.out.println("j'ai supprimé l'id : " + id);

	
	}
	
}
