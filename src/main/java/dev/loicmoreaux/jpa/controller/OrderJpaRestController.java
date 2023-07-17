package dev.loicmoreaux.jpa.controller;

import java.util.List;

import dev.loicmoreaux.jpa.dto.OrderJpaDto;
import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.model.OrderJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
import dev.loicmoreaux.jpa.service.OrderJpaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderJpaRestController {
	
	@Inject
	OrderJpaService orderService;
	
	@Inject
	ClientJpaService clientService;
	
	@GET
	@Path("/test")
	public String getTest() {
		return "Test orders ok";
	}
	
	@GET
	@Path("/{id}")
	public Response getOrderById(@PathParam("id") Integer id) {
		//return orderService.getOrderById(id);
		
		OrderJpa order = orderService.getOrderById(id);
		if(order == null) {
			return Response.status(Status.NOT_FOUND).entity(new MessageRestJpa("Auncun order n'a été trouvé avec l'id : " + id)).build();
		}
		
		OrderJpaDto orderDto = new OrderJpaDto(order);
		return Response.ok(orderDto).build();
	}
	
	@GET
	public Response getOrders() {
		//return orderService.getOrders();
		List<OrderJpa> orders = orderService.getOrders();
		return Response.ok(orders).build();
	}
	
	@POST
	public Response createOrder(OrderJpaDto order) {
		
		ClientJpa client = this.clientService.getClientById(order.getClientId());
		System.out.println("client");
		System.out.println(client);
		if(client == null) {
			return Response.status(Status.BAD_REQUEST).entity(new MessageRestJpa("le clientId ne correspond à aucun client")).build();
		}
		
		OrderJpa orderEntity = order.toEntity();
		orderEntity.setClient(client);
		orderService.save(orderEntity);
		
		return Response.ok(new MessageRestJpa("Order créé avec succès")).build();
		//OrderJpa createdOrder = orderService.save(orderEntity);
		
		//return Response.ok(createdOrder).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteOrder(@PathParam("id") Integer id) {
		orderService.delete(id);
		return Response.ok(new MessageRestJpa("order id " + id + " supprimé")).build();
	}
}
