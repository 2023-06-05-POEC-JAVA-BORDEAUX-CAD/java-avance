package fr.maboite.rest.controller;

import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
//@Produces("application/json") // Format JSON incontournable en REST
@Produces(MediaType.APPLICATION_JSON)
public class MonPremierRestController {

	@GET
	@Path("/{id}")
	
	public Response getMonPremierRestBean(@PathParam("id") Long id) {
		System.out.println("la méthode de récupération a été appelée ");
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		
		if(id<0) {
			 return Response.status(Response.Status.NOT_FOUND).build();// méthode chainée
		}
		
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("zouzou");
		
		System.out.println("l'id est " + monPremierRestDto.getId());
		return Response.ok(monPremierRestDto)
				.header("au-fait", "Ca va")
				.header("en-vrai", "c'est dur")
				.build();
	}
	
//	public MonPremierRestDto getMonPremierRestBean() {
//		System.out.println("la méthode de récupération a été appelée ");
//		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
//		monPremierRestDto.setId(56);
//		monPremierRestDto.setName("zouzou");
//		System.out.println("l'id est " + monPremierRestDto.getId());
//		return monPremierRestDto;
//	}

	@POST
	@Path("/")

	public MonPremierRestDto postMonPremierRestBean(@Valid MonPremierRestDto monPremierRestDto) {

		System.out.println("id " + monPremierRestDto.getId());
		System.out.println("name " + monPremierRestDto.getName());
		return monPremierRestDto;
	}

	@PUT
	@Path("/modifications")
	public MonPremierRestDto putMonPremierRestBean(MonPremierRestDto monPremierRestDto) {

		monPremierRestDto.setName("Wembamanya");

		System.out.println("name " + monPremierRestDto.getName());
		return monPremierRestDto;
	}
	
	@DELETE
	@Path("/id")
	public MonPremierRestDto deleteMonPremierRestBean(MonPremierRestDto monPremierRestDto) {
		
			System.out.println("Nous avons supprimé: id " + monPremierRestDto.getId() 
								+ " nom " + monPremierRestDto.getName());
			return null;
	}

}
