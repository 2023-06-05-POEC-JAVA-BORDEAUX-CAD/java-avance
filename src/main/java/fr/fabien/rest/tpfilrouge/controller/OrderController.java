package fr.fabien.rest.tpfilrouge.controller;

import fr.fabien.rest.tpfilrouge.dto.OrderDto;
import fr.fabien.tpjsf.jpamodel.Order;
import fr.fabien.tpjsf.jpaservice.OrderService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
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
@Path("/order") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class OrderController {

	@Inject
	private OrderService orderService;

	@GET
	@Path("/{id}") // L'URL finale sera : application + classe + méthode on récupère le RestConfig
	public Response getMyOrder(@PathParam("id") Long id) { // <-- correspond à {id}
		System.out.println("La méthode de récupération a été appelée " + id);

		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		Order order = this.orderService.getOrderById(id);
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setTypePresta(order.getType_presta());
		//orderDto.setClientId();
		orderDto.setDesignation(order.getDesignation());
		orderDto.setNbDays(order.getNb_days());
		orderDto.setUnitPrice(order.getUnit_price());
		//orderDto.setState(order.getState());	

		return Response.ok(orderDto).header("coucou", "test").build();
	}

	@POST
	@Path("/")
	public Response postOrderDto(@Valid OrderDto orderDto) {

		System.out.println("ID de la commande : " + orderDto.getId());
		System.out.println("la commande est : " + orderDto.getTypePresta());
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	public void putOrderDto(@PathParam("id") Integer id) {

		System.out.println("ID du client : " + id);
	}

	@DELETE
	@Path("/{id}/{orderId}")
	public void deleteOrderDto(@PathParam("id") Integer id) {

		System.out.println("ID du client : " + id);
	}

}
