package fr.groupe2.tpapi.controller;

import java.util.ArrayList;
import java.util.List;

import fr.groupe2.tpapi.dto.OrderDto;
import fr.groupe2.tpapi.model.Client;
import fr.groupe2.tpapi.model.Order;
import fr.groupe2.tpapi.service.ClientService;
import fr.groupe2.tpapi.service.OrderService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

	@Inject
	private OrderService orderService;

	@Inject
	private ClientService clientService;

	@GET
	@Path("/{id}")
	public Response getOrderById(@PathParam("id") Integer id) {
		// Appel du service pour récupérer
		Order order = this.orderService.getOrderById(id);
		if (order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		// order!=null
		return Response.ok(new OrderDto(order)).build();
	}
	
	@GET
	@Path("/")
	public Response getOrders() {
		List<Order> orders = this.orderService.getAllOrders();
		List<OrderDto> ordersDto = new ArrayList<>();
		for(Order order : orders) {
			ordersDto.add(new OrderDto(order));
		}
		return Response.ok(ordersDto).build();
	}

	@POST
	@Path("/")
	public Response createOrder(@Valid OrderDto orderDto) {

		if (orderDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		if (orderDto.getClientId() == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Client client = clientService.getClientById(orderDto.getClientId());

		if (client == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		Order order = orderDto.toEntity();
		// le client correspond à un vrai client en base
		order.setClient(client);

		Order savedOrder = this.orderService.save(order);

		return Response.ok(new OrderDto(savedOrder)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		Order order = this.orderService.getOrderById(id);
		if (order == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		this.orderService.deleteById(id);
		return Response.status(Status.OK).build();
	}

}
