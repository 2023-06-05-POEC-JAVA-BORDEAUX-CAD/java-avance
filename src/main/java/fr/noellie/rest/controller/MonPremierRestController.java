package fr.noellie.rest.controller;

import fr.noellie.rest.dto.MonPremierRestDto;
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
@Path("/pojo") // le nom de la ressource est très souvent au pluriel
@Produces(MediaType.APPLICATION_JSON) // format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}")
	public Response getMonPremierRestBean(@PathParam("id") Long id) {
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);

		if (id < 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Hello");

		return Response.ok(monPremierRestDto).header("Bonjour !", "Comment ça va?")
				.header("Le lundi", "c'est vachement dur !").build();
	}

	@GET
//	@Path("/json/{id}") // l'URL finale sera de format class+methode
	@Path("/{id}") // l'URL finale sera de format class+methode
	public MonPremierRestDto getMonPremierRestBeanInJson(@PathParam("id") String id) {
		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId((long) 34);
		monPremierRestDto.setName("Salut!");
		return monPremierRestDto;
	}

//	@GET
//	@Path("/text_plain/{id}") // l'URL finale sera de format class+methode
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMonPremierRestBeanInTextPlain(@PathParam("id") String id) {
//		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
//		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
//		monPremierRestDto.setId((long)34);
//		monPremierRestDto.setName("Salut!");
//		return monPremierRestDto.toString();
//	}

	@POST
	@Path("/")
	public MonPremierRestDto post(@Valid MonPremierRestDto monPremierRestDto) {
		System.out.println("J'ai récupéré un DTO avec l'id : " + monPremierRestDto.getId() + " et le nom "
				+ monPremierRestDto.getName());

		return monPremierRestDto;
	}

	@PUT
	@Path("/")
	public MonPremierRestDto put(MonPremierRestDto monPremierRestDto) {
		System.out.println("J'ai ajouté un DTO avec l'id : " + monPremierRestDto.getId() + " et le nom "
				+ monPremierRestDto.getName());

		return monPremierRestDto;
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("J'ai supprimé l'élément avec l'id " + id);
	}

}