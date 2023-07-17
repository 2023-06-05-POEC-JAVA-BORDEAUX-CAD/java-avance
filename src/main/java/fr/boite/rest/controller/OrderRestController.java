package fr.boite.rest.controller;

import java.util.Random;

import fr.boite.philippe.OrderJpa;
import fr.boite.philippe.jsf.controller.OrderJpaService;
import fr.boite.rest.dto.OrderRestDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/rest/v1/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderRestController {

	@Inject
	private OrderJpaService orderJpaService;

	@GET
	@Path("/{id}")
	public OrderRestDto getOrder(@PathParam("id") Integer id) {
		System.out.println("La méthode GET de récupération de la commande a été appelée avec l'id " + id);
		
		OrderJpa entity = orderJpaService.load(id);
				
		OrderRestDto orderRestDto = new OrderRestDto();
		
		orderRestDto.setId(entity.getId());
		orderRestDto.setTypePresta(entity.getTypePresta());
		orderRestDto.setDesignation(entity.getDesignation());
		orderRestDto.setClientId(entity.getClientId());
		
		//orderRestDto.setDesignation("blabla philippe");
		//orderRestDto.setClientId(5);
		return orderRestDto;
	}

	/*
	 * @GET
	 * 
	 * @Path("/{id}") public OrderRestDto getOrder(@PathParam("id") Integer id) {
	 * System.out.
	 * println("La méthode GET de récupération de la commande a été appelée avec l'id "
	 * + id); OrderRestDto orderRestDto = new OrderRestDto();
	 * orderRestDto.setId(id); orderRestDto.setDesignation("blabla philippe");
	 * orderRestDto.setClientId(5); return orderRestDto; }
	 */

	@POST
	@Path("/")
	public OrderRestDto createOrder(@Valid OrderRestDto orderRestDto) {
		if (orderRestDto.getId() == null) {
			orderRestDto.setId((int) new Random().nextLong());
		}
		System.out.println("La méthode POST de création de la commande a été appelée " + orderRestDto.getId()
				+ " et le Designation : " + orderRestDto.getDesignation());
		return orderRestDto;
	}

	@PUT
	@Path("/")
	public OrderRestDto put(OrderRestDto orderRestDto) {
		System.out.println("La méthode PUT de création de la commande a été appelée " + orderRestDto.getId());
		return orderRestDto;
	}

	@DELETE
	@Path("/{id}")
	public void deleteOrder(@PathParam("id") Integer id) {
		System.out.println("La méthode DELETE de suppression de la commande a été appelée avec l'id " + id);

		Response.ok().build();
	}
}
