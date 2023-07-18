package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.service.ClientService;
import fr.maboite.correction.jpa.service.OrderFrancoisService;
import fr.maboite.correction.rest.dto.ErrorRestImmutableDto;
import fr.maboite.correction.rest.dto.OrderRestDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Contrôleur REST pour orders
 */
@Stateless
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderRestController {

	@Inject
	private OrderFrancoisService orderFrancoisService;

	@Inject
	private ClientService clientService;

	/**
	 * Mappe GET /orders/{id}
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	public Response getJson(@PathParam("id") Long id) {
		Order order = this.orderFrancoisService.load(id);
		if (order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(new OrderRestDto(order))
				.build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPlain(@PathParam("id") Long id) {
		
		
		Order order = this.orderFrancoisService.load(id);
		
		
		if (order == null) {
			return Response
					.status(Status.NOT_FOUND)
					.entity(
							new ErrorRestImmutableDto("requête invalide",
									"order non trouvé",
									"L'id : " + id + " ne correpond à aucun order."))
					.build();
		}
		return Response.ok(new OrderRestDto(order).toString())
				.build();
	}

	@POST
	@Path("/")
	public Response post(@Valid OrderRestDto orderRestDto) {
		
		if (orderRestDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Order order = orderRestDto.toEntity();

		if (orderRestDto.getClientId() != null) {
			Client client = clientService.getById(orderRestDto.getClientId());
			if (client == null) {
				return Response
						.status(Status.BAD_REQUEST)
						.entity(
								new ErrorRestImmutableDto("requête invalide",
										"client non trouvé",
										"clientId : " + orderRestDto.getClientId() + " ne correpond à aucun client."))
						.build();
			}
			order.setClient(client);
		}

		Order savedOrder = this.orderFrancoisService.save(order);
		
		return Response.ok(new OrderRestDto(savedOrder))
				.build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		Order order = this.orderFrancoisService.load(id);
		if(order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).build();
	}

}