package fr.noellie.rest.controller;

import fr.noellie.jpa.model.EtatCommande;
import fr.noellie.rest.dto.OrderRestDto;
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
@Path("/orders") // le nom de la ressource est très souvent au pluriel
@Produces(MediaType.APPLICATION_JSON) // format incontournable en REST
public class OrderRestController {

	@GET
	@Path("/{id}")
	public Response getOrderRestBean(@PathParam("id") Long id) {
		System.out.println("La méthode de récupération de l'order a été appelée avec l'id " + id);

		if (id < 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		OrderRestDto orderRestDto = new OrderRestDto();
		orderRestDto.setId(id);
		orderRestDto.setTypePresta("Hello");
		orderRestDto.setDesignation("");
		orderRestDto.setState(EtatCommande.OPTION);

		return Response.ok(orderRestDto).header("Bonjour !", "Comment ça va?")
				.header("Le lundi", "c'est vachement dur !").build();
	}

	@GET
//	@Path("/json/{id}") // l'URL finale sera de format class+methode
	@Path("/{id}") // l'URL finale sera de format class+methode
	public OrderRestDto getMonPremierRestBeanInJson(@PathParam("id") String id) {
		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
		OrderRestDto orderRestDto = new OrderRestDto();
		orderRestDto.setId((long) 34);
		orderRestDto.setTypePresta("Salut!");
		return orderRestDto;
	}

	@POST
	@Path("/")
	public OrderRestDto post(@Valid OrderRestDto orderRestDto) {
		System.out.println("J'ai récupéré un DTO avec l'id : " + orderRestDto.getId() + " et le nom "
				+ orderRestDto.getTypePresta());

		return orderRestDto;
	}

	@PUT
	@Path("/")
	public OrderRestDto put(OrderRestDto monPremierRestDto) {
		System.out.println("J'ai ajouté un DTO avec l'id : " + monPremierRestDto.getId() + " et le nom "
				+ monPremierRestDto.getTypePresta());

		return monPremierRestDto;
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("J'ai supprimé l'élément avec l'id " + id);
	}

}