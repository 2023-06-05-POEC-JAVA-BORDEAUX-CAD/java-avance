package fr.fabien.rest;

import fr.fabien.rest.MonPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;

@Stateless
@Path("/oldclient") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}") // L'URL finale sera : application + classe + méthode  on récupère le RestConfig
	public Response getMonPremierRestBean(@PathParam("id") Integer id) {  // <-- correspond à {id}
		System.out.println("La méthode de récupération a été appelée " + id);
		//MonPremierRestDto monPremierRestDto = new MonPremierRestDto(0, id);
		//monPremierRestDto.setId(33);
		//.setName("Salut " + "Bob l'éponge!");
		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Salut!");

		return Response.ok(monPremierRestDto)
				.header("coucou", "test")
				.build();
	}

	@POST
	@Path("/")
	public Response postMonPremierRestDto(@Valid MonPremierRestDto monPremierRestDto) {
		
		System.out.println("ID du client : " + monPremierRestDto.getId());
		System.out.println("name is : " + monPremierRestDto.getName());
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	public void putMonPremierRestBean(@PathParam("id") Integer id) {
		
		System.out.println("ID du client : " + id);
	}

	@DELETE
	@Path("/{id}")
	public void deleteMonPremierRestBean(@PathParam("id") Integer id) {
		
		System.out.println("ID du client : " + id);
	}
	
}
