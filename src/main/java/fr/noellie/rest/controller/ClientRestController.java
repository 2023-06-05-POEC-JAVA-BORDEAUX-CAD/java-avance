package fr.noellie.rest.controller;

import fr.noellie.rest.dto.ClientRestDto;
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
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/clients") // le nom de la ressource est très souvent au pluriel
@Produces(MediaType.APPLICATION_JSON) // format incontournable en REST
public class ClientRestController {

	@GET
	@Path("/{id}")
	public Response getClientRestBean(@PathParam("id") Long id) {
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);

		if (id < 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		ClientRestDto clientRestDto = new ClientRestDto();
		clientRestDto.setId(id);
		clientRestDto.setFirstName("Napoléon");
		clientRestDto.setLastName("Bonaparte");

		return Response.ok(clientRestDto).header("Bonjour !", "Comment ça va?")
				.header("Le lundi", "c'est vachement dur !").build();
	}

	@GET
//	@Path("/json/{id}") // l'URL finale sera de format class+methode
	@Path("/{id}") // l'URL finale sera de format class+methode
	public ClientRestDto getClientRestBeanInJson(@PathParam("id") String id) {
		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
		ClientRestDto clientRestDto = new ClientRestDto();
		clientRestDto.setId((long) 34);
		clientRestDto.setFirstName("Napoléon");
		clientRestDto.setLastName("Bonaparte");
		return clientRestDto;
	}

	@POST
	@Path("/")
	public ClientRestDto post(@Valid ClientRestDto clientRestDto) {
		System.out.println("J'ai récupéré un DTO avec l'id : " + clientRestDto.getId() + " et le nom "
				+ clientRestDto.getFirstName() + " " +  clientRestDto.getLastName());

		return clientRestDto;
	}

	@PUT
	@Path("/")
	public ClientRestDto put(ClientRestDto clientRestDto) {
		System.out.println("J'ai ajouté un DTO avec l'id : " + clientRestDto.getId() + " et le nom "
				+ clientRestDto.getFirstName() + " " + clientRestDto.getLastName());

		return clientRestDto;
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("J'ai supprimé l'élément avec l'id " + id);
	}

}